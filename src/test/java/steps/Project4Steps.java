package steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TechGlobalFrontendProject4;
import utils.Driver;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

public class Project4Steps {
    WebDriver driver;
    TechGlobalFrontendProject4 techGlobalFrontendProject4;

    @Before
    public void setDriver(){
        driver= Driver.getDriver();
        techGlobalFrontendProject4=new TechGlobalFrontendProject4();
    }


    @Then("user should see the “Inventory” heading")
    public void user_should_see_the_inventory_heading() {
        Assert.assertEquals(techGlobalFrontendProject4.heading.getText(),"Inventory");
    }
    @Then("user should see the table with the headers below")
    public void user_should_see_the_table_with_the_headers_below(DataTable dataTable) {
        List<String> expectedHeaders = dataTable.asList();

        for (int i = 0; i < expectedHeaders.size(); i++) {
            Assert.assertEquals(expectedHeaders.get(i), techGlobalFrontendProject4.headers.get(i).getText());

        }}
    @Then("the user should see the table with the rows below")
    public void the_user_should_see_the_table_with_the_rows_below(DataTable dataTable) {
        List<List<String>> expected =dataTable.asLists();
        int index =0;
        for (int i = 0; i < expected.size(); i++) {
            for (int j = 0; j < expected.get(i).size(); j++) {
                Assert.assertTrue(techGlobalFrontendProject4.tableRows.get(index).isDisplayed());
                Assert.assertEquals(techGlobalFrontendProject4.tableRows.get(index++).getText(),expected.get(i).get(j));

            }

        }

    }
    @Then("user should see the “ADD PRODUCT” button is enabled")
    public void user_should_see_the_add_product_button_is_enabled() {
       Assert.assertTrue(techGlobalFrontendProject4.addButton.isEnabled());
    }
    @Then("user should see the “Total = ${double}” text displayed")
    public void user_should_see_the_total_$_text_displayed(Double double1) {
       Assert.assertTrue(techGlobalFrontendProject4.totalAmount.isDisplayed());
    }

    @When("user clicks on the “ADD PRODUCT” button")
    public void userClicksOnTheADDPRODUCTButton() {
        techGlobalFrontendProject4.addButton.click();
    }

    @Then("user should see the “Add New Product” modal with its heading")
    public void userShouldSeeTheAddNewProductModalWithItsHeading() {
        Assert.assertTrue(techGlobalFrontendProject4.modalHeader.isDisplayed());
    }

    @And("user should see the “X” button is enabled")
    public void userShouldSeeTheXButtonIsEnabled() {
        Assert.assertTrue(techGlobalFrontendProject4.xButton.isEnabled());
    }

    @And("user should see the “Please select the quantity” label")
    public void userShouldSeeThePleaseSelectTheQuantityLabel() {
        Assert.assertTrue(techGlobalFrontendProject4.quantityLabel.isDisplayed());
    }

    @And("user should see the “Quantity” input box is enabled")
    public void userShouldSeeTheQuantityInputBoxIsEnabled() {
        Assert.assertTrue(techGlobalFrontendProject4.quantity.isEnabled());
    }

    @And("user should see the “Please enter the name of the product” label")
    public void userShouldSeeThePleaseEnterTheNameOfTheProductLabel() {
        Assert.assertTrue(techGlobalFrontendProject4.quantityName.isDisplayed());
    }

    @And("user should see the “Product” input box is enabled")
    public void userShouldSeeTheProductInputBoxIsEnabled() {
        Assert.assertTrue(techGlobalFrontendProject4.product.isEnabled());
    }

    @And("user should see the “Please enter the price of the product” label")
    public void userShouldSeeThePleaseEnterThePriceOfTheProductLabel() {
        Assert.assertTrue(techGlobalFrontendProject4.priceLabel.isDisplayed());
    }

    @And("user should see the “Price” input box is enabled")
    public void userShouldSeeThePriceInputBoxIsEnabled() {
        Assert.assertTrue(techGlobalFrontendProject4.price.isEnabled());
    }

    @And("user should see the “SUBMIT” button is enabled")
    public void userShouldSeeTheSUBMITButtonIsEnabled() {
        Assert.assertTrue(techGlobalFrontendProject4.submitButton.isEnabled());
    }

    @When("user clicks on the “X” button")
    public void userClicksOnTheXButton() {
        techGlobalFrontendProject4.xButton.click();
    }

    @Then("user should not see the “Add New Product” modal")
    public void userShouldNotSeeTheAddNewProductModal() {
        try {
            Assert.assertFalse( techGlobalFrontendProject4.modalHeader.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    @And("user enters the quantity as “{int}”")
    public void userEntersTheQuantityAs(int num) {
        techGlobalFrontendProject4.quantity.sendKeys("2");
    }

    @And("user enters the product as “Mouse”")
    public void userEntersTheProductAsMouse() {
techGlobalFrontendProject4.product.sendKeys("Mouse");
    }

    @And("user enters the price as “{int}”")
    public void userEntersThePriceAs(int priceOfProduct) {
        techGlobalFrontendProject4.price.sendKeys("100");
    }

    @And("user clicks on the “SUBMIT” button")
    public void userClicksOnTheSUBMITButton() {
        techGlobalFrontendProject4.xButton.click();
    }

    @Then("user should see the table with the new row below")
    public void userShouldSeeTheTableWithTheNewRowBelow(DataTable dataTable) {
        List<String> expectedText = dataTable.asList();

        for(int i = 0; i < expectedText.size(); i++){
            Assert.assertTrue(techGlobalFrontendProject4.newAddedList.get(i).isDisplayed());
            Assert.assertEquals(techGlobalFrontendProject4.newAddedList.get(i).getText(),expectedText.get(i));

        }
    }
}
