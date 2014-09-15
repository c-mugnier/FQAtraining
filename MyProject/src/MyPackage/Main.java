package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Main {
	
	// declaration of the elements	
	String eventTestName = " ";
	
	// Home page button
	public final By ELEMENT_HOMEPAGE_SIDEBOX_CALENDARBUTTON =  By.xpath("//*[@data-original-title='Calendar']");

	// calendar page button
	public final By ELEMENT_CALENDAR_QUICKADDEVENTBUTTON = By.id("UIActionBarQuickAddEvent");
	public final By ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON = By.xpath("//*[@data-original-title = 'Calendar Actions']");
	public final By ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE = By.xpath("//*[@id='tmpMenuElement']//*[@class='uiIconCalCreateEvent uiIconLightGray']");
	public final String ELEMENT_CALENDAR_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT = "//*[@class='UICalendarPopupAction']//*[text()='${calName}']/../..//*[@data-original-title='Delete']";
	public final By ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT_ALERT = By.xpath("//*[@class='uiAction uiActionBorder']//*[text()='OK']");
	public final By ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_CLOSEBUTTON = By.xpath("//*[@class='uiAction uiActionBorder']//*[text()='Close']");
	
	// quick add event 
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD = By.id("eventName");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Save']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='More Details']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX = By.xpath("//*[@id='UIQuickAddEvent']//*[@name = 'allDay']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_CANCEL =  By.xpath ("//*[@id='UIQuickAddEventPopupWindow']//*[text()='Cancel']");
	//quick add event more details	
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS =  By.xpath ("//*[@data-toggle='tab' and text()='Reminders']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS =  By.xpath ("//*[@data-toggle='tab' and text()='Participants']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE =  By.xpath ("//*[@data-toggle='tab' and text()='Schedule']");
	public final By ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON = By .xpath("//*[@id='UIEventForm']//*[text()='Save']");

	public final By ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW = By.xpath("//*[@deschtml='event test5']/../..//*[@class='eventContainerBar eventTitle']/../..//*[@class='uiIconCallowPriority']");
	public final By ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL = By.xpath("//*[@deschtml='event test5']/../..//*[@class='eventContainerBar eventTitle']/../..//*[@class='uiIconCalnormalPriority']");
	public final By ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_HIGH = By.xpath("//*[@deschtml='event test5']/../..//*[@class='eventContainerBar eventTitle']/../..//*[@class='uiIconCalhighPriority']");
	public final String ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY ="//*[@ class='eventAlldayContent asparagus' and text()='${name}']"; 
	public final String ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT = "//*[@id='UIWeekViewGrid']//div[contains(text(),'${name}')]";
	
	
	
	
	
	
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
		Calendar calendar= new Calendar();
		
		
		// log onto exopPLF
		Log.main(driver, baseUrl, username, password);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//click on the calendar button
		calendar.open(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// execute the test suite
		calendar.test1(driver, eventTest);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test2(driver, eventTest2);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test3(driver, eventTest3);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test4(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		calendar.test5(driver, eventTest5);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		calendar.test6(driver, eventTest6); 
		
		
	  }
	
	
}	  
