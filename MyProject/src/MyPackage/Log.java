package MyPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Log {
    
	    public static void main(WebDriver driver, String baseUrl, String username, String password) {
	    
	        // launch Firefox and direct it to the Base URL
	        driver.get(baseUrl);
	        driver.manage().window().maximize();
	    
	 
	        //Fill the login text-box
	        WebElement userName =driver.findElement(By.id("username"));
	        userName.sendKeys(username);
	        
	       
	        //Fill the password text-box
	        WebElement pass =driver.findElement(By.id("UIPortalLoginFormControl"));
	       	pass.sendKeys(password);
	        
	        //Click on the sign-in button
	      	driver.findElement(By.xpath("//*[@id='UIPortalLoginFormAction']/*[text()='Sign In']")).click();
	    }
	 
	}
