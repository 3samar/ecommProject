package POM;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.image.Kernel;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, 30);
        this.action = new Actions(DriverManager.getDriver());
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='product-grid-product-info__main-info']")
    private List<WebElement> productLinks;

    @FindBy(xpath = "//a[@data-qa-id='header-search-text-link']")
    private WebElement searchTextLink;

    @FindBy(id = "search-home-form-combo-input")
    private WebElement searchTextField;

    public void enterProductISearchBar(String value) {
        searchTextField.sendKeys(value);
        searchTextField.sendKeys(Keys.ENTER);
    }

    public void clickOnSearchTextLink() {
        searchTextLink.click();
    }

    public void verifyProductLinks(String searchedValue) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(DriverManager.getDriver().findElement(By.xpath("(//div[@class='product-grid-product-info__main-info'])[1]"))));
        Thread.sleep(3000);

        for (int i = 0; i < productLinks.size(); i++) {
            WebElement productLink = DriverManager.getDriver().findElement(By.xpath("(//div[@class='product-grid-product-info__main-info'])[" + (i + 1) + "]"));
            String productName = productLink.getText();
            System.out.println("Product Name: " + productName);
            assert productName.contains(searchedValue);
        }
    }

}
