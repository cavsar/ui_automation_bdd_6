package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalFrontendProject4 {

    public TechGlobalFrontendProject4() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = ".is-size-2")
    public WebElement heading;

    @FindBy(css = "th[class*=header]")
    public List<WebElement> headers;

    @FindBy(css="tr td")
    public List<WebElement> tableRows;

    @FindBy(id="add_product_btn")
    public WebElement addButton;

    @FindBy(id="total_amount")
    public WebElement totalAmount;

    @FindBy(id = "modal_title")
    public WebElement modalHeader;

    @FindBy(css= ".delete")
    public WebElement xButton;

    @FindBy(css="label[for='product_quantity']")
    public WebElement quantityLabel;

    @FindBy(id ="quantity")
    public WebElement quantity;

    @FindBy(css="label[for='product_name']")
    public WebElement quantityName;

    @FindBy(id ="product")
    public WebElement product;

    @FindBy(css="label[for='product_price']")
    public WebElement priceLabel;

    @FindBy(id ="price")
    public WebElement price;

    @FindBy(id ="submit")
    public WebElement submitButton;

    @FindBy (css = "tr:nth-child(4) td")
    public List<WebElement> newAddedList;


}
