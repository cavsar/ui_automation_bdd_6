package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.TechGlobalFrontendProject5Page;
import utils.Driver;
import utils.TableHandler;

import java.util.List;

public class Project05Steps {
    WebDriver driver;
    TechGlobalFrontendProject5Page techGlobalFrontendProject5Page;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        techGlobalFrontendProject5Page = new TechGlobalFrontendProject5Page();

    }


    @Then("the user should see the {string} paragraph")
    public void user_should_see_the_paragraph(String paragraph) {
        Assert.assertEquals(paragraph,techGlobalFrontendProject5Page.paragraph.getText());
    }

    @Then("user should see the {string} button is disabled")
    public void user_should_see_the_button_is_disabled(String button) {
        switch (button){
            case "Previous":
                Assert.assertFalse(techGlobalFrontendProject5Page.previousButton.isEnabled());
                break;
            case "Next":
                Assert.assertFalse(techGlobalFrontendProject5Page.nextButton.isEnabled());
                break;
            default:
        }
    }

    @When("the user clicks on the {string} button till it becomes disabled")
    public void theUserClicksOnTheButtonTillItBecomesDisabled(String button) {
        techGlobalFrontendProject5Page.clickNextButton();
    }


    @Then("user should see {string} City with the info below and an image")
    public void user_should_see_city_with_the_info_below_and_an_image(String string, DataTable dataTable) {
        List<String> countriesDetails = dataTable.asList();
        for (int i = 0; i < countriesDetails.size(); i++) {
            Assert.assertTrue(techGlobalFrontendProject5Page.cityImage.isDisplayed());
            Assert.assertEquals(countriesDetails.get(i),techGlobalFrontendProject5Page.cityInfo.get(i).getText());
            
        }

    }



}
