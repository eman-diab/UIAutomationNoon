package login;

import base.BaseTest;
import inputData.ExcelRead;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import java.io.IOException;


public class LoginTest extends BaseTest {

    HomePage homeObject;

    @DataProvider(name="ExcelValidData")
    public Object[][] userRegisterValidData() throws IOException
    {
        String filePath = System.getProperty("user.dir")+"/src/test/java/inputData/UserValidData.xlsx";
        // Get valid data from Excel Reader class
        ExcelRead ER = new ExcelRead();
        return ER.getExcelData(filePath);
    }

    @Test (priority = 4, dataProvider="ExcelValidData")
    public void LoginValidData(String email, String password) throws InterruptedException {

        Thread.sleep(2000);
        homeObject= new HomePage(driver);
        homeObject.clickLoginButton();
        homeObject.fillLoginForm(email, password);
        homeObject.logOut();
    }

    @DataProvider(name="ExcelInvalidData")
    public Object[][] userRegisterInvalidData() throws IOException
    {
        String filePath = System.getProperty("user.dir")+"/src/test/java/inputData/UserInvalidData.xlsx";
        // Get Invalid data from Excel Reader class
        ExcelRead ER = new ExcelRead();
        return ER.getExcelData(filePath);
    }

    @Test (priority = 5 , dataProvider="ExcelInvalidData")
    public void LoginInvalidData(String email, String password) throws InterruptedException {
        Thread.sleep(1000);
        homeObject = new HomePage(driver);
        homeObject.clickLoginButton();
        homeObject.fillLoginForm(email, password);
        Thread.sleep(2000);
        homeObject.closeLoginModal();
    }


}
