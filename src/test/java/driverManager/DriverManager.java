package driverManager;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
    private static WebDriver driver;

    @Before
    public static WebDriver getWebDriver() throws Exception {
        if (driver != null) return driver;
        String driverName = ConfigProperties.getProperty("browser");

        switch (driverName) {
            case "chrome" : {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                return new ChromeDriver();
            }
            case "mozilla firefox" : {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default : throw new IllegalArgumentException("Incorrect BrowserName");
        }
    }
    @After
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}