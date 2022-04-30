package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept
{
    public static WebDriver driver;
    
    public static void main(String[] args)
    {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        // WebElement firstName = driver.findElement(By.id("Form_submitForm_Name11"));
        // firstName.sendKeys("Rajeevkumar");
        // When u are passing the wrong locator
        // org.openqa.selenium.NoSuchElementException: no such element: Unable to locate
        // element
        // this exception is coming from Selenium
        // Whenever the id is updating the locators ,we have to update the locators too
        
        // What about findelements?

        // When the locator for findElements changed,it will not throw an exception ..
        // No Exception
        // instead the size will be 0;This is a empty list.
        List<WebElement> list = driver.findElements(By.className("text11"));
        
        System.out.println(list.size());
        // if list size is zero?
    }

}
