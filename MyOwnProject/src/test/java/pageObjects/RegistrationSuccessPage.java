package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccessPage extends BasePage{

	public RegistrationSuccessPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[text()='Your registration completed']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement btnLogout;
	
	public boolean isMyRegistrationSuccess() {
		try {
			return (msgHeading.isDisplayed());
		}catch(Exception e) {
			return (false);
		}
	}
	
	public void clkLogout() {
		btnLogout.click();
	}
}
