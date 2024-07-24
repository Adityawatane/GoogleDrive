package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{

	@FindBy(xpath="//span[text()='Sign in']")
	private WebElement signintext;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailId;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextbutton;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextbutton1;
	
	public String verifyTitleOfPage() {
		return driver.getTitle();
	}
	
	public String verifySignInText() {
		return signintext.getText();
	}
	
	public String verifygmailLoginURl() throws IOException {
		emailId.sendKeys(ReadData.readPropertyFile("UserName"));
		nextbutton.click();
		password.sendKeys(ReadData.readPropertyFile("Password"));
		nextbutton1.click();
		return driver.getCurrentUrl();
	}
}
