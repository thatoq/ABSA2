package Page_Objects;

import Utils.ReadPageElementsFile;
import Utils.SeleniumWaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

public class UserPage {
    private WebDriver driver;
    private ReadPageElementsFile propertiesFile = new ReadPageElementsFile();
    private Properties prop = propertiesFile.getElementProperties();
    private SeleniumWaitHelper seleniumWaitHelper;

    By name = By.xpath(prop.getProperty("firstName"));
    By lastName = By.name(prop.getProperty("lastName"));
    By userName = By.name(prop.getProperty("userName"));
    By password = By.xpath(prop.getProperty("password"));
    By companyA = By.xpath(prop.getProperty("companyA"));
    By companyB = By.xpath(prop.getProperty("companyB"));
    By roles = By.xpath(prop.getProperty("role"));
    By admin = By.xpath(prop.getProperty("Admin"));
    By customer = By.xpath(prop.getProperty("customer"));
    By email = By.name(prop.getProperty("email"));
    By phone = By.name(prop.getProperty("cellPhone"));
    By save = By.xpath(prop.getProperty("saveButton"));


    public UserPage(WebDriver driver) throws IOException {
        this.driver = driver;
        seleniumWaitHelper = new SeleniumWaitHelper(this.driver);
    }
    public boolean isInputFirstName(String firstName) {
        try {
            // Verify visibility of these elements from the user page
            WebElement firstNameElement= seleniumWaitHelper.waitForElementVisibility(name);
            firstNameElement.sendKeys(firstName);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isInputLastName(String surname) {
        try {
            // Verify visibility of these elements from the user page
            WebElement lastNameElement= seleniumWaitHelper.waitForElementVisibility(lastName);
            lastNameElement.sendKeys(surname);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isInputUserName(String user) {
        try {
            // Verify visibility of these elements from the user page
            WebElement userNameElement= seleniumWaitHelper.waitForElementVisibility(userName);
            userNameElement.sendKeys(user);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isInputPassword(String userPassword) {
        try {
            // Verify visibility of these elements from the user page
            WebElement passwordElement= seleniumWaitHelper.waitForElementVisibility(password);
            passwordElement.sendKeys(userPassword);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isChooseCompanyA() {
        try {
            // Verify visibility of these elements from the user page
            WebElement companyAElement= seleniumWaitHelper.waitForElementVisibility(companyA);
            companyAElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isChooseCompanyB() {
        try {
            // Verify visibility of these elements from the user page
            WebElement companyBElement= seleniumWaitHelper.waitForElementVisibility(companyB);
            companyBElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isClickRoles() {
        try {
            // Verify visibility of these elements from the user page
            WebElement rolesElement= seleniumWaitHelper.waitForElementVisibility(roles);
            rolesElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isChooseAdmin() {
        try {
            // Verify visibility of these elements from the user page
            WebElement adminElement= seleniumWaitHelper.waitForElementVisibility(admin);
            adminElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isChooseCustomer() {
        try {
            // Verify visibility of these elements from the user page
            WebElement customerElement= seleniumWaitHelper.waitForElementVisibility(customer);
            customerElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isInputEmail(String emailAdd) {
        try {
            // Verify visibility of these elements from the user page
            WebElement emailElement= seleniumWaitHelper.waitForElementVisibility(email);
            emailElement.sendKeys(emailAdd);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isInputPhone(String phoneNumber) {
        try {
            // Verify visibility of these elements from the user page
            WebElement phoneElement= seleniumWaitHelper.waitForElementVisibility(phone);
            phoneElement.sendKeys(phoneNumber);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isClickSave() {
        try {
            // Verify visibility of these elements from the user page
            WebElement saveButtonElement= seleniumWaitHelper.waitForElementVisibility(save);
            saveButtonElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
