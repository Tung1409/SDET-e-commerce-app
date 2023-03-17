package models.components.global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class BottomNavComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final static By homeIconSel = MobileBy.AccessibilityId("homeIcon");
    private final static By cartIconSel = MobileBy.AccessibilityId("cartIcon");
    private final static By userIconSel = MobileBy.AccessibilityId("userIcon");
    public BottomNavComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void clickOnHomeIcon(){
        appiumDriver.findElement(homeIconSel).click();
    }

    public void clickOnCartIcon(){
        appiumDriver.findElement(cartIconSel).click();
    }

    public void clickOnUserIcon(){
        appiumDriver.findElement(userIconSel).click();
    }
}
