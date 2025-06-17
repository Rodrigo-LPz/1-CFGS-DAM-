  include <dht.h>

  #define dht_apin AO // Analog Pin sensor is connected to

  dht DHT;

  void setup () {
    Serial.begin(9600);
    delay(500) ;//Delay to let system boot
    Serial.printin("DHT11 Hunidity & temperature Sensor\n\n");
    delay(1000) ;//Wait before accessing Sensor

  }//end "setup ()”

  void Loop() {
  // Start of Program

  DHT. readll (dht_apin);

    Serial.print("Current humidity = ");
    Serial.print(DHT.humidity);
    Serial.print("% ");
    Serial.print(“temperature = ");  
    Serial.print(DHT.temperature);
    Serial.print("C ");

  delay (5000);//Wait 5 seconds before accessing sensor again.

  //Fastest should be once every two seconds

  }//end loop ()