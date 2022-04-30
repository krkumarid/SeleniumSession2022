package SeleniumSessions;

// manually import
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Relative
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://whenwise.com/sign-in");
        driver.findElement(By.id("email")).sendKeys("naveenanimation20@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test@12345");
        driver.findElement(By.id("login-btn")).click();

        driver.navigate().to("https://whenwise.com/users/2835/edit");
        
        WebElement ele = driver.findElement(By.xpath("//span[text()='Email on booking confirmation?']"));
        driver.findElement(with(By.className("//span[@class='lever']")).toRightOf(ele)).click();
        // doRelativeLocator("Accept SMS appointment reminder?");
    }

    public static void doRelativeLocator(String text)
    {
        WebElement ele = driver.findElement(By.xpath("//span[text()='" + text + "']"));
        driver.findElement(with(By.className("//span[@class='lever']")).toLeftOf(ele)).click();
    }
}
