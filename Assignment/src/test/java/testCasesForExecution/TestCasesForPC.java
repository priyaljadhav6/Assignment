package testCasesForExecution;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import browser.DriverClass;
import components.ElementsClass;

public class TestCasesForPC {
	
	WebDriver driver;
	
	//To start the browser and load the AUT before every test
	@BeforeMethod
	public void startTheBrowser() {
		driver = DriverClass.getDriver();
		driver.get("https://www.propertycapsule.com/");
	}
	
	
	//Test Case 1 : Verify the Property Capsule(PC) logo 
	@Test
	public void test01_Verify_Logo() {	
		//To return an appropriate response depending on the visibility of the logo
		ElementsClass objHomePage = new ElementsClass(driver);
		Boolean objVisible = objHomePage.checkForLogo();
		
		//To verify if the logo is visible
		Assert.assertTrue(objVisible);	
	}

	
	//Test Case 2 : Verify that the See for yourself button opens up the Contact Us pop up
	@Test
	public void test02_ContactUs_SeeForYouselfButton() {
		//To scroll to the See for yourself button and click on it
		ElementsClass objHomePage = new ElementsClass(driver);
		objHomePage.returnElementAsked("moveTo_SeeForYourselfOption");
			
		//To verify the title of the Contact Us pop up
		String actualPopupText = objHomePage.getPopUpText();
		Assert.assertEquals(actualPopupText, "Want in? Contact us.");
					
		//To submit the required details in the Contact Us pop up
		Boolean obj_submitContact = objHomePage.submitDetails("Chandler", "Bing", "chandler.bing@xyz.com");
			
		//To verify if the user receives a Thank you message post clicking on Submit in Contact Us pop up
		Assert.assertTrue(obj_submitContact);	
	}

		
	//Test Case 3 : Verify the Map Maker tab
	@Test
	public void test03_Click_On_Map_Maker_Tab() {
		//To get the URL of the page to which user is redirected
		ElementsClass objHomePage = new ElementsClass(driver);
		String actualURL = objHomePage.clickOnMapMaker();
		
		//To verify that the user is redirected to the expected URL
		Assert.assertEquals(actualURL, "https://maps.propertycapsule.com/");
	}

	
	//Test Case 4 : To verify the hyperlink text
	@Test
	public void test04_HyperlinkText(){
		ElementsClass objHomePage = new ElementsClass(driver);
		
		//Scroll till we find the required hyperlink
		objHomePage.returnElementAsked("moveTo_FindOutMoreHyperlink");
		
		//Verify the actual text with the expected hyperlink text
		String actualHyperlinkText = objHomePage.hyperlinkText();
		Assert.assertEquals(actualHyperlinkText, "Find out more");
	}
	
	
	//To close the browser after every test
	@AfterMethod
	public void closeTheBrowser() {
		driver.close();
		driver.quit();
	}
}
