package Test;

import BaseTest.WebBaseTest;
import Modules.HomeModule;
import Modules.UserModule;
import Page_Objects.HomePage;
import Page_Objects.UserPage;
import Utils.DataProviderObject;
import Utils.DriverFactory;
import Utils.Global_Variables;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class WebTests extends WebBaseTest {
    WebDriver driver;

    @Test(dataProvider = "Data", dataProviderClass = DataProviderObject.class)
    public void User1 (String browser,String name, String surname, String userName, String password,String email, String phone) throws Exception {
        driver = DriverFactory.getInstance().getBrowserInstance(browser);
        driver.get(Global_Variables.URL);

        HomeModule homeModule = new HomeModule(new HomePage(driver));
        homeModule.validateHomePageFields();

        UserModule userModule=new UserModule(new UserPage(driver));
        userModule.validateUserPageFields(name,surname,userName,password,email,phone);
        homeModule.VerifyUser1(userName);
        //ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");

    }
    @Test(dataProvider = "Data2", dataProviderClass = DataProviderObject.class)
    public void User2 (String browser,String name, String surname, String userName, String password,String email, String phone) throws Exception {
        WebDriver driver = DriverFactory.getInstance().getBrowserInstance(browser);
        driver.get(Global_Variables.URL);

        HomeModule homeModule = new HomeModule(new HomePage(driver));
        homeModule.validateHomePageFields();

        UserModule userModule=new UserModule(new UserPage(driver));
        userModule.validateUserPageFields(name,surname,userName,password,email,phone);
        homeModule.VerifyUser2(userName);
        //ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");
    }
}
