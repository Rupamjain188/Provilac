package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	 WebDriver driver;
	// Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
   
	    By cityPopup = By.xpath("//*[@id=\"modalModifier\"]/app-city-selection/div/div/a[1]/div/a");
	    By guestButton = By.xpath("//a[normalize-space()='Guest']");
	    By sign_in = By.xpath("//a[normalize-space()='SIGN IN']");
	    By My_profile = By.xpath("//a[@class='dropdown-item'][normalize-space()='My Profile']");
	    By phoneNumberField = By.xpath("//*[@id=\"app-download-code\"]");
	    By Login_Button = By.xpath("//div[@class='dropdown-item cursor-pointer']");
	    By Pop_up = By.xpath("//*[@id=\"enquiry-form\"]/div/div/div/button/img");
	    By termsCheckbox = By.xpath("//input[@id='check-terms']");
	    By otpButton = By.xpath("//button[@id='otp-btn']");
	    By Insert_OTP = By.xpath("//input[@id='app-download-code']");

    // Actions for interacting with the login page
    public void clickCityPopup() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(cityPopup).click();
    }
    public void clickGuestButton() throws InterruptedException {
    	//Thread.sleep(2000);
        driver.findElement(guestButton).click();
    }
       public void my_profile() throws InterruptedException {
    	//Thread.sleep(2000);
    	
        driver.findElement(My_profile).click();
    }
        public void Login_in() throws InterruptedException {
    	//Thread.sleep(2000);
    	
        driver.findElement(Login_Button).click();
    }
        public void Sign_In() throws InterruptedException {
    	Thread.sleep(2000);
    	
        driver.findElement(sign_in).click();
    }
    public void enterPhoneNumber(String phoneNumber) throws InterruptedException {
    	
        driver.findElement(phoneNumberField).sendKeys("9423238892");
        //Thread.sleep(2000);
    }
    public void checkTerms() {
        driver.findElement(termsCheckbox).click();
    }
    public void Pop_up() throws InterruptedException {
    	 Thread.sleep(3000);
        driver.findElement(Pop_up).click();
    }
        
    public void clickOtpButton() throws InterruptedException {
    	 Thread.sleep(3000);
        driver.findElement(otpButton).click();
    }

    public void enterOtp(String otp) {
        driver.findElement(Insert_OTP).sendKeys(otp);
    }
}
