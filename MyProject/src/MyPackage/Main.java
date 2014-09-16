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
		String eventTest2 = "event <test2>";
		String eventTest3 = "event test3";
		String eventTest5 = "event test5";
		String eventTest6 = "duplicated name";
		calendar_test calendar = new calendar_test(driver);
		
		
		// log onto exopPLF
		Log.main(driver, baseUrl, username, password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//click on the calendar button
		calendar.open();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// execute the test suite
		calendar.test1(eventTest);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test2(eventTest2);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test3(eventTest3);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test4();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test5(eventTest5);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		calendar.test6(eventTest6); 
		
		
	  }
	
	
}	  
