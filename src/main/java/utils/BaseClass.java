package utils;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Variables_Properties.configProperties;

public class BaseClass 
{
	  WebDriver driver;
	  public Properties pro;
	
	  public void PropertiesFile()
	  {
		  pro=new Properties();
    	  File fl=new File(System.getProperty("user.dir")+"/src/main/java/provilac/properties/configure.propertiesFile");
    	  
    	 try {
			 FileInputStream file=new FileInputStream(fl);
    	         pro.load(file);
		} 
    	 catch (Throwable e)      
    	  
    	    {
			e.printStackTrace();
			
		}
    	  
	  }
	
	
	    public WebDriver setUp(String broswerN) 
	    {
	    
	    	if (broswerN.equalsIgnoreCase("chrome")) 
			{
				driver=new ChromeDriver();
			}
			else if (broswerN.equalsIgnoreCase("ferfox")) 
			{
			   driver=new FirefoxDriver();	
			}
	    	
	        driver.manage().window().maximize();
	        driver.get(configProperties.property.getProperty("url"));
	        System.out.println("Navigated to Provilac.");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			return driver;
        }
}
