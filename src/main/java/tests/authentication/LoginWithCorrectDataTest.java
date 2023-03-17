package tests.authentication;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.models.LoginData;
import test_flows.authentication.LoginFlow;
import tests.BaseTest;

public class LoginWithCorrectDataTest extends BaseTest {
    private final By userPhoneSel = MobileBy.AccessibilityId("userPhone");

    @Test(dataProvider = "loginData")
    public void loginWithCorrectData(LoginData loginData){
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginData.getEmail(), loginData.getPassword());
        loginFlow.goToUserPage();
        loginFlow.login();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userPhoneSel));

    }

//TODO write test flow
    @DataProvider
    private LoginData[] loginData(){
        String fileLocation = "\\src\\main\\java\\test_data\\authentication\\CorrectLoginData.json";
        return DataObjectBuilder.builderDataObject(fileLocation, LoginData[].class);
    }
}
