package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void verify_account_registration() {
        logger.info("Starting TC_001_AccountRegistrationTest");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");

            hp.clickRegister();
            logger.info("Clicked on Register");

            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

            regpage.setFirstName(randomeString().toUpperCase());
            logger.info("Provided First Name");

            regpage.setLastName(randomeString().toUpperCase());
            logger.info("Provided Last Name");

            regpage.setEmail(randomeString() + "@gmail.com");
            logger.info("Provided Email");

            regpage.setTelephone(randomeNumber());
            logger.info("Provided Telephone");

            regpage.setPassword("test@123");
            logger.info("Provided Password");

            regpage.setConfirmPassword("test@123");
            logger.info("Provided Confirmed Password");

            regpage.setPrivacyPolicy();
            logger.info("Set Privacy Policy");

            regpage.clickContinue();
            logger.info("Clicked on Continue");

            Thread.sleep(2000);

            // Add assertion to check confirmation message
          /*  String confmsg = regpage.getConfirmationMsg();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!");
            logger.info("Account registration successful"); */

        } catch (Exception e) {
            logger.error("Test failed due to exception: " + e.getMessage());
            Assert.fail();
        }

        logger.info("Finished TC_001_AccountRegistrationTest");
    }
}
