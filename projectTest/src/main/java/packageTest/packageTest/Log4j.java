package packageTest;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4j {

	private static WebDriver driver;

	private static Logger Log = Logger.getLogger(Log4j.class.getName());

	public static void main(String[] args) {


	}
	public void configLogger()
    {
        URL u = getClass().getClassLoader().getResource("/projectTest/log4j.xml");
        DOMConfigurator.configure(u);
    }

}
