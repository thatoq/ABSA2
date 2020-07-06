package Page_Objects;

import Utils.ReadPageElementsFile;
import Utils.SeleniumWaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.Properties;

public class HomePage {
    private WebDriver driver;
    private ReadPageElementsFile propertiesFile = new ReadPageElementsFile();
    private Properties prop = propertiesFile.getElementProperties();
    private SeleniumWaitHelper seleniumWaitHelper;

    By table=By.xpath(prop.getProperty("UserTable"));
    By addUser = By.xpath(prop.getProperty("addUser"));
    By User1 = By.xpath(prop.getProperty("firstUsername"));
    By User2 = By.xpath(prop.getProperty("secondUsername"));
    String username1;
    String username2;


    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
        seleniumWaitHelper = new SeleniumWaitHelper(this.driver);
    }

    public boolean verifyUserTable() {
        try {
            // Verify visibility of these elements from the home page
            WebElement tableElement=  seleniumWaitHelper.waitForElementVisibility(table);
            tableElement.isDisplayed();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean isClickAddUser() {
        try {
            // Verify visibility of these elements from the home page
            WebElement addUserElement=  seleniumWaitHelper.waitForElementVisibility(addUser);
            addUserElement.click();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public String getUser1Tex() {
        try {
            // Verify visibility of these elements from the home page
            WebElement User1Element=  seleniumWaitHelper.waitForElementVisibility(User1);

            return User1Element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public String getUser2Tex() {
        try {
            // Verify visibility of these elements from the home page
            WebElement User2Element=  seleniumWaitHelper.waitForElementVisibility(User2);

            return User2Element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
