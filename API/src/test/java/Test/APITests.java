package Test;

import BaseTest.APIBaseTest;
import ExtentReports.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests extends APIBaseTest {
    int statuscode;
    String responseBody;
    String request;
    String path;

    @Test(priority = 1)
    public void GetAllDogs()
    {
       // ExtentTestManager.getTest().log(LogStatus.INFO,RestAssured.baseURI);
        RequestSpecification httpRequest= RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        path="/breeds/list/all";
        Response response=httpRequest.request(Method.GET,path);
        statuscode=response.getStatusCode();
        responseBody=response.getBody().asString();
        Assert.assertEquals(statuscode,200);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Path",path);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Response Body",responseBody.toString());
    }
    @Test(priority = 2)
    public void VerifyRetriever()
    {
        RequestSpecification httpRequest= RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        path="/breeds/list/all";
        Response response=httpRequest.request(Method.GET,path);
        responseBody=response.getBody().asString();
        Assert.assertEquals(responseBody.contains("retriever"),true);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Path",path);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Retriever is within the list");
    }
    @Test(priority = 3)
    public void GetRetrieverSub_breeds()
    {
        RequestSpecification httpRequest=RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        path="/breed/retriever/list";
        Response response=httpRequest.request(Method.GET,path);
        statuscode=response.getStatusCode();
        Assert.assertEquals(statuscode,200);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Path",path);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Response Body",response.body().print());

    }
    @Test(priority = 4)
    public void GetGoldenRandomImage()
    {
        RequestSpecification httpRequest=RestAssured.given();
        httpRequest.header("Content-Type","application/json");
        path="/breed/retriever/golden/images/random";
        Response response=httpRequest.request(Method.GET,path);
        statuscode=response.getStatusCode();
        Assert.assertEquals(statuscode,200);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Path",path);
        ExtentTestManager.getTest().log(LogStatus.INFO,"Response Body",response.body().print());

    }
}
