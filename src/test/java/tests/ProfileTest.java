package tests;

import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Variables_Properties.configProperties;
import pages.LoginPage;
import pages.ProfilePage;
import utils.BaseClass;

public class ProfileTest extends BaseClass {
	ProfilePage ProfilePage;
	LoginPage LoginPage;
	public WebDriver driver;
		
	@BeforeMethod
	 public void start() throws InterruptedException
	 {
		driver= setUp("chrome");
		
	 }


	@Test
    public void testProfileUpdateWithValidData() throws InterruptedException {
		// Add assertions to verify login success
    	LoginPage LoginPage=new LoginPage(driver);
        // Step 1: Close city popup
    	Thread.sleep(2000);
    	LoginPage.clickCityPopup();

        // Step 2: Click on Guest button to proceed without login
        LoginPage.clickGuestButton();
        
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

        LoginPage.Pop_up();
        
        // Step 7: Enter OTP in the OTP field
        LoginPage.enterOtp(otp);

        // Step 8: Click the OTP button again to submit the OTP
        LoginPage.clickOtpButton();
        Thread.sleep(2000);
        
 // Set Profile With valid Update.
         ProfilePage ps=new ProfilePage(driver);
         ps.emailupadate("rupamjain@gmail.com");
     	 Thread.sleep(2000);
     	   
     	  ps.updateName("Harshal Patil");
          Thread.sleep(2000);
     	  ps.Update_Button();
     	  Thread.sleep(2000);
     	  System.err.println("|| Profile Update successful...! ||");
     	
     // Validate success message or state
    	  Assert.assertTrue(driver.findElement(By.linkText("Harshal Patil")).isDisplayed(),"Accouct informaction link is display");
    	  System.out.println("Profile Update successful...! And Validate success..! ");
    	
        

        
// Set Profile With Invalid Update.
        
      ProfilePage ps2=new ProfilePage(driver);
      
      driver.navigate().back();
        
      ps.emailupadate(configProperties.property.getProperty("Email"));
      Thread.sleep(3000);
    	   
      ps2.updateName("");
      Thread.sleep(3000);
      ps2.Update_Button();
      Thread.sleep(2000);
    	  
      String expectedMessage = "Please enter the valid email id.";
      WebElement errorMessage = driver.findElement(By.xpath("//*[normalize-space(text())='Please enter the valid email id.']"));
      Assert.assertEquals(errorMessage.getText().trim(), expectedMessage, "Error message mismatch!");

      System.out.println("Profile Update successful...!");
      
            
 // Set Profile With Invalid Update.
      
      ProfilePage ps3=new ProfilePage(driver);
      
      //  driver.navigate().back();
        
      ps3.emailupadate(configProperties.property.getProperty("Email2"));
      Thread.sleep(3000);
    	   
      ps3.updateName(configProperties.property.getProperty("Name2"));
      Thread.sleep(3000);
      ps3.Update_Button();
      Thread.sleep(2000);
    	  
      String expectedMessag2 = "Please enter the valid email id.";
      WebElement errorMessage2 = driver.findElement(By.xpath("//*[normalize-space(text())='Please enter the valid email id.']"));
      Assert.assertEquals(errorMessage2.getText().trim(), expectedMessag2, "Error message mismatch!");

      System.out.println("Profile Update NOT Updated...!");
      
      
// Set Profile With Invalid, with this email already exists Update.
      
      ProfilePage ps4=new ProfilePage(driver);
      
      //driver.navigate().back();
        
      ps4.emailupadate(configProperties.property.getProperty("Email3"));
      Thread.sleep(3000);
    	   
      ps4.updateName(configProperties.property.getProperty("Name3"));
      Thread.sleep(2000);
      ps4.Update_Button();
      Thread.sleep(2000);
    
       /// Wait for the alert to be displayed and switch to it 
       Alert alert = driver.switchTo().alert(); 
       String alertText = alert.getText(); 
       System.out.println("Alert text is: " + alertText); 
       alert.accept();
       
       // Assert the alert text
       Assert.assertEquals(alertText, "User with this email already exists");
       
       System.out.println("Profile should not be updated...!");
      
    }
	
	@AfterClass
    public void TearDown()
    {
    	driver.quit();
    }

   
}
