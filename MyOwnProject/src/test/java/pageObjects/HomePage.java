package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(xpath="//img[@alt='nopCommerce demo store']") 
	WebElement img_logo;
	
	@FindBy(xpath="//a[text()='Register']") 
	WebElement reg_link;
	
	@FindBy(xpath="//a[text()=\"Log in\"]")
	WebElement login_btn;
	
	//Corresponding Action Methods
	
	public boolean test_Logo() {
		try {
		return (img_logo.isDisplayed());
	}
	catch(Exception e) {
		return (false);
	}
	}

	public void Test_reg() {
		reg_link.click();
	}
	
	public void Test_login() {
		login_btn.click();
	}
}
