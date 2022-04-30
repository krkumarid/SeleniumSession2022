package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValueWithoutSelectClass
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        By countryOptions = By.xpath("//select[@id='Form_submitForm_Country']/option");

        selectDropDownValueWithoutSelectClass(countryOptions, "China");

    }

    public static List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }
    
    public static void selectDropDownValueWithoutSelectClass(By locator, String value)
    {
        List<WebElement> countryList = getElements(locator);

        System.out.println(countryList.size());

        for (WebElement e : countryList)
        {
            String text = e.getText();
            System.out.println(text);
            if (text.equals(value))
            {
                e.click();
                break;
            }
        }
    }
    
}
