/**
 *
 * @author Rodrigo
 */

package material;

// Importa el contenido de clase "Material".
import com.mycompany.ejercicios_practica9.Material;
// Importa el paquete ".io" con todas las clases, interfaces, etc.
import java.io.*;
// Importa el paquete ".util" con todas las clases, interfaces, etc.
import java.util.*;


public class csv{
    // Crea una función de nombre "writeCSV" con la que escribir archivos de extensión ".csv", recibe un nombre de archivo y dos números enteros que serán almacenados posteriormente.
    void writeCSV(String file, int index, int number){
        try{
            // Envuelve un flujo en otro para ser tratado.
            FileWriter fileWriter = new FileWriter(file, true);
            // Manipula el flujo de datos como si fuese un "buffer"
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            // Permite escribir el archivo con muchas más funcionalidades adicionales para diferentes tipos de datos.
            PrintWriter printwriter = new PrintWriter(bufferedWriter);
            printwriter.println(index + ", " + number);
            
            printwriter.flush();
            printwriter.close();
            
        } catch (IOException e){
            System.err.println("Error de EntradaSalida" + e.getMessage());
        }
    }
    
    // Crea una función que lee y muestra el contenido del archivo creado.
    int [] readCSV(String file, int n) throws IOException){
        int [] array = new int[n];
        
        FileReader fileReader = new FileReader(file);
        BufferReader bufferReader = new BufferReader(fileReader);
        
        String line = null;
        int count = 0;
        
        while ((line = bufferReader.readLine()) != null){
            // Crea un separador.
            String [] parts = line.split(",");
            // Lee el string.
            int total_parts = parts.length;
            
            for (int i = 0; i < total_parts; i++){
                int aux = 0;
                if (i%2 != 0){
                    array[count] = Integer.parseInt(parts[i]);
                    count ++;
                }
            }
        }
        // Devuleve el último valor obtenido dentro del array al acabar el bucle.
        return array;
    }
    
    // Crea el método principal del programa.
    public static void main(String[] args){
        // Crea la colección de tipo "ArrayList" donde almacenar lso objetos.
        ArrayList<Material> listamaterial = new ArrayList<>();
        
        // Añade 
        listamaterial.add(new Material("Cuaderno", 1000, 2.00));
        listamaterial.add(new Material("Estuche", 235, 1.75));
        listamaterial.add(new Material("Borradores", 333, 1.15));
        listamaterial.add(new Material("Sacapuntas", 189, 1.00));
    }
}