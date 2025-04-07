package POM;

import core.DriverManager;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    public ProductsDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, 30);
        this.action = new Actions(DriverManager.getDriver());
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//*[@data-qa-qualifier='media-image'])[1]")
    private WebElement productImage;

    @FindBy(xpath = "//*[@class='product-detail-description product-detail-info__description']")
    private WebElement productDescription;

    @FindBy(xpath = "//div[@data-qa-id='product-detail-info']//span[@class='money-amount__main']")
    private WebElement productPrice;

    @FindBy(xpath = "//h1[@data-qa-qualifier='product-detail-info-name']")
    private WebElement productTitle;


    public String getProductDetails(String fieldName) {
        if (fieldName.equals("productTitle"))  return productTitle.getText();
        else if (fieldName.equals("productPrice")) return productPrice.getText();
        else return productDescription.getText();
    }

    public void clickOnProductImage() {
        wait.until(ExpectedConditions.elementToBeClickable(productImage));
        productImage.click();
    }


}
