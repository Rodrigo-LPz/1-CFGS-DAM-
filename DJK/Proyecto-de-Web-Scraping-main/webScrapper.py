import os
import sys
import time
import re
import json
import threading
import tkinter as tk
from tkinter import messagebox, scrolledtext
import datetime
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.chrome.service import Service as ChromeService
from webdriver_manager.chrome import ChromeDriverManager

class WebScraperApp:
    def __init__(self, root):
        self.root = root
        self.root.title("Web Scraper GUI")
        self.root.geometry("600x400")
        
        self.urls = []
        self.running = False
        self.stop_event = threading.Event()
        self.thread = None
        self.monitor_count = 1  # Contador de monitorizaciones
        self.current_session = None  # Para almacenar la sesión actual
        
        self.json_file = "datos_productos.json"
        self.json_data = {"monitorizations": []}
        self.init_json()
        
        self.label = tk.Label(root, text="Ingrese la URL del producto:")
        self.label.pack()
        
        self.url_entry = tk.Entry(root, width=50)
        self.url_entry.pack()
        
        self.add_button = tk.Button(root, text="Agregar URL", command=self.add_url)
        self.add_button.pack()
        
        self.start_button = tk.Button(root, text="Iniciar Scraper", command=self.start_scraper)
        self.start_button.pack()
        
        self.stop_button = tk.Button(root, text="Detener Scraper", command=self.stop_scraper, state=tk.DISABLED)
        self.stop_button.pack()
        
        self.text_area = scrolledtext.ScrolledText(root, width=70, height=15)
        self.text_area.pack()
        
        self.clear_button = tk.Button(root, text="Limpiar", command=self.clear_text)
        self.clear_button.pack()
    
    def init_json(self):
        # Inicializa el archivo JSON con la estructura vacía
        with open(self.json_file, "w", encoding="utf-8") as f:
            json.dump(self.json_data, f, indent=4)
    
    def save_json(self):
        # Guarda los datos en el archivo JSON
        with open(self.json_file, "w", encoding="utf-8") as f:
            json.dump(self.json_data, f, indent=4, ensure_ascii=False)
    
    def add_url(self):
        url = self.url_entry.get()
        if url:
            self.urls.append(url)
            self.text_area.insert(tk.END, f"URL Agregada: {url}\n")
            self.url_entry.delete(0, tk.END)
        else:
            messagebox.showwarning("Aviso", "Ingrese una URL válida.")
    
    def start_scraper(self):
        if not self.urls:
            messagebox.showwarning("Aviso", "Debe agregar al menos una URL antes de iniciar el scraper.")
            return
        
        # Crear una nueva sesión de monitorización
        monitor_message = f"Monitorización {self.monitor_count}"
        self.text_area.insert(tk.END, f"{monitor_message}\n")
        self.current_session = {
            "monitorizacion": self.monitor_count,
            "comentario": monitor_message,
            "productos": []
        }
        self.json_data["monitorizations"].append(self.current_session)
        self.save_json()
        self.monitor_count += 1
        
        self.running = True
        self.stop_event.clear()
        self.start_button.config(state=tk.DISABLED)
        self.stop_button.config(state=tk.NORMAL)
        self.thread = threading.Thread(target=self.monitorizar_productos, kwargs={'intervalo': 10})
        self.thread.start()
    
    def stop_scraper(self):
        if not self.running:
            return
        self.running = False
        self.stop_event.set()
        self.text_area.insert(tk.END, "Deteniendo el scraper...\n")
        if self.thread and self.thread.is_alive() and threading.current_thread() != self.thread:
            self.thread.join(timeout=5)
        self.urls = []  # Limpia la lista de URLs
        self.start_button.config(state=tk.NORMAL)
        self.stop_button.config(state=tk.DISABLED)
        self.text_area.insert(tk.END, "URLs borradas. Debe ingresar nuevas URLs para continuar.\n")
    
    def clear_text(self):
        self.text_area.delete('1.0', tk.END)
    
    def extraer_datos(self, url, driver):
        driver.get(url)
        time.sleep(3)  # Espera a que cargue el contenido dinámico
        html = driver.page_source
        soup = BeautifulSoup(html, "html.parser")
        
        elemento_nombre = soup.find("h1")
        nombre = elemento_nombre.get_text(strip=True) if elemento_nombre else "Nombre no encontrado"
        
        precio = None
        elemento_precio = soup.find("span", class_="price")
        if elemento_precio:
            precio = elemento_precio.get_text(strip=True)
        if not precio:
            texto_completo = soup.get_text()
            match = re.search(r"(\d+[,.]?\d*)\s?€", texto_completo)
            if match:
                precio = match.group(0)
        if not precio:
            precio = "Precio no encontrado"
        
        fecha = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
        return {"nombre": nombre, "precio": precio, "fecha": fecha, "url": url}
    
    def monitorizar_productos(self, intervalo=10):
        chrome_options = Options()
        chrome_options.add_argument("--headless")
        chrome_options.add_argument("--log-level=3")
        chrome_options.add_argument("--user-agent=Mozilla/5.0")
        
        driver = webdriver.Chrome(
            service=ChromeService(ChromeDriverManager().install()),
            options=chrome_options
        )
        
        try:
            # Utilizamos un bucle con índice para acceder a la lista de URLs en cada iteración
            while self.running:
                i = 0
                while self.running and i < len(self.urls):
                    url = self.urls[i]
                    datos = self.extraer_datos(url, driver)
                    self.text_area.insert(tk.END, f"Producto: {datos['nombre']} | Precio: {datos['precio']} | Fecha: {datos['fecha']}\n")
                    # Agregar el producto a la sesión actual
                    if self.current_session is not None:
                        self.current_session["productos"].append(datos)
                        self.save_json()
                    i += 1
                if self.stop_event.wait(timeout=intervalo):
                    break
        finally:
            driver.quit()
            self.text_area.insert(tk.END, "Scraper detenido.\n")

if __name__ == "__main__":
    root = tk.Tk()
    app = WebScraperApp(root)
    root.mainloop()























