package windows;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;


public class SwitchWindows {
	
	public void windowsSwitchMethod(WebDriver driver) {
	 //To get handles of the windows
    String mainWindowHandle = driver.getWindowHandle();
    Set<String> allWindowHandles = driver.getWindowHandles();
    Iterator<String> iterator = allWindowHandles.iterator();

    //To check if child window has other child windows and switch to the child window
    while (iterator.hasNext()) {
        String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
            driver.switchTo().window(ChildWindow);
            
}
}
}
}