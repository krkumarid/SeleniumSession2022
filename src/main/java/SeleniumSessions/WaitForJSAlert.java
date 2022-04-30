package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForJSAlert
{
    
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        // it could be alert
        // confirmation pop up
        // warning pop up.
        // submit pop up
        // modal pop up
        // JS pop up
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        
        driver.findElement(By.name("proceed")).click();
        
        // Alert alert = driver.switchTo().alert();//NoAlertPresentException: no such
        // alert
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        // System.out.println(alert.getText());
        // Alert alert = waitForAlert(5);
        // alert.accept();

        System.out.println(getAlertText(5));
    }
    
    public static Alert waitForAlert(long timeOut)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public static String getAlertText(long timeOut)
    {
        return waitForAlert(timeOut).getText();
    }
    
    public static void doAlertAccept(long timeOut)
    {
        waitForAlert(timeOut).accept();
    }
    
    public static void getAlertDismiss(long timeOut)
    {
        waitForAlert(timeOut).dismiss();
    }
    
    public static void enterAlertText(String text, long timeOut)
    {
        waitForAlert(timeOut).sendKeys(text);
    }
}
