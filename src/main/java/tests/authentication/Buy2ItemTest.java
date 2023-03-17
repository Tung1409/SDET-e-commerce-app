package tests.authentication;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.DataObjectBuilder;
import test_data.PaymentMethod;
import test_data.models.LoginData;
import test_flows.authentication.LoginFlow;
import test_flows.function.OrderItemFlow;
import tests.BaseTest;

public class Buy2ItemTest extends BaseTest {
    private final By loginNotificationSel = MobileBy.AccessibilityId("userPhone");

    @Test(dataProvider = "loginData")
    public void cancelOrderTest(LoginData loginData){
        LoginFlow loginFlow = new LoginFlow(getDriver(), loginData.getEmail(), loginData.getPassword());
        loginFlow.goToUserPage();
        loginFlow.login();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginNotificationSel));
        loginFlow.goToHomePage();
        OrderItemFlow orderItemFlow = new OrderItemFlow(getDriver());
        orderItemFlow.addtOmega3ToCart();
        orderItemFlow.addCleanCodeToCart();
        orderItemFlow.goToCartPage();
        orderItemFlow.checkOut();
        orderItemFlow.inputShippingAddress();
        orderItemFlow.selectCardPaymentMethod(PaymentMethod.MASTER_CARD);
        orderItemFlow.confirmOrder();

    }

    @DataProvider
    private LoginData[] loginData(){
        String fileLocation = "\\src\\main\\java\\test_data\\authentication\\CorrectLoginData.json";
        return DataObjectBuilder.builderDataObject(fileLocation, LoginData[].class);
    }
}
