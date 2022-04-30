package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        By emailId = By.id("input-email_11");
        
        retryingElement(emailId, 10, 500).sendKeys("krkumarid@gmail.com");
    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static WebElement retryingElement(By locator, int timeOut)
    {
        WebElement element = null;
        int attempt = 0;
        
        while (attempt < timeOut)
        {
            try
            {
                element = getElement(locator);
                break;
            } catch (Exception e)
            {
                System.out.println("The element not found in attempt:" + attempt + ":" + locator);
                try
                {
                    Thread.sleep(500);
                } catch (InterruptedException e1)
                {
                    System.out.println("Inside Catch");
                    e1.printStackTrace();
                }
            }
            attempt++;
        }
        if (element == null)
        {
            try
            {
                throw new Exception("Element not found Exception");
            } catch (Exception e)
            {
                System.out.println("The element not found with " + attempt + "attempts");
            }

        }
        return element;
    }

    public static WebElement retryingElement(By locator, int timeOut, long pollingTime)
    {
        WebElement element = null;
        int attempt = 0;
        
        while (attempt < timeOut)
        {
            try
            {
                element = getElement(locator);
                break;
            } catch (Exception e)
            {
                System.out.println("The element not found in attempt:" + attempt + ":" + locator);
                try
                {
                    Thread.sleep(pollingTime);
                } catch (InterruptedException e1)
                {
                    System.out.println("Inside Catch");
                    e1.printStackTrace();
                }
            }
            attempt++;
        }
        if (element == null)
        {
            try
            {
                throw new Exception("Element not found Exception");
            } catch (Exception e)
            {
                System.out.println("The element not found");
            }

        }
        return element;
    }
}
