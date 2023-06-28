package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobalFrontendProject5Page {
    public TechGlobalFrontendProject5Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".mb-5")
    public WebElement mainHeading;

    @FindBy(id="sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement paragraph;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = ".Pagination_myPagination__JnsKX")
    List<WebElement> countries;






}
