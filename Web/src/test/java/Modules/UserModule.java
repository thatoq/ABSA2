package Modules;

import ExtentReports.ExtentTestManager;
import Page_Objects.UserPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class UserModule {
    private UserPage userPage;
    public String firstname;
    public UserModule(UserPage userPage) {
        this.userPage = userPage;
    }

    public void validateUserPageFields(String name, String surname, String userName, String password,String email, String phone) {

        boolean isName = userPage.isInputFirstName(name);
        Assert.assertTrue(isName, "Failed to validate that name was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,name+" "+ "name was entered successfully");

        boolean isSurname = userPage.isInputLastName(surname);
        Assert.assertTrue(isSurname, "Failed to validate that surname was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,surname+" "+"last name was entered successfully");

        boolean isUserName = userPage.isInputUserName(userName);
        Assert.assertTrue(isUserName, "Failed to validate that username was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,userName+" "+"username was entered successfully");

        boolean isPassword = userPage.isInputPassword(password);
        Assert.assertTrue(isPassword, "Failed to validate that password was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,"password was entered successfully");

        firstname=name;
        if(firstname=="FName2")
        {
            boolean isCompanyA = userPage.isChooseCompanyA();
            Assert.assertTrue(isCompanyA, "Failed to validate that companyA was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"companyA was clicked successfully");
            boolean isRoles = userPage.isClickRoles();
            Assert.assertTrue(isRoles, "Failed to validate that roles dropdown was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"roles dropdown was clicked successfully");
            boolean isAdmin = userPage.isChooseAdmin();
            Assert.assertTrue(isAdmin, "Failed to validate that admin was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"admin was clicked successfully");

        }
        else
        {
            boolean isCompanyB = userPage.isChooseCompanyB();
            Assert.assertTrue(isCompanyB, "Failed to validate that companyB was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"companyB was clicked successfully");
            boolean isRoles = userPage.isClickRoles();
            Assert.assertTrue(isRoles, "Failed to validate that roles dropdown was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"roles dropdown was clicked successfully");
            boolean isCustomer = userPage.isChooseCustomer();
            Assert.assertTrue(isCustomer, "Failed to validate that customer was clicked successfully.");
            ExtentTestManager.getTest().log(LogStatus.PASS,"customer was selected successfully");

        }
        boolean isEmail = userPage.isInputEmail(email);
        Assert.assertTrue(isEmail, "Failed to validate that email was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,email+" "+"email was entered successfully");

        boolean isPhone = userPage.isInputPhone(phone);
        Assert.assertTrue(isPhone, "Failed to validate that cellphone number was entered successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,phone+" "+"cellphone number was entered successfully");

        boolean isSubmit = userPage.isClickSave();
        Assert.assertTrue(isSubmit, "Failed to validate that save button was clicked successfully.");
        ExtentTestManager.getTest().log(LogStatus.PASS,"save button was clicked successfully");

    }
}
