package models.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.login_screen.LoginComponent;

public class UserPage {

    private final AppiumDriver<MobileElement> appiumDriver;

    public UserPage(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public LoginComponent loginComp() {
        return new LoginComponent(appiumDriver);
    }

    public BottomNavComponent bottomNavComp() {
        return new BottomNavComponent(appiumDriver);
    }
}
