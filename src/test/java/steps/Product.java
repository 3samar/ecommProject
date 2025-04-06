package steps;

import POM.ProductPage;
import core.DriverManager;
import core.constants.Common;
import core.utils.ExcelUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Product {
ProductPage productPage= new ProductPage(DriverManager.getDriver());

    @Given("the user is on the product search page")
    public void gotoProductSearchPage() {
        productPage.clickOnSearchTextLink();
    }

    @When("the user enters a valid search keyword")
    public void enterValidSearchKeyword(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            productPage.enterProductISearchBar(entry.getValue());
        }

    }
    @Then("the user should see relevant products in the search results")
    public void verifyProductLinks() throws InterruptedException {
        String formData = ExcelUtils.getCellData(Common.EXCEL_PATH, "testData", 3, 1);
            productPage.verifyProductLinks(formData);

    }
}
