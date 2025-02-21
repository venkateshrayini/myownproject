package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationSuccessPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void test_login() {
		
		try {
		logger.info("****TC_002_LoginTest Started****");
		HomePage hp= new HomePage(driver);
		hp.Test_login();
		
		LoginPage lp= new LoginPage(driver);
		lp.set_email(rb.getString("email"));
		lp.set_Password(rb.getString("password"));
		lp.submit();
		
		RegistrationSuccessPage rsp= new RegistrationSuccessPage(driver);
		boolean exp_msg = rsp.isMyRegistrationSuccess();
		Assert.assertEquals(exp_msg, true);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("****TC_002_LoginTest Completed");
	}
}
