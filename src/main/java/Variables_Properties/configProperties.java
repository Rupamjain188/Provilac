package Variables_Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// This is config class so we can get config properties to directly Ex= p

   public class configProperties 
  { 
	  public static Properties property;
      private static String configPath = "configuration/configure.propertiesFile";

      static 
      {
      initializeProperty();
      }

      private static void initializeProperty() 
  {
      property = new Properties();
    
      try (InputStream instm = new FileInputStream(configPath)) {
        property.load(instm);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

     public static String getProperty(String key) 
   {
     return property.getProperty(key);
   }
     
}
