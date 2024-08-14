package TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import TestBase.Base;
import Utils.Utility;

public class VerifyHomePage extends Base{
	LoginPage loginPage;
	String testID;
	
	@BeforeMethod
	public void setup(){
		launchBrowser("chrome");
		loginPage = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void verifyValidInputs() throws IOException {
		testID="T001";
		loginPage.sendUserName("test");	
		loginPage.sendPassword("test");	
		loginPage.clickOnLoginBtn();		
		
		String expected = "On this page you can visualize or edit you user information.";
		Assert.assertEquals(loginPage.getTitle(),expected);		
	}	

	@Test(priority = 2)
	public void invalidUserName(){
		testID="T0002";
		loginPage.sendUserName("test01");
		loginPage.sendPassword("test");		
		loginPage.clickOnLoginBtn();
		String expected = "On this page you can visualize or edit you user information.";
		Assert.assertNotEquals(loginPage.getInvalidTitle(),expected);
	}	
	
	@Test(priority = 3)
	public void invalidPassword(){	
		testID="T003";
		loginPage.sendUserName("test01");
		loginPage.sendPassword("test");
		loginPage.clickOnLoginBtn(); 

		String expected = "On this page you can visualize or edit you user information.";
		Assert.assertNotEquals(loginPage.getInvalidTitle(),expected);
	}
	

	@AfterMethod
	public void captureScreenshotinFailure(ITestResult result1) throws IOException {
		if(ITestResult.FAILURE== result1.getStatus()) {
			Utility.captureScreenshot(driver, testID);
		}
    }	

	@AfterClass
	public void closeBrowser() {
		driver.close();
		loginPage = null;
		driver=null;
	}

	@AfterTest
	public void garbageCollector() {

		System.gc();
	}


}
