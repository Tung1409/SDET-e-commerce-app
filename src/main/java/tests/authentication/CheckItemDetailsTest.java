package tests.authentication;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;
import test_flows.authentication.CheckItemDetailsFlow;
import tests.BaseTest;

public class CheckItemDetailsTest extends BaseTest {

    @Test
    public void checkItemDetailsTest(){
        CheckItemDetailsFlow checkItemDetailsFlow = new CheckItemDetailsFlow(getDriver());
        checkItemDetailsFlow.verifyOmega3();
    }
}
