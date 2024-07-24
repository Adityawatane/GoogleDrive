package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.DrivePage;
import pages.GmailDrivePage;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class DrivePageTest extends TestBase

{

	LoginPage login;
	GmailDrivePage gamildrive;
	DrivePage driver2;
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		gamildrive=new GmailDrivePage();
		driver2=new DrivePage();
		login.verifygmailLoginURl();
		gamildrive.verifyURLofgoogledrive();
	}
	
	@Test
	public void verifyserchboxText() {
		boolean result=driver2.verifyserchbox();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyFileUpload() {
		boolean result=driver2.verifyFileUpload();
		Assert.assertTrue(result);
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
