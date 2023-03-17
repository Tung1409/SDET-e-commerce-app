package tests.authentication;

import org.testng.annotations.Test;
import test_flows.authentication.GeneralUIFlow;
import tests.BaseTest;

public class GeneralUITest extends BaseTest {

    @Test
    public void generalUITest(){
        GeneralUIFlow generalUIFlow = new GeneralUIFlow(getDriver());
        generalUIFlow.checkVitaminCatAndItemList();
        generalUIFlow.checkBookCatAndItemList();

    }
}
