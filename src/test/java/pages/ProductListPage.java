package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.function.Predicate;


public class ProductListPage extends AbstractPage {

    private static final By SEARCH_FIELD = By.id("js-site-search-input");
    private static final By LIST_OF_PRODUCT_NAMES = By.xpath("//em[@class = 'search-results-highlight']");

    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static By getButtonXpath(String nameButton) {
        return By.xpath("//a[@title='" + nameButton + "']");
    }

    private static By getTitleXpath(String title) {
        return By.xpath("//li[contains(@class, 'active') and text() = '" + title + "']");
    }

    public void clickOnProductHeadersButton(String productName) {
        driver.findElement(getButtonXpath(productName)).click();
    }

    public void enterProductName(String productName) {

        driver.findElement(SEARCH_FIELD).sendKeys(productName + Keys.ENTER);
    }


    public String getProductNameFromSearchList() {
        return driver.findElement(LIST_OF_PRODUCT_NAMES).getText();
    }

    public boolean isProductListContainName(String productName) {
        List<WebElement> webElementList = driver.findElements(LIST_OF_PRODUCT_NAMES);
        return webElementList.stream().anyMatch(webElement -> productName.equals(webElement.getText()));
    }

    public String getProductTextFromTitleOfProductListPage(String title) {
        return driver.findElement(getTitleXpath(title)).getText();
    }


    public void goToProductListPage() {
        driver.get(MainPage.BASIC_URL + "Open-Catalogue/c/1");
    }
}