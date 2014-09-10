package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar extends Main {
	public Calendar() {
		
		
	}
	
	public void open(WebDriver driver) {
		//Click on the calendar button
		driver.findElement(ELEMENT_HOMEPAGE_SIDEBOX_CALENDARBUTTON).click();
	}
	
	
	public void test1(WebDriver driver, String eventTest) {
		//Click on the add quick event button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		//Set the event name
		WebElement eventTitle =driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD);
		eventTitle.sendKeys(eventTest);
		//wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Click on valid button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
	}
	
	
	public void test2(WebDriver driver, String eventTest2) {
		
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest2);
		//Display all the tabs
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement (ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
	
	
	}
	
	public void test3(WebDriver driver, String eventTest3) {
		//Click on the add quick event button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement eventTitle =driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD);
		eventTitle.sendKeys(eventTest3);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
	}
	
}
