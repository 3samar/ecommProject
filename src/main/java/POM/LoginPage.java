package POM;

import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, 30);
        this.action = new Actions(DriverManager.getDriver());
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@data-qa-id='layout-header-user-logon']")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@data-qa-id='logon-view-alternate-button']")
    private WebElement registerButton;

    @FindBy(xpath = "//*[@class='content-header__description']")
    private WebElement registerationSuccessMessage;


    @FindBy(xpath = "//input[@data-qa-input-qualifier='privacyCheck']")
    private WebElement acceptTermsAndConditionsCheckbox;

    @FindBy(xpath = "//*[@data-qa-action='sign-up-submit']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//button[@data-qa-id='oauth-logon-button']")
    private WebElement oAuthLoginButton;

    @FindBy(xpath = "//*[@data-qa-id='logon-form-submit']")
    private WebElement finalLoginButton;

    @FindBy(xpath = "//*[@class='zds-alert-dialog__description']")
    private WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void clickFinalLoginButton() {
        finalLoginButton.click();
    }

    public void clickOAuthLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(oAuthLoginButton));
        oAuthLoginButton.click();
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public String getTextOfRegistrationSuccessMessage() {
       return registerationSuccessMessage.getText();
    }

    public void clickAcceptTermsAndConditionsCheckbox() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", acceptTermsAndConditionsCheckbox);
//        action.moveToElement(acceptTermsAndConditionsCheckbox).click(acceptTermsAndConditionsCheckbox).build().perform();
    }

    public void enterRegistrationDetails(String fieldName, String value) {
        DriverManager.getDriver().findElement(By.xpath("//*[@name='"+fieldName+"']")).sendKeys(value);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
    }
    public void clickLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        action.moveToElement(loginButton).click(loginButton).build().perform();
    }
}
