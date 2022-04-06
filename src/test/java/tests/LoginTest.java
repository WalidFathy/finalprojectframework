package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.testng.listener.*;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.Screenshots;

@Listeners({ExtentITestListenerClassAdapter.class})
public class LoginTest extends LoginPage{
	HomePage homePage = new HomePage();
	MyAccountPage myAccountPage = new MyAccountPage();
	Screenshots screenshots = new Screenshots();
	//=======================================================
	@Test
	public void login()
	{
		try {
			homePage.openAutomationPractice();
			homePage.clickSignIn();
			typeEmail("walidadly21@gmail.com");
			typePassword("walid12345.");
			clickSubmit();
			myAccountPage.assertMyAccountTitle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tackeScreenShot()
	{ 
		screenshots.captureScreenShot("testScreenshot");
	}
}
