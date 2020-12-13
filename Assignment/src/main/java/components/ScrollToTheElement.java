package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollToTheElement {

	//To scroll till the element is found
		public void moveScrollBar(WebElement element, WebDriver driver) {
			Actions obj = new Actions(driver);
			obj.moveToElement(element);
		}

		
}
