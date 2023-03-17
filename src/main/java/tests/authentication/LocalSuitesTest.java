package tests.authentication;

import io.appium.java_client.MobileBy;
import org.testng.annotations.Test;
import tests.BaseTest;

public class LocalSuitesTest extends BaseTest {

    @Test
    public void localSuitesTest(){
        getDriver().findElement(MobileBy.AccessibilityId("userIcon")).click();
        try {
            Thread.sleep(3000);
        } catch (Exception ignore){}
    }
}
