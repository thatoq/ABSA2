package Modules;

import ExtentReports.ExtentTestManager;
import Page_Objects.HomePage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

import java.io.IOException;

public class HomeModule {
    private HomePage homePage;
    public HomeModule(HomePage homePage) {
        this.homePage = homePage;
    }

    public void validateHomePageFields() {

        boolean isTable = homePage.verifyUserTable();
        Assert.assertTrue(isTable, "Failed to validate that Table was clicked successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,"table was present");
        boolean isHomepage = homePage.isClickAddUser();
        Assert.assertTrue(isHomepage, "Failed to validate that AddUser was clicked successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,"AddUser was clicked successfully");
    }
    public void VerifyUser1(String username) throws IOException {
        // boolean isUser = homePage.User1Displayed();

        Assert.assertEquals(username, homePage.getUser1Tex(),"Failed to validate that users were listed successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,username+" "+"users were listed successfully");
        //screenshotPath= GetScreenshot.capture(driver,"ScreenshotForExtent");



    }
    public void VerifyUser2(String username) throws IOException {

        Assert.assertEquals(username, homePage.getUser2Tex(),"Failed to validate that users were listed successfull.");
        ExtentTestManager.getTest().log(LogStatus.PASS,username+" "+"users were listed successfully");
        //screenshotPath= GetScreenshot.capture(driver,"ScreenshotForExtent");



    }

}
