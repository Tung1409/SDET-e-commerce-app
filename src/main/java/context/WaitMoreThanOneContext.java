package context;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitMoreThanOneContext implements ExpectedCondition<Boolean> {

    private final AppiumDriver<MobileElement> appiumDriver;

    public WaitMoreThanOneContext(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    @Override
    public Boolean apply(WebDriver webDriver) {
        // minh cho cai gi thi dua vao cai do, tuy muc dich cua minh
        return appiumDriver.getContextHandles().size() > 1;
    }
}
