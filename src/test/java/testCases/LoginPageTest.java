package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;



public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;
	SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority=1)
	public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException, IOException {
//		loginpageObj.enterUserName("demo@techfios.com");
		loginpageObj.enterUserName(DatabasePage.getData("username"));
//		String uName=DatabasePage.getData("username");
//		System.out.println("username: "+ uName);		
		Thread.sleep(2000);
		
		loginpageObj.enterPassword(DatabasePage.getData("password"));
//		String pass=DatabasePage.getData("password");
//		System.out.println("password: "+ pass);
		Thread.sleep(2000);
		loginpageObj.clickSignInButton();
		
		takeScreenshotAtEndOfTest(driver);
	}
	
//
//	@Test(priority=2)
//	public void loginpageTitleTest() throws ClassNotFoundException, SQLException, InterruptedException {
//		loginpageObj.enterUserName(DatabasePage.getData("username"));
//		Thread.sleep(2000);
//		loginpageObj.enterPassword(DatabasePage.getData("password"));
//		Thread.sleep(2000);
//		loginpageObj.clickSignInButton();
//		
//		String expectedTitle="Dashboard- iBilling";
//		String actualTitle=loginpageObj.getPageTitle();
//		Assert.assertEquals(expectedTitle, actualTitle);
//		softAssert.assertEquals(expectedTitle, actualTitle);
//		System.out.println(actualTitle);	
//	}

	
	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}
	
	

}
