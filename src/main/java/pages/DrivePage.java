package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.TestBase;

public class DrivePage extends TestBase

{

	@FindBy(xpath="//input[@class='gb_je a-WErN3d-CQWwNe']")
	private WebElement serchbox;
	@FindBy(xpath="//div[@class='ZHllM']")
	private WebElement fileupload;
	
	
	public boolean verifyserchbox() {
		return serchbox.isDisplayed();
	}
	
	public Boolean verifyFileUpload() {
		fileupload.sendKeys("D:/npkey.txt");
		return true;
	}
}
