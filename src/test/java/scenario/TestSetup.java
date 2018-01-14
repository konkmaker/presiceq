package scenario;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.SinoptikPage;

/**
 * Created by v.shavrova on 1/14/18.
 */
public class TestSetup {
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String OPERA = "opera";
    public static final String SAFARI = "safari";
    protected static final String BASE_URL = "https://sinoptik.ua/";
    protected static SinoptikPage onSinoptikPage;

    public WebDriver driver;

    @BeforeClass
    public void init() {
        driver = createDriver("chrome");

        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        onSinoptikPage = PageFactory.initElements(driver, SinoptikPage.class);

    }


    public static WebDriver createDriver(String browser) {
        WebDriver webDriver = null;
        if (CHROME.equals(browser)) {
            setChromeDriver();
            webDriver = new ChromeDriver();
        } else if (FIREFOX.equals(browser)) {
            webDriver = new FirefoxDriver();
        } else if (OPERA.equals(browser)) {
            webDriver = new OperaDriver();
        } else if (SAFARI.equals(browser)) {
            webDriver = new SafariDriver();
        }
        return webDriver;
    }
    private static void setChromeDriver() {
        String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
        String chromeBinary = "src/main/resources/chrome/chromedriver"
                + (os.equals("win") ? ".exe" : "");
        System.setProperty("webdriver.chrome.driver", chromeBinary);
    }

    @AfterClass
    public void after(){
        if (driver != null) {
            driver.quit();
        }
    }
}
