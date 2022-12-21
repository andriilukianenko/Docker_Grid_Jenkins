package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInForm extends AbstractPage {
    //Log in
    private static final By USER_EMAIL = By.id("j_username");
    private static final By USER_PASS = By.id("j_password");
    private static final By LOG_IN_BUTTON = By.xpath("//form/button[@type='submit']");


    public SignInForm(WebDriver driver) {

        super(driver);
    }

    public void enterUserEmail(String usersEmail) {
        driver.findElement(USER_EMAIL).sendKeys(usersEmail);

    }

    public void enterUserPass(String userPassword) {
        driver.findElement(USER_PASS).sendKeys(userPassword);

    }


    public void clickOnLogInButton() {
        driver.findElement(LOG_IN_BUTTON).click();
    }

}