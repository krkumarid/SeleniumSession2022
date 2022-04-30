package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrameConcept
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("http://londonfreelance.org/courses/frames/index.html");
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("main"));
        waitForFrameByName("main", 5);
        String header = driver.findElement(By.xpath("/html/body/h2")).getText();
        System.out.println(header);
        driver.switchTo().defaultContent();
    }
    
    public static void waitForFrameByName(String nameOrID, long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrID));
    }
    
    public static void waitForFrameByIndex(int frameIndex, long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }
    
    public static void waitForFrameByLocator(By frameLocator, long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }
    
    public static void waitForFrameByElement(WebElement frameElement, long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }
}
