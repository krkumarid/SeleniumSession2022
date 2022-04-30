package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.freshworks.com/");
        
        // By userName = By.name("email");
        // By pass = By.xpath("//input[@type='password']");
        
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // WebElement userName_ele =
        // wait.until(ExpectedConditions.presenceOfElementLocated(userName));
        // userName_ele.sendKeys("krkumari77d@gmail.com");
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // WebElement pass_ele =
        // wait.until(ExpectedConditions.presenceOfElementLocated(pass));
        // pass_ele.sendKeys("KasiAppu1*");
        // Exception in thread "main" org.openqa.selenium.TimeoutException: Expected
        // condition failed: waiting for presence of element located by:
        
        // By.name: emkail (tried for 10 second(s) with 500 milliseconds interval)
        
        // doPresenceOfElementLocated(userName, 10).sendKeys("krkumarid@gmail.com");
        // doSendKeys(userName, "krkumarid@gmail.com", 10);
        // driver.findElement(pass).sendKeys("KasiAppu1*");
        // // How to increase the time out
        By footer = By.xpath("//footer//ul[@class='footer-nav']//a");
        List<WebElement> footerList = waitForElementsToBeVisible(footer, 10, 2000);
        System.out.println(footerList.size());
        for (WebElement e : footerList)
        {
            System.out.println(e.getText());
        }
        System.out.println("-------------------------------------------");
        if (getElementTextWithWait(footer, 10).contains("Partners"))
        {
            System.out.println("PASS");
        }
    }
    
    public static void doSendKeys(By loactor, String value, int timeOut)
    {
        doPresenceOfElementLocated(loactor, timeOut).sendKeys(value);
    }
    
    public static WebElement doPresenceOfElementLocated(By locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement doPresenceOfElementLocated(By locator, int timeout, long pollingTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public static WebElement isElementVisible(By locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement isElementVisible(By locator, int timeout, long pollingTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static List<WebElement> waitForElementsToBeVisible(By locator, int timeout)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public static List<WebElement> waitForElementsToBeVisible(By locator, int timeout, long pollingTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout), Duration.ofMillis(pollingTime));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static List<String> getElementTextWithWait(By locator, int timeOut)
    {
        List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
        List<String> eleTextList = new ArrayList<String>();
        for (WebElement e : eleList)
        {
            eleTextList.add(e.getText());
        }
        return eleTextList;
    }
    
    public static WebElement waitForElementTobeVisibleWithElement(By locator, int timeOut, long pollingTime)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(pollingTime));
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }
}
