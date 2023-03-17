package models.components.home_screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItemComponent {

    private final AppiumDriver<MobileElement> appiumDriver;

    private final By productNameSel = MobileBy.AccessibilityId("productName");
    private final By productPriceSel = MobileBy.AccessibilityId("productPrice");
    private final By addToCartBtnSel = MobileBy.AccessibilityId("addToCartBtn");
    public ProductItemComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public String getProductName(){
        return appiumDriver.findElement(productNameSel).getText().trim();
    }

    public int getProductPrice(){
        String productPriceStr = appiumDriver.findElement(productPriceSel).getText().trim();
        return Integer.parseInt(productPriceStr.replace("$", "").trim());
    }

    public void clickOnAddToCartBtn(){
        appiumDriver.findElement(addToCartBtnSel).click();
    }
}
