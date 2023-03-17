package test_flows.authentication;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.components.global.BottomNavComponent;
import models.components.login_screen.LoginComponent;
import models.page.UserPage;
import test_flows.BaseFlow;

public class LoginFlow extends BaseFlow {
    private String email;
    private String password;

    public LoginFlow(AppiumDriver<MobileElement> appiumDriver, String email, String password) {
        super(appiumDriver);
        this.email = email;
        this.password = password;
    }

    public void login() {
        UserPage userPage = new UserPage(appiumDriver);
        LoginComponent loginComp = userPage.loginComp();
        if (!email.isEmpty()) {
            loginComp.inputEmail(email);
        }

        if (!password.isEmpty()) {
            loginComp.inputPassword(password);
        }

        loginComp.clickOnLoginBtn();
    }
}
