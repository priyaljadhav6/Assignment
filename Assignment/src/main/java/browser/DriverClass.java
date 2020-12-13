package browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverClass {

	public static WebDriver getDriver() {
	WebDriver driver;
	
	//To set the driver properties and return the instance of the driver class
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdriver.chrome.driver_87\\chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    
	return driver;
}
}