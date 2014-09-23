package packageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.Open;
import com.thoughtworks.selenium.webdriven.commands.WaitForCondition;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
/**
 * Unit test for simple App.
 */
@Test
public class TheTest 
    extends calendar_common
{
	public TheTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public TheTest() {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	static Logger log = Logger.getLogger(
            Log4j.class.getName());

	static WebDriver driver;
	String baseUrl = "http://localhost:8080/portal/intranet";
	String username = "root";
	String password = "gtn";
	LogPlf theLog;
	calendar_common calComm;
	
	
	@BeforeTest
	public void before(){
		theLog = new LogPlf();
		driver = new FirefoxDriver();
		log.info("New driver created !");
		theLog.main(driver, baseUrl, username, password);
		log.info("Logged on PLF !");
		calComm = new calendar_common(driver);
		calComm.open();
		log.info("Calendar open !");
	}

	@AfterTest
	public void after(){
		driver.quit();
		log.info("Calendar closed !");
		 
	}

	@Test (priority = 0)
	/*  
	 @Author CMugnier
	 @Param eventTest	
	 * test ID : 99886
	 * test name : Add quick event from calendar view by right click
	 * Step 1 : Show quick add event form
	 * Step 2: Add quick event
	 */	
	public void Add_quick_event_from_calendar_view_by_right_click() {
		log.info("Test 1 started !");
		String eventTest= "event test";
		/*Step 1 : Click on the add quick event button*/
		//Open the event creation form by right click
		calComm.addEventByRightClick(eventTest);
		log.info("Open quick event form by right click !");

		/* Step 2: Add quick event */
		//Click on the save button
		driver.findElement(calComm.ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		log.info("Event created !");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// verify the test
		Assert.assertTrue(driver.findElement(By.xpath(calComm.ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest))).isDisplayed(), "test fail");
		
		// clear data
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		By path = By.xpath(calComm.ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest));
		calComm.clearData(path);
		log.info("Data cleaned !");
		
		log.info("Test 1 passed !");
	}

	@Test (priority = 10)
	/*
	 * @author : CMugnier
	 * @param : eventTest2
	 * test ID : 99868
	 * test name : Add new event with special characters
	 * Step 1: Show detail add event form
	 * Step 2: Add event with special characters 
	 */	
	public void Add_new_event_with_special_characters() {
		log.info("Test 2 started !");
		String eventTest2 = "event <test2>";

		/* Step 2: Add event with special characters */
		//Click on the add quick event button & add the name
		addEvent(eventTest2);
		log.info("Open new event form !");
		/* Step 1 : Show detail add event form */
		//Display all the tabs
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
		log.info("Open more details form !");
		Assert.assertTrue(driver.findElement(By.id("eventDetail-tab")).isDisplayed(), "test fail");
		log.info("Check !");
		driver.findElement (ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_REMINDERS).click();
		log.info("open reminders tabs !");
		Assert.assertTrue(driver.findElement(By.id("eventReminder-tab")).isDisplayed(), "test fail");
		log.info("Check !");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_PARTICIPANTS).click();
		log.info("open participants tabs !");
		Assert.assertTrue(driver.findElement(By.id("eventShare-tab")).isDisplayed(), "test fail");
		log.info("Check !");
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SCHEDULE).click();
		log.info("open schedule tabs !");
		Assert.assertTrue(driver.findElement(By.id("eventAttender-tab")).isDisplayed(), "test fail");
		log.info("Check !");

		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
		log.info("Event created !");

		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2))).isDisplayed(), "test fail");
		log.info("Check !");
		// clear data
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest2));
		clearData(path);
		log.info("Data cleared !");
		
		log.info("Test 2 passed !");
	}

	@Test (priority = 20)
	/*
	 * @author : CMugnier
	 * @param : eventTest3
	 * test ID : 99879
	 * test name : Add all day event
	 * Step 1:Show add new event form
	 * Step 2: Complete adding new event
	 */	
	public void Add_all_day_event() {
		
		log.info("Test 3 started !");
		String eventTest3 = "event test3";
		/* Step 1:Show add new event form */
		// click on the add quick event button & set the event's title
		addEvent(eventTest3);
		log.info("Open new event form !");

		// check the allDay box
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_ALLDAYCHECKBOX).click();
		log.info("Check all day option !");
		/* Step 2: Complete adding new event */
		// click on Save button
		driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
		log.info("Event created !");
		// verify
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3))).isDisplayed(), "test fail");
		log.info("Check !");
		// clear data
		By path = By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_ALLDAY.replace("${name}", eventTest3));
		clearData(path);
		log.info("Data cleared !"); 
		log.info("Test 3 passed !");
	}

	@Test (priority = 30)
	/* 	
	 * @author : CMugnier
	 * test ID : 100001
	 * test name : Delete event's "all" category
	 * Step 1: Perform to Delete "all"  category
	 */	
	public void Delete_event_all_category() {

		log.info("Test 4 started !");
		/* Step 1: Perform to Delete "all"  category */
		// click on option button in calendar box
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON).click();
		log.info("Option box opened !");
		// select add event in the list
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE).click();
		log.info("add event category form opened !");
		// click on delete on the event category "all"
		driver.findElement(By.xpath(ELEMENT_CALENDAR_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT.replace("${calName}", "All"))).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='infoIcon']")).isDisplayed(), "test fail");
		log.info("Delete all category check !");
		// click on the OK button in the alert window
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_DELETEEVENT_ALERT).click();
		log.info("alert window closed !");
		// click on the close button
		driver.findElement(ELEMENT_HOMEPAGE_CALENDARSBOX_OPTIONSBUTTON_ADDEVENTCATEGORIE_CLOSEBUTTON).click();
		
		log.info("Test 4 passed !");
	}

	@Test (priority = 40)
	/*
	 * @author : CMugnier
	 * @param : eventTest5
	 * test ID : 99993
	 * test name : Add event with priority
	 * Step 1: Show add new event form
	 * Step 2: Complete adding new event
	 */	
	public void Add_event_with_priority() {

		log.info("Test 5 started !");
		String eventTest5 = "event test5";
		int i = 0;
		for(i = 0; i<=2; i++) {
			/*  Step 1: Show add new event form */
			// open add event form and set the name
			addEvent(eventTest5);
			log.info("add event form opened !");
			//Display the detail
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS).click();
			log.info("more details tabs displayed !");
			/* Step 2: Complete adding new event */
			// Add a priority , verify and clear
			Select drpPriority = new Select(driver.findElement(By.name("priority")));
			if (i==0)
			{
				drpPriority.selectByVisibleText("High");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				log.info("High priority event created !");
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_HIGH).isDisplayed(), "test fail");
				log.info("Check !");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_HIGH;
				clearData(path);
				log.info("Data cleared !");
			}

			else if (i==1)
			{
				drpPriority.selectByVisibleText("Normal");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				log.info("Normal priority event created !");
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL).isDisplayed(), "test fail");
				log.info("Check !");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_NORMAL;
				clearData(path);
				log.info("Data cleared !");
			}

			else if (i==2)	
			{
				drpPriority.selectByVisibleText("Low");
				// click on Save button
				driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_MOREDETAILS_SAVEBUTTON).click();
				log.info("Low priority event created !");
				Assert.assertTrue(driver.findElement(ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW).isDisplayed(), "test fail");
				log.info("Check !");
				// clear
				By path = ELEMENT_CALENDAR_EVENTDISPLAY_PRIORITY_LOW;
				clearData(path);
				log.info("Data cleared !");
			}


		}
		log.info("Test 5 passed !");
	}

	@Test (priority = 50)
	/*
	 * @author : CMugnier
	 * @param : eventTest6
	 * test ID : 99867
	 * test name : Add new event with duplicated name
	 * Step 1: Show detail add event form
	 * Step 2 : Add event with duplicated name
	 */	
	public void Add_new_event_with_duplicated_name() {

		log.info("Test 6 started !");
		String eventTest6 = "duplicated name";
		// "for" to create 2 event with a duplicated name
		int j = 0;
		for(j = 0; j<=1; j++) {
			/* Step 1: Show detail add event form */
			/* Step 2 : Add event with duplicated name */
			// open add event form and set the name
			addEvent(eventTest6);
			log.info("Add event form opened !");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
			// click on Save button
			driver.findElement(ELEMENT_CALENDAR_QUICKADDEVENT_SAVEBUTTON).click();
			log.info("event created !");
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		// Test result
		Assert.assertTrue(driver.findElement(By.xpath(ELEMENT_CALENDAR_EVENTDISPLAY_NORMALEVENT.replace("${name}", eventTest6))).isDisplayed(), "test fail");
		log.info("Check !");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		// clear data
		clearData(By.xpath("//*[@id='UIWeekViewGrid']//div[1][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		clearData(By.xpath("//*[@id='UIWeekViewGrid']//div[2][@class='eventContainerBorder weekViewEventBoxes asparagus shortTitle']//div[contains(text(),'duplicated name')]"));
		log.info("Data cleared !");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
		log.info("Test 6 passed !");
	}
}
