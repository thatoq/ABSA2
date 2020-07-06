package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private DriverFactory() { }

    private static DriverFactory instance = new DriverFactory();
    private static String driverPath = System.getProperty("user.dir") + "/src/test/java/webdrivers";

    public static DriverFactory getInstance() {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
    void setupMacChromeInstance() {
        String chromeDriverPath = driverPath + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        setDriver(new ChromeDriver(options));
    }

    void setupChromeInstance() {
        String chromeDriverPath = driverPath + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        setDriver(new ChromeDriver(options));
    }

    void setupFirefoxInstance() {

        String fireFoxDriverPath = driverPath + "/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);

        setDriver(new FirefoxDriver());
    }

    // This method accepts a string as parameter and instantiates a browser based on the string passed which represents browser name
    public WebDriver getBrowserInstance(String browser) throws Exception {
        switch(browser) {
            case "macchrome":
                setupMacChromeInstance();
                break;
            case "chrome":
                setupChromeInstance();
                break;
            case "firefox":
                setupFirefoxInstance();
                break;
            default:
                throw new Exception("Unable to find specified browser: " + browser);
        }

        return getDriver();
    }

    public void quitDriver() {
        getDriver().quit();
    }
}
