package windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForComponents {
	
	WebDriver driver;
	
	public void waitTillComponentLoads(WebDriver driver, By element) {
	
	    //To wait till the element is located
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
