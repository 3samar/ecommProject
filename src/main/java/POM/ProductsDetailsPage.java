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


    @FindBy(xpath = "//*[@data-qa-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@data-qa-id='layout-header-go-to-cart']")
    private WebElement goToCartButton;

    @FindBy(xpath = "//span[@data-qa-qualifier='totals-total-amount']")
    private WebElement cartTotalPrice;

    @FindBy(xpath = "//button[@data-qa-id='shop-continue']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@data-qa-id='guest-continue-link']")
    private WebElement continueAsAGuestButton;

    public void clickOnContinueAsAGuestButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueAsAGuestButton));
        continueAsAGuestButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public String getCartTotalPrice() {
        return cartTotalPrice.getText();
    }

    public void clickOnGoToCartButton() {
        goToCartButton.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

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
