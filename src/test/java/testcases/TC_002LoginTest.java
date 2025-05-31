package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;


public class TC_002LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Regression"}) //Step8 groups added
	public void test_Login() throws InterruptedException
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
						
			hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			lp.setEmail("email"); // valid email, get it from properties file
			
			lp.setPassword("password"); // valid password, get it from properties file
			
			lp.clickLogin();
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
	}

