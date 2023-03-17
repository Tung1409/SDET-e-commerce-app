package models.components.login_screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginComponent {

    private final AppiumDriver<MobileElement> appiumDriver;
    private final By emailInputSel = MobileBy.AccessibilityId("emailInput");
    private final By passwordInputSel = MobileBy.AccessibilityId("passwordInput");
    private final By loginBtnSel = MobileBy.AccessibilityId("loginBtn");


    public LoginComponent(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    public void inputEmail(String emailText) {
        if (!emailText.isEmpty()) {
            MobileElement emailElem = appiumDriver.findElement(emailInputSel);
            emailElem.clear();
            emailElem.sendKeys(emailText);
        }
    }

    public void inputPassword(String passwordText) {
        if (!passwordText.isEmpty()) {
            WebElement passwordElem = appiumDriver.findElement(passwordInputSel);
            passwordElem.clear();
            passwordElem.sendKeys(passwordText);
        }
    }

    public void clickOnLoginBtn(){
        appiumDriver.findElement(loginBtnSel).click();
    }
}
