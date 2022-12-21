package definitions;

import driverManager.DriverManager;
import pages.MainPage;
import pages.ProductListPage;
import pages.SignInForm;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class StepDefinitions {
    private ProductListPage productListPage;
    private SignInForm signInForm;
    private MainPage mainPage;
    private WebDriver driver;

    @Before
    public void initPage() throws Exception {

        driver = DriverManager.getWebDriver();
        productListPage = new ProductListPage(driver);
        signInForm = new SignInForm(driver);
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("Product list page is opened")
    public void openProductListPage() {
        productListPage.goToProductListPage();
    }

    @When("^Customer searches for (.*)$")
    public void customerEntersAProductNameIntoTheInputFieldEndPressEnter(String searchTerm) {
        productListPage.enterProductName(searchTerm);
    }

    @Then("^Verify that Product with name (.*) is appeared in the product list on the site page$")
    public void theEnteredProductAppearsInTheProductListOnTheSitePage(String searchTerm) {
        Assert.assertTrue(productListPage.isProductListContainName(searchTerm));
    }

    @When("^the user clicks on ([^\"]*)$")
    public void theUserClicksOnFilmCameras(String category) {
        productListPage.clickOnProductHeadersButton(category);

    }

    @Then("^Verify that the ([^\"]*) is displayed$")
    public void thePageDisplaysTitle(String expectedTitle) {
        Assert.assertEquals(productListPage.getProductTextFromTitleOfProductListPage("Webcams"), expectedTitle);

    }



    @Given("Open Sign In page")
    public void signInFormIsOpened() {
        driver.get(MainPage.BASIC_URL + "login");
    }


    @When("Users enters the information in Email and Password fields")
    public void usersEntersTheInformationAsFollows(List<Map<String, String>> dataTable) {
        for (Map<String, String> form : dataTable) {
            String email = form.get("Email");
            signInForm.enterUserEmail(email);
            String pass = form.get("Pass");
            signInForm.enterUserPass(pass);
        }
    }

    @And("Click on the LogIn button")
    public void clickOnTheLogInButton() {
        signInForm.clickOnLogInButton();
    }

    @Then("Verify that My Account button is displayed on the Main page")
    public void welcomeMassageIsDisplayInTheHOMEPage() {
        Assert.assertEquals(mainPage.getMyAccountButtonTex(), "MY ACCOUNT", "Main Page doesn't has My Account text on button");
    }


}
