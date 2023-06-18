package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalDynamicTablesPage;
import pages.TechGlobalFrontendProject4;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utils.Driver;

import java.util.List;

public class TechGlobalSteps {

    WebDriver driver;
    TechGlobalFrontendTestingHomePage techGlobalFrontendTestingHomePage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;

    TechGlobalDynamicTablesPage techGlobalDynamicTablesPage;
    TechGlobalFrontendProject4 techGlobalFrontendProject4;

    @Before
    public void setDriver() {
        driver = Driver.getDriver();
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalDynamicTablesPage = new TechGlobalDynamicTablesPage();
        techGlobalFrontendProject4=new TechGlobalFrontendProject4();
    }

    @Given("user selects the {string} option")
    public void user_selects_the_option(String option) {
        techGlobalFrontendTestingHomePage.clickOnCard(option);
    }

    @Then("user should see {string} heading")
    public void user_should_see_heading(String headerText) {
        Assert.assertEquals(headerText, techGlobalLoginFormPage.headingText.getText());
    }

    @When("user enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String username, String password) {
        techGlobalLoginFormPage.usernameInput.sendKeys(username);
        techGlobalLoginFormPage.passwordInput.sendKeys(password);
        techGlobalLoginFormPage.loginButton.click();
    }

    @Then("user should see a {string} message")
    public void user_should_see_a_message(String errorMessage) {

        switch (errorMessage) {
            case "Invalid Username entered!":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.error.getText());
                break;
            case "You are logged in":
                Assert.assertEquals(errorMessage, techGlobalLoginFormPage.successLogin.getText());
                break;
            default:
                throw new NotFoundException("The error message is not defined properly in the feature file");
        }
    }

    @Then("user should see the {string} heading")
    public void user_should_see_the_heading(String headingText) {
        Assert.assertEquals(headingText, techGlobalDynamicTablesPage.headingText.getText());
    }

    @When("user clicks the {string} button")
    public void user_clicks_the_button(String argument) {

        switch (argument) {
            case "ADD PRODUCT":
                techGlobalDynamicTablesPage.addProductButton.click();
                break;
            case "CLOSE":
                techGlobalDynamicTablesPage.closeButton.click();
                break;
            default:
                throw new NotFoundException("The error message is not defined properly in the feature file");
        }
    }

    @Then("validate Add New Product pop-up is displayed")
    public void validate_pop_up_is_displayed() {
        Assert.assertTrue(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
    }

    @Then("user should not see Add New Product pop-up")
    public void user_should_not_see_add_new_product_pop_up() {
        try {
            Assert.assertFalse(techGlobalDynamicTablesPage.modalCardTitle.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }
    @Given("user is on https:\\/\\/techglobal-training.com\\/frontend\\/project{int}")
    public void userIsOnHttpsTechglobalTrainingComFrontendProject(){

    }
    @Then("user should see the “Inventory” heading")
    public void user_should_see_the_inventory_heading() {
        Assert.assertTrue(techGlobalFrontendProject4.tableHeader.isDisplayed());
    }
    @Then("user should see the table with the headers below")
    public void user_should_see_the_table_with_the_headers_below(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult =dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            for (int j = 0; j < expectedResult.get(i).length();j++){
                Assert.assertTrue(techGlobalFrontendProject4.tableHeader.isDisplayed());
                Assert.assertEquals(techGlobalFrontendProject4.tableRows.get(j).getText(),expectedResult);
            }

        }

    }
    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedResult =dataTable.asList();
        for (int i = 0; i < expectedResult.size(); i++) {
            for (int j = 0; j < expectedResult.get(i).length();j++){
                Assert.assertTrue(techGlobalFrontendProject4.tableRows.get(i).isDisplayed());
                Assert.assertEquals(techGlobalFrontendProject4.tableRows.get(j).getText(),expectedResult);
    }}}
    @Then("user should see the “ADD PRODUCT” button is enabled")
    public void user_should_see_the_add_product_button_is_enabled() {
        Assert.assertTrue(techGlobalFrontendProject4.addButton.isEnabled());
    }
    @Then("user should see the “Total = ${double}” text displayed")
    public void user_should_see_the_total_$_text_displayed(Double double1) {
       Assert.assertTrue(techGlobalFrontendProject4.totalAmount.isDisplayed());
    }


}