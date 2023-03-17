package models.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import models.components.home_screen.ProductItemComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final By searchInputSel = MobileBy.AccessibilityId("searchInput");
    private final By matchedItemSel = MobileBy.AccessibilityId("matchedItem");
    private final By productBrandSel = MobileBy.AccessibilityId("productName");
    private final By homeBackBtnSel = MobileBy.AccessibilityId("Home, back");
    private final By productNameSel = MobileBy.AccessibilityId("productBrand");
    private final By productAvailabilitySel = MobileBy.AccessibilityId("productAvailability");
    private final By productDescriptionSel = MobileBy.AccessibilityId("productDesc");
    private final By productPriceSel = MobileBy.AccessibilityId("productPrice");
    private final By allCatBadgeSel = MobileBy.AccessibilityId("categoryBadge");
    private final By vitaminCatBadgeSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Vitamin\")");
    private final By bookCatBadgeSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Book\")");
    private final AppiumDriver<MobileElement> appiumDriver;

    public HomePage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void searchAndClickOnItem(String itemName){
        appiumDriver.findElement(searchInputSel).click();
        appiumDriver.findElement(searchInputSel).sendKeys(itemName);
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(matchedItemSel));
        appiumDriver.findElement(matchedItemSel).click();
        appiumDriver.findElement(matchedItemSel).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBackBtnSel));
    }

    public String getProductName(){
        return appiumDriver.findElement(productNameSel).getText().trim();
    }

    public String getProductBrand(){
        return appiumDriver.findElement(productBrandSel).getText().trim();
    }

    public String getProductStatus(){
        return appiumDriver.findElement(productAvailabilitySel).getText().trim();
    }

    public String getProductDescription(){
        return appiumDriver.findElement(productDescriptionSel).getText().trim();
    }

    public int getProductPrice() {
        String itemPriceStr = appiumDriver.findElement(productPriceSel).getText().trim();
        return Integer.parseInt(itemPriceStr.replace("$","").trim());

    }
    public void selectAllCatBadge(){
        appiumDriver.findElement(allCatBadgeSel).click();
    }

    public void selectVitaminCatBadge(){
        appiumDriver.findElement(vitaminCatBadgeSel).click();
    }

    public void selectBookCatBadge(){
        appiumDriver.findElement(bookCatBadgeSel).click();
    }

    public ProductItemComponent productItemComp(){
        return new ProductItemComponent(appiumDriver);
    }

}
