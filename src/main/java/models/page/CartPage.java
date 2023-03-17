package models.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support_function.SwipeController;

public class CartPage {
    private final By clearBtnSel = MobileBy.AccessibilityId("clearCartBtn");
    private final By checkOutBtnSel = MobileBy.AccessibilityId("checkoutBtn");
    private final By emptyCartMsgSel = MobileBy.AccessibilityId("emptyCartSuggestionMsg");
    private final By cartBackBtnSel = MobileBy.AccessibilityId("Cart, back");
    private final By cartHeaderSel = MobileBy.AccessibilityId("cartHeader");
    private final By phoneFieldSel = MobileBy.AccessibilityId("phoneNum");
    private final By shippingAdd1Sel = MobileBy.AccessibilityId("shippingAdd1");
    private final By shippingAdd2Sel = MobileBy.AccessibilityId("shippingAdd2");
    private final By shippingCitySel = MobileBy.AccessibilityId("shippingCity");
    private final By zipCodeSel = MobileBy.AccessibilityId("shippingZIPCode");
    private final By countryDropdownSel = MobileBy.AccessibilityId("selectCountryTrigger");
    private final By confirmShippingBtnSel = MobileBy.AccessibilityId("confirmShippingFormBtn");
    private final By paymentHeaderSel = MobileBy.AccessibilityId("paymentTabHeader");
    private final By cashOnDeliverySel = MobileBy.AccessibilityId("Cash on Delivery");
    private final By bankTransferSel = MobileBy.AccessibilityId("Bank Transfer");
    private final By cardPaymentSel = MobileBy.AccessibilityId("Card Payment");
    private final By cardPaymentDropdownSel = MobileBy.id("android:id/text1");
    private final By walletCardSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Wallet\")");
    private final By visaCardSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Visa\")");
    private final By masterCardSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"MasterCard\")");
    private final By otherCardSel = MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"Other\")");
    private final By paymentConfirmBtn = MobileBy.AccessibilityId("confirmBtn");
    private final By confirmOrderHeader = MobileBy.AccessibilityId("confirmTabHeader");
    private final By placeOrderBtnSel = MobileBy.AccessibilityId("placeOrderBtn");
    private final AppiumDriver<MobileElement> appiumDriver;

    public CartPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnClearBtn(){
        appiumDriver.findElement(clearBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsgSel));
    }

    public void clickOnCheckOutBtn(){
        appiumDriver.findElement(checkOutBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBackBtnSel));
    }

    public void inputPhoneNum(String phoneNum){
        MobileElement inputPhoneNumElem = appiumDriver.findElement(phoneFieldSel);
        inputPhoneNumElem.sendKeys(phoneNum);
    }

    public void inputShippingAdd1(String add1){
        MobileElement shippingAdd1Elem = appiumDriver.findElement(shippingAdd1Sel);
        shippingAdd1Elem.sendKeys(add1);
    }

    public void inputShippingAdd2(String add2){
        MobileElement shippingAdd2Elem = appiumDriver.findElement(shippingAdd2Sel);
        shippingAdd2Elem.sendKeys(add2);
    }

    public void inputCity(String city){
        MobileElement cityElem = appiumDriver.findElement(shippingCitySel);
        cityElem.sendKeys(city);
    }

    public void inputZipCode(String zipCode){
        MobileElement zipCodeElem = appiumDriver.findElement(zipCodeSel);
        zipCodeElem.sendKeys(zipCode);
    }

    public void selectCountry(){
        MobileElement countryDropdownElem = appiumDriver.findElement(countryDropdownSel);
        countryDropdownElem.click();
        String countryStr = "//*[@text='Argentina']";
        appiumDriver.findElement(MobileBy.xpath(countryStr)).click();
//        String countryStr = "//*[@text='\"" + country + "\"']";
//        By countrySel = MobileBy.xpath(countryStr);
//        MobileElement countryElem = null;
//
//        try {
//            countryElem = countryDropdownElem.findElement(countrySel);
//        } catch (Exception ignored){}
//        if (countryElem != null){
//            countryElem.click();
//        }else {
//            throw new RuntimeException("The option " + country + " is not existing to select");
//        }

    }

    public void confirmShipping(){
        SwipeController swipe = new SwipeController(appiumDriver,50, 50, 50, 40,1);
        swipe.swipeToDestination();
        appiumDriver.findElement(confirmShippingBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentHeaderSel));
    }

    public void selectCODPayMethod(){
        appiumDriver.findElement(cashOnDeliverySel).click();
    }

    public void selectBankTransferPayMethod(){
        appiumDriver.findElement(bankTransferSel).click();
    }

    public void selectCardPayMethod(){
        appiumDriver.findElement(cardPaymentSel).click();
        appiumDriver.findElement(cardPaymentDropdownSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver,5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(walletCardSel));
    }

    public void selectWalletCard(){
        appiumDriver.findElement(walletCardSel).click();
    }

    public void selectVisaCard(){
        appiumDriver.findElement(visaCardSel).click();
    }

    public void selectMasterCard(){
        appiumDriver.findElement(masterCardSel).click();
    }

    public void selectOtherCard(){
        appiumDriver.findElement(otherCardSel).click();
    }

    public void clickOnPaymentConfirmBtn(){
        appiumDriver.findElement(paymentConfirmBtn).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderHeader));
    }

    public void clickOnCartBackBtn(){
        appiumDriver.findElement(cartBackBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartHeaderSel));
    }

    public void clickOnPlaceOrderBtn(){
        appiumDriver.findElement(placeOrderBtnSel).click();
        WebDriverWait wait = new WebDriverWait(appiumDriver, 3L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsgSel));
    }

}
