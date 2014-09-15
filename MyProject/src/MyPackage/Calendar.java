package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Calendar extends Main {
	public Calendar() {
		
		
	}
	
	public void open(WebDriver driver) {
		
		//Click on the calendar button
		
		driver.findElement(ELEMENT_HOMEPAGE_SIDEBOX_CALENDARBUTTON).click();
	}
	
	public By clearData(WebDriver driver, By path) {
		
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
	
	/* 
	 	* test ID : 99886
		* test name : Add quick event from calendar view by right click
		* Step 1 : Click on the add quick event button
		* Step 2 : Set the event name
		* Step 3 : Save the new event
		* Step 4 : Verify
		* Step 5 : clear data
	*/	
	public void test1(WebDriver driver, String eventTest) {
		
		//Click on the add quick event button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		
		//Set the event name
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD).sendKeys(eventTest);
		

		
		//Click on the save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// verify the test
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest))).isDisplayed(), "test fail");
		
		// clear data
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest));
		clearData(driver, path);
	}
	
	/*
	   	* test ID : 99868
	 	* test name : Add new event with special characters
	 	* Step 1 : Open the event creation
	 	* Step 2 : Display all the tabs
	 	* Step 3 : Save the event
	 	* Step 4 : Verify
	 	* Step 5 : clear data
	*/	
	public void test2(WebDriver driver, String eventTest2) {
		//Click on the add quick event button & add the name
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		driver.findElement(By.id("eventName")).sendKeys(eventTest2);
		
		//Display all the tabs
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
		Assert.assertTrue(driver.findElement(By.id("eventDetail-tab")).isDisplayed(), "test fail");
		driver.findElement (ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS).click();
		Assert.assertTrue(driver.findElement(By.id("eventReminder-tab")).isDisplayed(), "test fail");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS).click();
		Assert.assertTrue(driver.findElement(By.id("eventShare-tab")).isDisplayed(), "test fail");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE).click();
		Assert.assertTrue(driver.findElement(By.id("eventAttender-tab")).isDisplayed(), "test fail");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
		
		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2))).isDisplayed(), "test fail");
		
		// clear data
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2));
		clearData(driver, path);
	}
	
	
	/*
	   	* test ID : 99879
	 	* test name : Add quick event from calendar view by right click
	 	* Step 1 : Open the event creation
	 	* Step 2 : Check the allDay option
	 	* Step 3 : Create the event
	 	* Step 4 : Verify 
	 	* Step 5 : clear the data
	*/	
	public void test3(WebDriver driver, String eventTest3) {
		
		// click on the add quick event button & set the event's title
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_NAMEFIELD).sendKeys(eventTest3);

		
		// check the allDay box
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX).click();

		
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		
		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3))).isDisplayed(), "test fail");
		
		// clear data
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3));
		clearData(driver, path);
	}
	
	/* 	
	 	* test ID : 100001
	 	* test name : Delete event's "all" category
	 	* Step 1 : Open option box
	 	* Step 2 : Select add event
	 	* Step 3 : Try to delete the all category and verify
	 	* Step 4 : Close the alert window
	 	* Step 5 Close the option menu
	*/	
	public void test4(WebDriver driver) {
		
		// click on option button in calendar box
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON).click();
		
		// select add event in the list
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE).click();
		
		// click on delete on the event category "all"
		driver.findElement(By.xpath(ELEMENT_CALENDAR_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT.replace("${calName}", "All"))).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='infoIcon']")).isDisplayed(), "test fail");
		// click on the OK button in the alert window
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT_ALERT).click();

		// click on the close button
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_CLOSEBUTTON).click();
	
	}
	
	/*
	  	* test ID : 99993
	  	* test name : Add event with priority
	  	* Step 1 : open add event form and set the name
	  	* Step 2 : Display the details
	  	* Step 3 : Add a priority, confirm, verify and clear
	*/	
	public void test5(WebDriver driver, String eventTest5) {
		

		int i = 0;
		for(i = 0; i<=2; i++) {
			// open add event form and set the name
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();	
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.id("eventName")).sendKeys(eventTest5);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Display the detail
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			// Add a priority , verify and clear
			Select drpPriority = new Select(driver.findElement(By.name("priority")));
			if (i==0)
			{
				drpPriority.selectByVisibleText("High");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_HIGH).isDisplayed(), "test fail");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_HIGH;
				clearData(driver, path);
			}
			else if (i==1)
			{
				drpPriority.selectByVisibleText("Normal");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL).isDisplayed(), "test fail");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL;
				clearData(driver, path);
			}
			else if (i==2)	
			{
				drpPriority.selectByVisibleText("Low");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW).isDisplayed(), "test fail");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW;
				clearData(driver, path);
			}
			
		
		}
		
	}
	
	/*
	  	* test ID : 99867
	  	* test name : Add new event with duplicated name
	  	* Step 1 : Use a 'for' to create 2 events with the same name
	  	* Step 2 : open add event form and set the name
	  	* Step 3 : Confirm creation
	  	* Step 4 : Verify
	*/	
	public void test6(WebDriver driver, String eventTest6) {
		
		// "for" to create 2 event with a duplicated name
//		int j = 0;
//		for(j = 0; j<=1; j++) {
//			// open add event form and set the name
//			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENTBUTTON).click();
//			driver.findElement(By.id("eventName")).sendKeys(eventTest6);
//			// click on Save button
//			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
//		}
		// Test result
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest6))).isDisplayed(), "test fail");
		clearData(driver, By.xpath("//*[@id='UIWeekViewGrid']//div[1][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		clearData(driver, By.xpath("//*[@id='UIWeekViewGrid']//div[2][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		
	}
	
}
