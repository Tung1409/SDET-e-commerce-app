package test_flows;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;

public class BaseFlow {
    protected final AppiumDriver<MobileElement> appiumDriver;

    public BaseFlow(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void goToHomePage(){
        new BottomNavComponent(appiumDriver).clickOnHomeIcon();
    }
    public void goToCartPage(){
        new BottomNavComponent(appiumDriver).clickOnCartIcon();
    }

    public void goToUserPage(){
        new BottomNavComponent(appiumDriver).clickOnUserIcon();
    }
}
