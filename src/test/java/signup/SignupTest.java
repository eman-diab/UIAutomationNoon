package signup;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProfilePage;

public class SignupTest extends BaseTest {

   HomePage homeObject = new HomePage(driver);
   ProfilePage profileObject;

    @Test(priority = 1)
    public void SignupValidData() throws InterruptedException {
        homeObject = new HomePage(driver);
        Thread.sleep(1000);
        homeObject.clickLoginButton();
        homeObject.openSignupForm();
        homeObject.fillSignupForm("testoo20@gmail.com", "Aa123456", "Eman", "Diab");
    }

    @Test (priority = 2)
    public void AddAddressNumber() throws InterruptedException {
        Thread.sleep(1000);
        profileObject= homeObject.openProfilePage();
        profileObject.addAddress();
        Assert.assertTrue(profileObject.isSuccessMegPresent());
    }

    @Test (priority = 3)
    public void SignOut() {
        homeObject= profileObject.signOut();
    }

}
