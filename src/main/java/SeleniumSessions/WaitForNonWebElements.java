package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements
{

    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");

        // wait for URL
        // driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.cssSelector("div#contact-link a")).click();
        if (waitForURLToContain("controller=contact", 5))
        {
            System.out.println("Url Contains PASS");
        }
        if (waitForURLToBe("http://automationpractice.com/index.php?controller=contact", 10))
        {
            System.out.println("URL Check PASS");
        }
        String text = doGetTitleWithFraction("Contact", 10);
        System.out.println(text);
        if (text.equals("Contact us - My Store"))
        {
            System.out.println(" Title Fraction Check PASS");
        }
        String title = doGetTitle("Contact us - My Store", 5);
        if (title.equals("Contact us - My Store"))
        {
            System.out.println("Title Test Pass");
        }
    }
    
    public static String doGetTitleWithFraction(String titleFraction, int timeOut)
    {
        if (waitForTitleContains(titleFraction, timeOut))
        {
            return driver.getTitle();
        }
        return null;
    }
    
    public static String doGetTitle(String title, int timeOut)
    {
        if (waitForTitleToBe(title, timeOut))
        {
            return driver.getTitle();
        }
        return null;
    }

    /**
     * An expectation for the URL of the current page to contain specific text.
     * Parameters:fraction the fraction of the url that the page should be
     * onReturns:true when the URL contains the text
     *
     * @param urlFraction
     * @param timeOut
     * @return
     */
    public static boolean waitForURLToContain(String urlFraction, long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.urlContains(urlFraction));
    }
    
    /**
     * An expectation for the URL of the current page to be a specific url.
     * Parameters:url the url that the page should be onReturns:true when the URL is
     * what it should be
     *
     * @param url
     * @param timeOut
     * @return
     */
    public static boolean waitForURLToBe(String url, int timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.urlToBe(url));
        
    }
    
    public static boolean waitForTitleContains(String titleFraction, int timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.titleContains(titleFraction));
    }

    public static boolean waitForTitleToBe(String title, int timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.titleIs(title));
    }
}
