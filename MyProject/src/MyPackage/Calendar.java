package MyPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar {
	public static void main(String[] args) {
		
		
	}
	
	public static void open(WebDriver driver) {
		//Click on the calendar button
		driver.findElement(By.xpath("//*[@data-original-title='Calendar']")).click();
	}
	
	
	public static void test1(WebDriver driver, String eventTest) {
		//Click on the add quick event button
		driver.findElement(By.id("UIActionBarQuickAddEvent")).click();
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div[8]/div[2]/div[3]/div[2]/div/div[2]/button[1]")).click();
	}
	
	
	public static void test2(WebDriver driver, String eventTest2) {
		
		driver.findElement(By.id("UIActionBarQuickAddEvent")).click();
		WebElement eventTitle =driver.findElement(By.id("eventName"));
		eventTitle.sendKeys(eventTest2);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='UIQuickAddEventPopupWindow']//*[text()='More Details']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-toggle='tab' and text()='Reminders']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-toggle='tab' and text()='Participants']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@data-toggle='tab' and text()='Schedule']")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/span/div/div[2]/div/div/form/div[4]/button[1]")).click();
	
	
	}
}
