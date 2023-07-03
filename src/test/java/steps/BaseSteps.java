package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Project04Page;
import pages.TechGlobalFrontendProject5Page;
import utils.Driver;

public class BaseSteps {

    WebDriver driver;
    Project04Page project04Page = new Project04Page();
    TechGlobalFrontendProject5Page techGlobalFrontendProject5Page = new TechGlobalFrontendProject5Page();

    @Before
    public void setup() {
        driver = Driver.getDriver();
    }

    @Given("user navigates to {string}")
    public void userNavigatesTo(String url) {
        driver.get(url);
    }

    @Then("user should see {string} in the url")
    public void userShouldSeeInTheUrl(String key) {
//        String newKey = driver.getCurrentUrl().replaceAll("_", " ");
//        Assert.assertTrue(newKey.contains(key));

        for (String word : key.split(" ")) {
            Assert.assertTrue(driver.getCurrentUrl().contains(word));

        }
    }

    @And("user should see {string} in the title")
    public void userShouldSeeInTheTitle(String key) {
        Assert.assertTrue(driver.getTitle().contains(key));
    }

    @Then("the user should see the {string} heading")
    public void the_user_should_see_the_heading(String headingText) {

        switch (headingText) {
            case "Inventory":
                Assert.assertEquals(headingText, project04Page.mainHeading.getText());
                break;
            case "Pagination":
                Assert.assertEquals(headingText, techGlobalFrontendProject5Page.mainHeading.getText());
                break;
            case "World City Population 2022":
                Assert.assertEquals(headingText, techGlobalFrontendProject5Page.subHeading.getText());
                break;
            default:

        }

    }
    @Then("the user should see the {string} button is enabled")
    public void the_user_should_see_the_button_is_enabled(String button) {
        switch (button){
            case "ADD PRODUCT":
                Assert.assertTrue(project04Page.addProductButton.isEnabled());
                break;
            case "X":
                Assert.assertTrue(project04Page.closeButton.isEnabled());
                break;
            case "SUBMIT":
                Assert.assertTrue(project04Page.submitButton.isEnabled());
                break;
            case "Next":
                Assert.assertTrue(techGlobalFrontendProject5Page.nextButton.isEnabled());
                break;
            case "Previous":
                Assert.assertTrue(techGlobalFrontendProject5Page.previousButton.isEnabled());
                break;
            default:
        }
    }
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        switch (button) {
            case "ADD PRODUCT":
                project04Page.addProductButton.click();
                break;
            case "X":
                project04Page.closeButton.click();
                break;
            case "SUBMIT":
                project04Page.submitButton.click();
                break;
            case "Next":
                techGlobalFrontendProject5Page.nextButton.click();
                break;
            default:
        }
    }
}
