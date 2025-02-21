package testCases;

//import org.slf4j.helpers.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationSuccessPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email, String password, String expValue) {
		
		logger.info("****TC_002_LoginTest Started****");
		try {
		HomePage hp= new HomePage(driver);
		hp.Test_login();
		
		LoginPage lp= new LoginPage(driver);
		lp.set_email(email);
		lp.set_Password(password);
		lp.submit();
		
		RegistrationSuccessPage regSuc= new RegistrationSuccessPage(driver);
		boolean value = regSuc.isMyRegistrationSuccess();
		
		if(expValue.equals("valid")) {
			if(value==true) {
				regSuc.clkLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.fail();
			}
		}
		
		if(expValue.equals("invalid")) {
			if(value==true) {
				regSuc.clkLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Finished TC_003_LoginDDT****");
		
	}
}
