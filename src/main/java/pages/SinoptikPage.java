package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by v.shavrova on 1/14/18.
 */
public class SinoptikPage extends BasePage{

    @FindBy(css="input[id='search_city']")
    public static WebElement searchField;

    @FindBy(className = "search_city-submit")
    public static WebElement searchButton;

    @FindBy(className = "day-link")
    public static List<WebElement> dayLinks;

    @FindBy(className = "infoDayweek")
    public static WebElement dayInfo;

    @FindBy(className = "today-time")
    public static WebElement todayWeatherText;

    @FindBy(className = "weatherDetails")
    public static WebElement table;

    public SinoptikPage(WebDriver driver){
        super(driver);
    }

    public void makeSearch(String searchKey){
        searchField.sendKeys(searchKey);
        searchButton.click();
    }

    public void openTab(String day){
        for (WebElement element: dayLinks){
            if(element.getText().equals(day)) {//searching in list for needed day
                element.click();//open tab
            }
            }
        }
    public boolean tabIsOpened(String day){
        if(todayWeatherText.isDisplayed() || dayInfo.getText().equals(day))//if day is today check todayWeatherText is displayed otherwise check selected day == day
            return true;
        else return false;
    }

    public boolean isPressureInRange(int rangeFrom, int rangeTo){
        List<WebElement> pressureRow = table.findElements(By.xpath("//tr[5]/td"));//get pressure row
        for(WebElement element : pressureRow) {//iterate tru rows
            if (!element.getText().isEmpty()) {//rid if empty lines
                int pressureValue = Integer.parseInt(element.getText());
                if (pressureValue >= rangeFrom && pressureValue <= rangeTo)//check range
                    return true;
            }
        }
        return false;
    }
}
