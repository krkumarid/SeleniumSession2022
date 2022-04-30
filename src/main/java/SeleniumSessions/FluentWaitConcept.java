package SeleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //// WebDriverWait(c) --> FluentWait(C) -->Wait(I) ( until());
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        By email = By.id("input-email");
        // Wait<WebDriver> wait = new
        // FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
        // .pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchElementException.class)
        // .withMessage("Element is not found......");
        // wait.until(ExpectedConditions.presenceOfElementLocated(email)).sendKeys("krkumarid@gmail.com");
        waitForElementPresentUsingFluentWait(email, 10, 2000).sendKeys("krkumarid@gmail.com");
    }

    public static WebElement waitForElementPresentUsingFluentWait(By locator, int timeOut, int pollingTime)
    {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class)
                .withMessage("Element is not found......");
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
