package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by v.shavrova on 1/14/18.
 */
public class BasePage {
    protected WebDriver driver;
    public static final int TIMEOUT = 30;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String page){
        driver.get(page);
    }
}
