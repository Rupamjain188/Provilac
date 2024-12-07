package ListenerPackege;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Extended_Report;
import utils.utilities;

public class listeners implements ITestListener
{
	private static ExtentReports extent = Extended_Report.GenrateExtendReport(); 
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	WebDriver driver;
	ExtentTest ExtentReport;
	

	@Override
	public void onStart(ITestContext context) {
		ExtentTest testEntry = extent.createTest(context.getName()); 
		test.set(testEntry);
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		ExtentReport = extent.createTest(result.getName());
		ExtentReport.log(Status.INFO,result.getName() +"Test Executing...");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	    ExtentReport.log(Status.PASS,result.getName()+"Test is succesfully Executede.!");
	
	}

	@Override
    public void onTestFailure(ITestResult result) {
        
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        if (driver != null) {
            String destinationScreenshotPath = utilities.captureScreenshot(driver, result.getName());

            ExtentTest extentTest = test.get();
            extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
            extentTest.log(Status.INFO, result.getThrowable());
            extentTest.log(Status.FAIL, result.getName() + " got failed");
        }
    }
	

	@Override
	public void onFinish(ITestContext context) {
	    extent.flush();
	    String pathOfExtendReport = System.getProperty("user.dir") + "\\test-output\\ExtentReport\\extentreport.html";
	    File ExReport = new File(pathOfExtendReport);
	    
	    if (Desktop.isDesktopSupported()) {
	        try {
	            Desktop.getDesktop().browse(ExReport.toURI());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Desktop is not supported. Cannot open the report automatically.");
	    }
	}


}


