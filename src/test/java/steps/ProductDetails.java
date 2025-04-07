package steps;

import POM.ProductsDetailsPage;
import core.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductDetails {
    ProductsDetailsPage productPage= new ProductsDetailsPage(DriverManager.getDriver());

    @And("the user selects a product from the search results")
    public void selectProduct() {

    productPage.clickOnProductImage();
    }
    @Then("the product title should be displayed correctly")
    public void verifyProductTitle(DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap();
        for (Map.Entry<String, String> entry : formData.entrySet()) {
            String actualValue =productPage.getProductDetails(entry.getKey());
            assert actualValue.contains(entry.getValue()) : "Expected title: " + entry.getValue() + ", but got: " + actualValue;
        }

    }

}
