package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
	public static void main(String[] args) throws InterruptedException {
		
        // declaration and instantiation of objects/variables
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/portal/intranet";
		String username = "root";
		String password = "gtn";
		String eventTest = "event test1";
		String eventTest2 = "event test2";
		
		Log.main(driver, baseUrl, username, password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Calendar.open(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Calendar.test1(driver, eventTest);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Calendar.test2(driver, eventTest2);
		
		
		
	  }
	
	
}	  
