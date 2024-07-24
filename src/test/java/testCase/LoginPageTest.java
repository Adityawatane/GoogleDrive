package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class LoginPageTest extends TestBase

{

	LoginPage login;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException {
		initialization();
		login=new LoginPage();
	}
	
	@Test
	public void verifyTitleOfPageTest() {
		String expTitle="Sign in - Google Accounts";
		String actTitle=login.verifyTitleOfPage();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test
	public void verifySignInTextTest() {
		String expText="Sign in";
		String actText=login.verifySignInText();
		Assert.assertEquals(expText, actText);
	}
	
	@Test
	public void verifygmailLoginURlTest() throws IOException {
		String expURL="https://mail.google.com/mail/u/0/?pli=1#inbox";
		String actURL=login.verifygmailLoginURl();
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
