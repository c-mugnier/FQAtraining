package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
		

		
		//Click on the save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
	}
	
	
	public void test2(WebDriver driver, String eventTest2) {
		
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest2);
		
		//Display all the tabs
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();

		driver.findElement (ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS).click();

		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS).click();

		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
		assert driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).isDisplayed();
		
	
	}
	
	public void test3(WebDriver driver, String eventTest3) {
		
		// click on the add quick event button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();

		
		// set the event's title
		WebElement eventTitle =driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD);
		eventTitle.sendKeys(eventTest3);

		
		// check the allDay box
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX).click();

		
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
	}
	
	
	public void test4(WebDriver driver) {
		
		// click on option button in calendar box
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON).click();
		
		// select add event in the list
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE).click();
		
		// click on delete on the event categorie "all"
		driver.findElement(By.xpath(ELEMENT_CALENDAR_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT.replace("${calName}", "All"))).click();
		
		// click on the ok button in the alert window
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT_ALERT).click();
	}
	
	public void test5(WebDriver driver, String eventTest5) {
		

		int i = 0;
		for(i = 0; i<=2; i++) {
		// open add event form and set the name
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();	
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest5);
		
		//Display the details
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
		Select drpPriority = new Select(driver.findElement(By.name("priority")));
		if (i==0)
			drpPriority.selectByVisibleText("High");
		else if (i==1)
			drpPriority.selectByVisibleText("Normal");
		else if (i==2)	
			drpPriority.selectByVisibleText("Low");
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		}
	}
	
	public void test6(WebDriver driver, String eventTest6) {
		
		int j = 0;
		for(j = 0; j<=2; j++) {
		// open add event form and set the name
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();	
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest6);
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("je suis a " + j);
		}
	}
	
}
