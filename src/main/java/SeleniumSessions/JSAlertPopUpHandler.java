package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopUpHandler
{
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
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
        
        Thread.sleep(5000);
        
        Alert alert = driver.switchTo().alert();
        String strAlert = alert.getText();
        
        if (strAlert.equals("Please enter a valid user name"))
        {
            System.out.println(" Correct validation message");
        }
        // alert.accept(); // click on the ok button
        System.out.println(strAlert);
        alert.dismiss(); // press esc/ click on cancel / dismiss the alert.
        
        // alert or dismissal depends on the use case.
        // to submit or yes use accept();
        // to cancel or no use dismiss();
        
    }
    
}
