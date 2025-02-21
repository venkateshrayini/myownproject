package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	//WebElements
	
	@FindBy(id="gender-male") 
	WebElement radio_btn;
	
	@FindBy(id="FirstName")
	WebElement fname;
	
	@FindBy(id="LastName")
	WebElement lname;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement psswrd;
	
	@FindBy(id="ConfirmPassword")
	WebElement confrmPassword;
	
	@FindBy(name="register-button")
	WebElement reg_btn;
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement conformationText;
	
	
	//Corresponding action methods
	
	public void test_Radio() {
		radio_btn.click();
	}
	
	public void test_FirstName(String name) {
		fname.sendKeys(name);
	}
	
	public void test_LastName(String lstname) {
		lname.sendKeys(lstname);
	}
	
	public void test_Email(String mail) {
		email.sendKeys(mail);
	}
	
	public void test_passWord(String password) {
		psswrd.sendKeys(password);
	}
	
	public void test_ConformPassword(String conformPassword) {
		confrmPassword.sendKeys(conformPassword);
	}
	
	public void test_Register() {
		reg_btn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (conformationText.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}


















