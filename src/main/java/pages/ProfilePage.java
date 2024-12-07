package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage 
{
	   private WebDriver driver;

	    // Locators
	    By nameField = By.xpath("/html/body/app-root/app-edit-profile/main/div/div/div/div/form/div[1]/div[1]/input");
	    By email = By.xpath("//div[2]//input[1]");
	    By update_Button =By.xpath("//button[@id='update-btn']");
	    
	    // Constructor
	    public ProfilePage(WebDriver driver) {
	        this.driver = driver;
	    }
       
	    public void emailupadate(String email)
	    {
	    	driver.findElement(this.email).clear();
	    	driver.findElement(this.email).sendKeys(email);
	    }
	   
	    // Methods
	    public void updateName(String name) {
	        driver.findElement(nameField).clear();
	        driver.findElement(nameField).sendKeys(name);
	    }
	    
	    public void Update_Button() {
	        driver.findElement(update_Button).click();
	    }


}

