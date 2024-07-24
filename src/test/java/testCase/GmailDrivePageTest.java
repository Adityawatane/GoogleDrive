package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.GmailDrivePage;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class GmailDrivePageTest extends TestBase
{

	LoginPage login;
	GmailDrivePage gamildrive;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		gamildrive=new GmailDrivePage();
		login.verifygmailLoginURl();
	}
	@Test
	public void verifyURLofgoogledriveTest() {
		String expURL="https://drive.google.com/drive/home";
		String actURL=gamildrive.toString();
		Assert.assertEquals(expURL, actURL);
	}
	
	@AfterMethod()
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus()) {
			CaptureScreenshot.screenshot(it.getName());
		}
		driver.close();
	}
}
