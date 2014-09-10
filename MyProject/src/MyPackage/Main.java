package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
	
	// declaration of the elements
	// homepage button
	public final By ELEMENT_HOMEPAGE_SIDEBOX_CALENDARBUTTON =  By.xpath("//*[@data-original-title='Calendar']");
	
	// calendar page button
	public final By ELEMENT_CALENDAR_QUICKADDEVENTBUTTON = By.id("UIActionBarQuickAddEvent");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD = By.id("eventName");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Save']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='More Details']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX = By.xpath("//*[@id='UIQuickAddEvent']//*[@name = 'allDay']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_CANCEL =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Cancel']");
	
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS =  By.xpath ("//*[@data-toggle='tab' and text()='Reminders']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS =  By.xpath ("//*[@data-toggle='tab' and text()='Participants']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE =  By.xpath ("//*[@data-toggle='tab' and text()='Schedule']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON = By .xpath("//*[@id='UIEventForm']//*[text()='Save']");
	
	
	public static void main(String[] args) throws InterruptedException {
		
        // declaration and instantiation of objects/variables
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://localhost:8080/portal/intranet";
		String username = "root";
		String password = "gtn";
		String eventTest = "event test1";
		String eventTest2 = "event <test2>";
		String eventTest3 = "event test3";
		Calendar calendar= new Calendar();
		
		
		Log.main(driver, baseUrl, username, password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		calendar.open(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		calendar.test1(driver, eventTest);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		calendar.test2(driver, eventTest2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		calendar.test3(driver, eventTest3);
		
		
	  }
	
	
}	  
