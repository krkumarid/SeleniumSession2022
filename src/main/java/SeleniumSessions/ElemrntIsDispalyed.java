package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElemrntIsDispalyed
{
    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        By emailId = By.id("input-email");
        // boolean flag = driver.findElement(emailId).isDisplayed();
        // System.out.println(flag);
        if (doDisplayed(emailId)) {
            System.out.println("The element is displayed");
        }

    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static boolean doDisplayed(By loacator)
    {
        return getElement(loacator).isDisplayed();
    }
}
