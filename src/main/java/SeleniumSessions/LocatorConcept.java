package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept
{
    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        // create the Webelement + actions (
        // click,sendKeys,getText,isDiplayed,isEnabled.

        // 1. Approach
//        driver.findElement(By.id("input-email")).sendKeys("krkumarid@gmail.com");
//        driver.findElement(By.id("input-password")).sendKeys("venkida");
        // driver.findElement(By.id(null))
        // 2.Approach reusable webelemts
//        WebElement emailId = driver.findElement(By.id("input-email"));
//        WebElement password = driver.findElement(By.id("input-password"));
//
//        emailId.sendKeys("krkumarid@gmail.com");
//        password.sendKeys("venkida");

        // 3.Approach By.id() not hitting the server
//        By useName = By.id("input-email");
//        By pasword = By.id("input-password");
//
//        driver.findElement(useName).sendKeys("krkumarid@gmail.com");
//        driver.findElement(pasword).sendKeys("venkida");

        // 4.Approch By locator with generic method( avoiding the findelements line
//        By userName = By.id("input-email");
//        By password = By.id("input-password");
//
//        getElement(userName).sendKeys("krkumarid@gmail.com");
//        getElement(password).sendKeys("venkida");

        // 5th Approach By locator with generic method( getElement() with action
        // methods)

//        By userName = By.id("input-email");
//        By password = By.id("input-password");
//
//        doSendKeys(userName, "krkumarid@gmail.com");
//        doSendKeys(password, "venkida");
//
        // 6th ElememtUtil class with generic methods
//        By userName = By.id("input-email");
//        By password = By.id("input-password");
//
//        ElementUtil elmUtil = new ElementUtil(driver);
//        elmUtil.doSendKeys(userName, "krkumarid@gmail.com");
//        elmUtil.doSendKeys(password, "venkida");

        // 7th Approach : String locator values

        String userNameId = "input-email";
        String passwordId = "input-password";
        doSendKeys("id", userNameId, "krkumarid@gmail.com");
        doSendKeys("id", passwordId, "venkida");

        //
    }

    /**
     * this method is a wrapper method or utility method.
     *
     * @param locator
     * @return
     */
    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static WebElement getElement(String locatorType, String locatroValue)
    {
        return driver.findElement(getBy(locatorType, locatroValue));
    }

    public static void doSendKeys(By loactor, String value)
    {
        getElement(loactor).sendKeys(value);
    }

    public static void doSendKeys(String locatorType, String locatorValue, String value)
    {
        getElement(locatorType, locatorValue).sendKeys(value);
    }

    public static By getBy(String locatorType, String locatorValue)
    {
        By locator = null;
        switch (locatorType.toLowerCase()) {
        case "id":
            locator = By.id(locatorValue);
            break;
        default: {
            System.out.println("Please pass the right locator and value......");
        }
        }

        return locator;
    }
}
