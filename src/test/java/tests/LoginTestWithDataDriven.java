package tests;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.Paths;
import utilities.Screenshots;
import utilities.readers.ExcelReader;

@Listeners({ExtentITestListenerClassAdapter.class})
public class LoginTestWithDataDriven extends LoginPage{
	HomePage homePage = new HomePage();
	MyAccountPage myAccountPage = new MyAccountPage();
	ExcelReader excelReader = new ExcelReader();
	Screenshots screenshots = new Screenshots();
	//=======================================================
	@BeforeClass()
	public void loadLoginData()
	{
		String filePath = Paths.DATA;
		try {
			excelReader.setPath(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void login()
	{
		try {
			homePage.openAutomationPractice();
			homePage.clickSignIn();
			typeEmail(excelReader.read(1, 0));
			typePassword(excelReader.read(1, 1));
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
