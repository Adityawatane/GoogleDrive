package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class GmailDrivePage extends TestBase

{

	@FindBy(xpath="//a[@aria-label='Google apps']")
	private WebElement googleapp;
	
	@FindBy(xpath="//span[@style='background-position: 0 -58px;']")
	private WebElement drive;
	
	
	public String verifyURLofgoogledrive() {
		
		googleapp.click();
		drive.click();
		return driver.getCurrentUrl();
	}
	
	
}
