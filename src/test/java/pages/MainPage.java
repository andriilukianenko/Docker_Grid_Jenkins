package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    private static final By MY_ACCOUNT_BUTTON = By.xpath("//div[@class='myAccountLinksHeader js-myAccount-toggle']");
    public static final String BASIC_URL = "https://electronics-2005.aimprosoft.com/electronics/en/";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getMyAccountButtonTex() {

        return driver.findElement(MY_ACCOUNT_BUTTON).getText();
    }


}