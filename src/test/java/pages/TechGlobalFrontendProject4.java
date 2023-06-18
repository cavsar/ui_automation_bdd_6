package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalFrontendProject4 {

    public TechGlobalFrontendProject4() {
        PageFactory.initElements(Driver.getDriver(), this);        }


    @FindBy(css = ".is-size-2")
    public WebElement heading;

    @FindBy(css="tr[class^='Dynamic']")
    public WebElement tableHeader;

    @FindBy(css="tbody>tr")
    public List<WebElement> tableRows;

    @FindBy(id="add_product_btn")
    public WebElement addButton;

    @FindBy(id="total_amount")
    public WebElement totalAmount;


}
