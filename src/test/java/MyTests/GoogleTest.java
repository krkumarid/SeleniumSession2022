
package MyTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest
{
    WebDriver driver;

    @BeforeMethod
    public void setup()// standard name is setup
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void searchTest()
    {
        boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @Test
    public void searchButtonTest()
    {
        boolean flag = driver.findElement(By.xpath("//input[@name='btnK']")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
