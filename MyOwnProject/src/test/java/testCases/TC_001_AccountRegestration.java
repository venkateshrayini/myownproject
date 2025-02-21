package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegestration extends BaseClass{

	@Test(groups= {"Regression","Master"})
	public void test_Account_Registration() {
		
		
		logger.info("*** TC_001_AccountRegestration Started ***");
		
	try {
		
		HomePage hp= new HomePage(driver);
		//hp.test_Logo();
		hp.Test_reg();
		
		AccountRegistrationPage reg = new AccountRegistrationPage(driver);
		reg.test_Radio();
		reg.test_FirstName("abuedee");
		reg.test_LastName("hgydue");
		reg.test_Email("abc123464@gmail.com");
		reg.test_passWord("abcssfho1234@123");
		reg.test_ConformPassword("abcssfho1234@123");
		reg.test_Register();
		String confmsg = reg.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your registration completed");
		
		}
	
	catch(Exception e) {
			logger.error("test failed");
			Assert.fail();
		}
	logger.info("*** TC_001_AccountRegestration Completed ***");
	}
		
	}
	

