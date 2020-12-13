package components;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import windows.SwitchWindows;
import windows.WaitForComponents;

public class ElementsClass {

WebDriver driver;
	
    //ElementsClass Constructor
	public ElementsClass(WebDriver driver) {
		this.driver = driver;
	}
	
	//Identified all the required elements
	By logo = By.xpath("//a[@href='https://www.propertycapsule.com']//img[@class='logo']");
	By tab_mapMaker = By.id("market-btn");
	By hyperlink_findOutMore = By.partialLinkText("Find out");
	By contactUs_seeForYourselfOption = By.className("see-for-yourself");
	By titleText = By.className("contact-us-header-title");
	By firstName = By.id("FirstName");
	By lastName = By.id("LastName");
	By workEmail = By.id("Email");
	By submitButton = By.className("mktoButton");
	By thankYouMessage = By.xpath("//span[@style='font-size: 40px;']");
	By PCmapsLogo = By.className("beta");
	
	
	//To check if the logo is displayed
	public boolean checkForLogo() {
		return driver.findElement(logo).isDisplayed();
	}
	
	
	//To get the Find out more hyperlink text
	public String hyperlinkText() {
		return driver.findElement(hyperlink_findOutMore).getText();
	}
	
	
	//To click the Map Maker tab
	public String clickOnMapMaker() {
		driver.findElement(tab_mapMaker).click();
		
		//To switch to the redirected window
		SwitchWindows obj = new SwitchWindows();
		obj.windowsSwitchMethod(driver);
		
		//To wait till the page loads
		WaitForComponents obj1 = new WaitForComponents();
		obj1.waitTillComponentLoads(driver, PCmapsLogo);
		
        //To return the URL of the page on which the user is redirected 
        return driver.getCurrentUrl();    
	}
	
	
	//To click on See for yourself option
		public void ContactUs_SeeByYourselfOption() {
			driver.findElement(contactUs_seeForYourselfOption).click();
	}
	
		
	//To get the text in the Contact Us pop up
	public String getPopUpText() {
		return driver.findElement(titleText).getText();
	}
	
		
	//To set the Firstname
	public void setFirstName(String strFirstName) {
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	
	//To set the Lastname
	public void setLastName(String strLastName) {
		driver.findElement(lastName).sendKeys(strLastName);
	}
	
	
	//To set the Email
	public void setEmail(String strEmail) {
		driver.findElement(workEmail).sendKeys(strEmail);
	}
	
	
	//To click on Submit button
	public void clickSubmit() {
		driver.findElement(submitButton).click();
	}
	
	
	//To scroll to the element and perform the required actions
	public String returnElementAsked(String operation) {
		
		//To create the instances of ElementsClass and ScrollToTheElement classes
		ElementsClass obj = new ElementsClass(driver);
		ScrollToTheElement scrollObj = new ScrollToTheElement();
		
		//To scroll till the element is found
		switch(operation) {
		case "moveTo_FindOutMoreHyperlink": 
		   WebElement FindOutMore = driver.findElement(hyperlink_findOutMore);
		   scrollObj.moveScrollBar(FindOutMore, driver);
		   
		   //To return the hyperlink text
		   return obj.hyperlinkText();
		   
		case "moveTo_SeeForYourselfOption":
			WebElement SeeForYourself =  driver.findElement(contactUs_seeForYourselfOption);
			scrollObj.moveScrollBar(SeeForYourself, driver);
			
			//To call the method that performs click operation on the See for yourself button
			obj.ContactUs_SeeByYourselfOption();
		}
	   return null;
	}
	

	//To submit the details in the Contact Us pop up
	public boolean submitDetails(String strFirstName, String strLastName, String strEmail) {
		
		//To fill the Firstname
		this.setFirstName(strFirstName);
		
		//To fill the Lastname
		this.setLastName(strLastName);
		
		//To fill the Email
		this.setEmail(strEmail);
		
		//To click the submit button
		this.clickSubmit();
		
		//To wait till the Thank you page loads
		WaitForComponents obj = new WaitForComponents();
		obj.waitTillComponentLoads(driver, thankYouMessage);
		
		//To return respective response basis the display of Thank you message
		return driver.findElement(thankYouMessage).isDisplayed();
	}
}
