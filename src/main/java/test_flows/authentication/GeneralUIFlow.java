package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.home_screen.ProductItemComponent;
import models.page.HomePage;
import org.testng.Assert;
import test_flows.BaseFlow;

public class GeneralUIFlow extends BaseFlow {
    String expectedVitaminName = "Omega 3";
    int expectedVitaminPrice = 14;

    String expectedBookName = "Clean code";
    int expectedBookPrice = 35;
    public GeneralUIFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void checkVitaminCatAndItemList(){
        HomePage homePage = new HomePage(appiumDriver);
        ProductItemComponent productItemComp = new ProductItemComponent(appiumDriver);
        homePage.selectVitaminCatBadge();
        String actualVitaminName = productItemComp.getProductName();
        int actualVitaminPrice = productItemComp.getProductPrice();

        Assert.assertEquals(actualVitaminName, expectedVitaminName, "[ERR] Wrong vitamin name");
        Assert.assertEquals(actualVitaminPrice, expectedVitaminPrice, "[ERR] Wrong vitamin price");

    }

    public void checkBookCatAndItemList(){
        HomePage homePage = new HomePage(appiumDriver);
        ProductItemComponent productItemComp = new ProductItemComponent(appiumDriver);
        homePage.selectBookCatBadge();
        String actualBookName = productItemComp.getProductName();
        int actualBookPrice = productItemComp.getProductPrice();

        Assert.assertEquals(actualBookName, expectedBookName, "[ERR] Wrong book name");
        Assert.assertEquals(actualBookPrice, expectedBookPrice, "[ERR] Wrong book price");

    }
}
