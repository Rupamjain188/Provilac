package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {
    private static Properties properties;
    private static final String[][] Object = null;
    
    public static Object[][] GetTtestDataFromExel(String sheetName)
    { 
     	
    	File exalfile=new File(System.getProperty("user.dir")+"D:\\Provilac_Pro\\SeleniumProvilac\\src\\main\\java\\provilac\\properties\\configure.propertiesFile");
   	
   XSSFWorkbook workbook = null;
   	 	
   	 	
    	try {
	     	FileInputStream inputstrem=new FileInputStream(exalfile);
	 	    workbook=new XSSFWorkbook(inputstrem);
		} catch (Throwable e) {
		  e.printStackTrace();
		}
    	
   
   XSSFSheet sheet=workbook.getSheet(sheetName);
return null;
    	

    
}
    public static String captureScreenshot(WebDriver driver, String testName) {
        File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationScreenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + testName + ".png";
        
        // Create directory if it does not exist
        File directory = new File(System.getProperty("user.dir") + "\\Screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try {
            FileUtils.copyFile(srcScreenshot, new File(destinationScreenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return destinationScreenshotPath;
    }
    
}
