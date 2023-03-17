package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.page.HomePage;
import org.testng.Assert;
import test_flows.BaseFlow;

public class CheckItemDetailsFlow extends BaseFlow {
    public CheckItemDetailsFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void verifyOmega3(){
        String expectedProductName = "Omega 3";
        String expectedProductBrand = "Natural";
        String expectedProductStatus = "Availability: Available";
        String expectedProductDes = "Good for heart";
        int expectedProductPrice = 14;
        verifyProduct(expectedProductName, expectedProductBrand, expectedProductStatus,
                expectedProductDes, expectedProductPrice);
    }

    public void verifyCleanCode(){
        String expectedProductName = "Clean code";
        String expectedProductBrand = "Book";
        String expectedProductStatus = "Availability: Available";
        String expectedProductDes = "Clean code";
        int expectedProductPrice = 35;
        verifyProduct(expectedProductName, expectedProductBrand, expectedProductStatus,
                expectedProductDes, expectedProductPrice);
    }

    private void verifyProduct( String expectedProductName, String expectedProductBrand,
                              String expectedProductStatus, String expectedProductDes, int expectedProductPrice){
        HomePage homePage = new HomePage(appiumDriver);
        homePage.searchAndClickOnItem(expectedProductName);
        String actualProductName = homePage.getProductName();
        String actualProductBrand = homePage.getProductBrand();
        String actualProductStatus = homePage.getProductStatus();
        String actualProductDes = homePage.getProductDescription();
        int actualProductPrice = homePage.getProductPrice();

        Assert.assertEquals(actualProductName, expectedProductName, "[ERR] Wrong product name");
        Assert.assertEquals(actualProductBrand, expectedProductBrand, "[ERR] Wrong product brand");
        Assert.assertEquals(actualProductStatus, expectedProductStatus, "[ERR] Wrong product status");
        Assert.assertEquals(actualProductDes, expectedProductDes, "[ERR] Wrong product description");
        Assert.assertEquals(actualProductPrice, expectedProductPrice, "[ERR] Wrong product price");
    }
}
