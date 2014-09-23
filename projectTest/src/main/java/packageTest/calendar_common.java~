package packageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class calendar_common {


	// declaration of the elements	

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

	protected static WebDriver driver;

	public calendar_common(WebDriver driver){
		calendar_common.driver = driver;
	}
	
	
	public void open() {

		//Click on the calendar button
		driver.findElement(ELEMENT_HOMEPAGE_SIDEBOX_CALENDARBUTTON).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	public void addEvent(String testName) {
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		driver.findElement(By.id("eventName")).sendKeys(testName);
	}


	public void addEventByRightClick (String testName) {
		Actions action= new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//*[contains(@startfull,'08:00:00') and @class='tdLine today none']"))).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		driver.findElement(By.xpath("//*[@class='createEvent']")).click();
		driver.findElement(By.id("eventName")).sendKeys(testName);
	}


	public By clearData(By path) {

		Actions action= new Actions(driver);
		Assert.assertTrue(driver.findElement(path).isDisplayed());
		action.contextClick(driver.findElement(path)).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='uiIconDelete uiIconLightGray']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='uiAction uiActionBorder']/..//*[@class='btn' and text()=' Yes ']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return path;
	}
}
