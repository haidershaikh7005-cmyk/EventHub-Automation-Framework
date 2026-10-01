package stepdefinitions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;
import factory.DriverFactory;
import pages.MyLoginPage;
import utils.MyConfigReader;

import java.util.Properties;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static factory.DriverFactory.page;
import static org.junit.Assert.assertTrue;

public class MyLoginSteps {
    private MyLoginPage myLoginPage;
    private Properties props;

    public MyLoginSteps() {
        Page page = DriverFactory.getPage();
        myLoginPage = new MyLoginPage(page);

        // ✅ Load mylogin.properties
        MyConfigReader reader = new MyConfigReader();
        props = reader.initProp();
    }

    @Given("user navigates to login page")
    public void navigationToUrl() {
        myLoginPage.navigateToUrl(props.getProperty("baseUrl"));
    }

    @And("user enters username")
    public void enterUsername() {
        myLoginPage.enterUsername(props.getProperty("username"));
    }

    @And("user enters password")
    public void enterPassword() {
        myLoginPage.enterPassword(props.getProperty("password"));
    }

    @And("user click login button")
    public void clickLoginButton() {
        myLoginPage.clickLoginButton();
    }

    @Then("verify that user is logged in and navigated to EventHub page")
    public void verifyEventPage() {
        assertTrue(myLoginPage.isOnEventPage());
    }

}
