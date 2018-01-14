package scenario;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SinoptikPage;

/**
 * Created by v.shavrova on 1/14/18.
 */

public class SinoptikTest extends TestSetup {

    @Test
    public void searchCity(){
        onSinoptikPage.open(BASE_URL);
        onSinoptikPage.makeSearch("Драгобрат");
    }

    @Test(dependsOnMethods={"searchCity"})
    public void openTabDay(){
        onSinoptikPage.openTab("Воскресенье");
        Assert.assertTrue(onSinoptikPage.tabIsOpened("Воскресенье"), "Tab not opened");
    }

    @Test (dependsOnMethods={"openTabDay"})
    public void checkPressure(){
        Assert.assertTrue(onSinoptikPage.isPressureInRange(600, 700), "Pressure is not in range");
    }
}
