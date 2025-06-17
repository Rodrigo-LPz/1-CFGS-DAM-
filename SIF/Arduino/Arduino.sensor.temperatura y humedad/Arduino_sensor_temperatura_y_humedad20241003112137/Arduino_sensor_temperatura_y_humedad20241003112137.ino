#include <DHT.h>

#define DHTPIN 2       // Pin de datos para el DHT11
#define DHTTYPE DHT22  // Tipo de sensor, puedes cambiar por DHT22

float humedad;
float temperaturaC;
float temperaturaF;
float sensacionC;
float sensacionF;

DHT sensorDHT(DHTPIN, DHTTYPE); // Crear el objeto de tipo DHT

void setup() {
  Serial.begin(9600);
  sensorDHT.begin();
}

void loop() {
  delay(2000); // Retardo de 2 segundos para el sensor

  humedad = sensorDHT.readHumidity();
  temperaturaC = sensorDHT.readTemperature();
  temperaturaF = sensorDHT.readTemperature(true);

  if ( isnan(humedad) || isnan(temperaturaC) || isnan(temperaturaF) ) {
    Serial.println("Error en la lectura del sensor");
    return;   // Si hubo un error en la lectura, el programa sale,
              // reiniciando la función loop,
  }           // si no hubo error, el programa continúa.

  sensacionC = sensorDHT.computeHeatIndex(temperaturaC,humedad,false);
  sensacionF = sensorDHT.computeHeatIndex(temperaturaF,humedad);

  Serial.println("Humedad Relativa: ");
  Serial.print(humedad);
  Serial.println("%");
  Serial.println("Temperatura: ");
  Serial.print(temperaturaC);
  Serial.println(" ºC");
  Serial.print(temperaturaF);
  Serial.println(" ºF");
  Serial.println("Sensacion Termica: ");
  Serial.print(sensacionC);
  Serial.println(" ºC");
  Serial.print(sensacionF);
  Serial.println(" ºF");
}