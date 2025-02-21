package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super (driver);
	}
	
	//WebElements
	@FindBy(id="Email")
	WebElement txt_email;
	
	@FindBy(id="Password")
	WebElement txt_password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement btn_submit;
	
	//Action Methods
	public void set_email(String email) {
		txt_email.sendKeys(email);
	}
	
	public void set_Password(String password) {
		txt_password.sendKeys(password);
	}
	
	public void submit() {
		btn_submit.click();
	}
}
