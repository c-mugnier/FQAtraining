package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Calendar extends calendar_common {
	
	
	public Calendar(WebDriver driver) {
		this.driver=driver;
	}
	

	/* 
	 	* test ID : 99886
		* test name : Add quick event from calendar view by right click
		* Step 1 : Show quick add event form
		* Step 2: Add quick event
	*/	
	public void test1(String eventTest) {
		
		/*Step 1 : Click on the add quick event button*/
		//Open the event creation form by right click
		addEventByRightClick(eventTest);
		

		/* Step 2: Add quick event */
		//Click on the save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// verify the test
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest))).isDisplayed(), "test fail");
		
		// clear data
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest));
		clearData(path);
	}
	
	/*
	   	* test ID : 99868
	 	* test name : Add new event with special characters
	 	* Step 1: Show detail add event form
	 	* Step 2: Add event with special characters 
	*/	
	public void test2(String eventTest2) {
		
		
		/* Step 2: Add event with special characters */
		//Click on the add quick event button & add the name
		addEvent(eventTest2);
		
		/* Step 1 : Show detail add event form */
		//Display all the tabs
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
		Assert.assertTrue(driver.findElement(By.id("eventDetail-tab")).isDisplayed(), "test fail");
		driver.findElement (ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS).click();
		Assert.assertTrue(driver.findElement(By.id("eventReminder-tab")).isDisplayed(), "test fail");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS).click();
		Assert.assertTrue(driver.findElement(By.id("eventShare-tab")).isDisplayed(), "test fail");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE).click();
		Assert.assertTrue(driver.findElement(By.id("eventAttender-tab")).isDisplayed(), "test fail");
		
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
		
		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2))).isDisplayed(), "test fail");
		
		// clear data
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2));
		clearData(path);
	}
	
	
	/*
	   	* test ID : 99879
	 	* test name : Add all day event
	 	* Step 1:Show add new event form
	 	* Step 2: Complete adding new event
	*/	
	public void test3(String eventTest3) {
		
		/* Step 1:Show add new event form */
		// click on the add quick event button & set the event's title
		addEvent(eventTest3);

		
		// check the allDay box
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX).click();

		/* Step 2: Complete adding new event */
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		
		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3))).isDisplayed(), "test fail");
		
		// clear data
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3));
		clearData(path);
	}
	
	/* 	
	 	* test ID : 100001
	 	* test name : Delete event's "all" category
	 	* Step 1: Perform to Delete "all"  category
	*/	
	public void test4() {
		
		/* Step 1: Perform to Delete "all"  category */
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
	  	* Step 1: Show add new event form
	  	* Step 2: Complete adding new event
	*/	
	public void test5(String eventTest5) {
		

		int i = 0;
		for(i = 0; i<=2; i++) {
			/*  Step 1: Show add new event form */
			// open add event form and set the name
			addEvent(eventTest5);
			
			//Display the detail
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
			/* Step 2: Complete adding new event */
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
				clearData(path);
			}
		
			else if (i==1)
			{
				drpPriority.selectByVisibleText("Normal");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL).isDisplayed(), "test fail");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL;
				clearData(path);
			}
		
			else if (i==2)	
			{
				drpPriority.selectByVisibleText("Low");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW).isDisplayed(), "test fail");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW;
				clearData(path);
			}
			
		
		}
		
	}
	
	/*
	  	* test ID : 99867
	  	* test name : Add new event with duplicated name
	  	* Step 1: Show detail add event form
	  	* Step 2 : Add event with duplicated name
	*/	
	public void test6(String eventTest6) {
		
		// "for" to create 2 event with a duplicated name
		int j = 0;
		for(j = 0; j<=1; j++) {
			/* Step 1: Show detail add event form */
			/* Step 2 : Add event with duplicated name */
			// open add event form and set the name
			addEvent(eventTest6);
			
			// click on Save button
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		}
		
		// Test result
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest6))).isDisplayed(), "test fail");
		
		// clear data
		clearData(By.xpath("//*[@id='UIWeekViewGrid']//div[1][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		clearData(By.xpath("//*[@id='UIWeekViewGrid']//div[2][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		
	}
	
}
