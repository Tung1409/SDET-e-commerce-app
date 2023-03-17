package test_flows.function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.home_screen.ProductItemComponent;
import models.page.CartPage;
import models.page.HomePage;
import test_data.DataObjectBuilder;
import test_data.PaymentMethod;
import test_data.models.ShippingDataObject;
import test_flows.BaseFlow;

public class OrderItemFlow extends BaseFlow {
    private ShippingDataObject defaultShippingData;
    private PaymentMethod paymentMethod;
    public OrderItemFlow(AppiumDriver<MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public void addtOmega3ToCart(){
        HomePage homePage = new HomePage(appiumDriver);
        ProductItemComponent omega3Comp = new ProductItemComponent(appiumDriver);
        homePage.selectVitaminCatBadge();
        omega3Comp.clickOnAddToCartBtn();
    }

    public void addCleanCodeToCart(){
        HomePage homePage = new HomePage(appiumDriver);
        ProductItemComponent cleanCodeComp = new ProductItemComponent(appiumDriver);
        homePage.selectBookCatBadge();
        cleanCodeComp.clickOnAddToCartBtn();
    }

    public void checkOut(){
        CartPage cartPage = new CartPage(appiumDriver);
        cartPage.clickOnCheckOutBtn();
    }

    public void inputShippingAddress(){
        String shippingDataLocation = "\\src\\main\\java\\test_data\\authentication\\ShippingData.json";
        defaultShippingData = DataObjectBuilder.builderDataObject(shippingDataLocation, ShippingDataObject.class);
        CartPage cartPage = new CartPage(appiumDriver);
        cartPage.inputPhoneNum(defaultShippingData.getPhone());
        cartPage.inputShippingAdd1(defaultShippingData.getShippingAdd1());
        cartPage.inputShippingAdd2(defaultShippingData.getShippingAdd2());
        cartPage.inputCity(defaultShippingData.getCity());
        cartPage.inputZipCode(defaultShippingData.getZipCode());
        cartPage.selectCountry();
        // em dang stuck vu dua country vao select Country
        cartPage.confirmShipping();
    }

    public void selectCardPaymentMethod(PaymentMethod paymentMethod){
        CartPage cartPage = new CartPage(appiumDriver);
        cartPage.selectCardPayMethod();
        switch (paymentMethod){
            case MASTER_CARD:
                cartPage.selectMasterCard();
                break;
            case VISA:
                cartPage.selectVisaCard();
                break;
            case WALLET:
                cartPage.selectWalletCard();
                break;
            default:
                cartPage.selectOtherCard();
                break;
        }
        cartPage.clickOnPaymentConfirmBtn();
    }

    public void cancelOrder(){
        CartPage cartPage = new CartPage(appiumDriver);
        cartPage.clickOnCartBackBtn();
        cartPage.clickOnClearBtn();
    }

    public void confirmOrder(){
        CartPage cartPage = new CartPage(appiumDriver);
        cartPage.clickOnPlaceOrderBtn();

        try {
            Thread.sleep(3000);
        } catch (Exception ignore){}
    }

}
