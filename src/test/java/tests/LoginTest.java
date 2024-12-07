package tests;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Variables_Properties.configProperties;
import pages.LoginPage;
import utils.BaseClass;

public class LoginTest extends BaseClass   {
	public WebDriver driver;
	 LoginPage LoginPage;
	 
	 public LoginTest()
 	{
 		super();
 	}
	 
   @BeforeMethod
	 public void start()
	 {
		driver= setUp("chrome");
	 }
   
    @Test 
    public void testLogin() throws InterruptedException {
    	// Add assertions to verify login success
    	LoginPage LoginPage=new LoginPage(driver);
        // Step 1: Close city popup
    	Thread.sleep(2000);
    	LoginPage.clickCityPopup();

        // Step 2: Click on Guest button to proceed without login
        LoginPage.clickGuestButton();
        Thread.sleep(1000);
        
        LoginPage.my_profile();
        
        LoginPage.Sign_In();
        Thread.sleep(2000);
        
        // Step 3: Enter valid phone number
        LoginPage.enterPhoneNumber(configProperties.property.getProperty("moblieNO"));

        // Step 4: Check the terms checkbox
         LoginPage.checkTerms();

        // Step 5: Click the OTP button to send OTP
        LoginPage.clickOtpButton();
        Thread.sleep(3000);

        // Step 6: Wait for OTP input (manual input via Scanner)
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the OTP received on your phone: ");
        String otp = scanner.nextLine();  // Wait for user input for OTP

        LoginPage.Pop_up();  //Skip the PopUp window
        
        // Step 7: Enter OTP in the OTP field
        LoginPage.enterOtp(otp);

        // Step 8: Click the OTP button again to submit the OTP
        LoginPage.clickOtpButton();
        Thread.sleep(2000);
    }
    @AfterClass
    public void TearDown()
    {
    	driver.quit();
    }
    }
