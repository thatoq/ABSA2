package BaseTest;

import ExtentReports.ExtentManager;
import ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class APIBaseTest {
    @BeforeSuite
    public void setup()
    {
        RestAssured.baseURI="https://dog.ceo/api";

    }
    @BeforeMethod
    public  void beforeMethod(Method method)
    {
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().log(LogStatus.INFO,"Base URI",RestAssured.baseURI);
    }
    @AfterMethod
    public void afterMethod(ITestResult result)
    {
        if (result.getStatus()==ITestResult.FAILURE){
            ExtentTestManager.getTest().log(LogStatus.FAIL,result.getThrowable());
        }else if (result.getStatus()==ITestResult.SKIP){
            ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Skipped"+result.getThrowable());
        }else {
            ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");
        }
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        ExtentManager.getReporter().flush();
    }
}
