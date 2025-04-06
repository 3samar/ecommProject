package steps;

import POM.LoginPage;
import core.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class UserAuth {
    LoginPage loginPage= new LoginPage(DriverManager.getDriver());

    @Given("the user is on the registration page")
    public void gotoRegistrationPage() {
        loginPage.clickLoginButton();
        loginPage.clickRegisterButton();
    }

    @When("the user enters valid registration details")
    public void enterRegistrationDetails(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            loginPage.enterRegistrationDetails(entry.getKey(), entry.getValue());
        }
        loginPage.clickAcceptTermsAndConditionsCheckbox();
        loginPage.clickCreateAccountButton();



    }

    @Then("the user should see the phone number in message")
    public void verifySuccessMessage(DataTable dataTable) {
        String expectedMessage = dataTable.column(0).get(1)+"";
        String actualMessage = loginPage.getTextOfRegistrationSuccessMessage();
        assert actualMessage.contains(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }

    @Given("the user is on the login page")
    public void gotoLoginPage() {
        loginPage.clickLoginButton();
        loginPage.clickOAuthLoginButton();
    }

    @When("the user enters invalid credentials")
    public void enterCredentials(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            loginPage.enterRegistrationDetails(entry.getKey(), entry.getValue());
        }
        loginPage.clickFinalLoginButton();

    }

    @Then("an error message should be displayed")
    public void verifyErrorMessage() {
        String expectedMessage = "The user name and password provided do not correspond to any account at Zara.com.";
        String actualMessage = loginPage.getErrorMessage();
        assert actualMessage.equals(expectedMessage) : "Expected message: " + expectedMessage + ", but got: " + actualMessage;
    }


}
