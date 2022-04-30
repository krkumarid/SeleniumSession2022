package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelectTag
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        
        // WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
        //
        // Select select = new Select(country);// select class always expecting a web
        // element
        //
        // // index may change
        // select.selectByIndex(5);// use it for days,month
        //
        // // Prefer selectByVisibleText
        // // pass the exact text
        // select.selectByVisibleText("India"); // text
        //
        // select.selectByValue("Aruba"); // value attribute
        //
        By country = By.id("Form_submitForm_Country");
        doDropDownSelectByIndex(country, 11);
        doDropDownSelectByVisibleText(country, "India");
        doDropDownSelectByValue(country, "China");
    }

    public static WebElement getElement(By loactor)
    {
        return driver.findElement(loactor);
    }
    
    public static void doDropDownSelectByIndex(By locator, int index)
    {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);

    }
    
    public static void doDropDownSelectByVisibleText(By locator, String text)
    {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);

    }
    
    public static void doDropDownSelectByValue(By locator, String value)
    {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);

    }
}
