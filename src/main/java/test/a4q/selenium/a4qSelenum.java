package test.a4q.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class a4qSelenum
{
    
    public static void main(String[] args) throws InterruptedException
    {

        WebDriverManager.chromedriver().setup();
        WebDriver chdriver = new ChromeDriver();

        WebDriverManager.firefoxdriver().setup();
        WebDriver fxdriver = new FirefoxDriver();

        // driver.get("https://python.org");
        // System.out.println(driver.getTitle());
        // Thread.sleep(3000);
        // driver.get("https://perl.com");
        // System.out.println(driver.getTitle());
        // driver.navigate().forward();
        // Thread.sleep(3000);
        // System.out.println("Forward" + driver.getTitle());
        // driver.navigate().forward();
        // Thread.sleep(3000);
        // System.out.println("Forward" + driver.getTitle());
        // driver.navigate().back();
        // Thread.sleep(3000);
        // System.out.println("Backward" + driver.getTitle());
        //
        // driver.get("https://yahoo.com");
        // System.out.println(driver.getTitle());
        // Thread.sleep(3000);
        // driver.get("https://google.com");
        // System.out.println(driver.getTitle());
        // driver.navigate().back();
        // Thread.sleep(3000);
        // System.out.println("BAck" + driver.getTitle());
        // driver.navigate().forward();
        // Thread.sleep(3000);
        // System.out.println("Forward" + driver.getTitle());

        chdriver.get("https://python.org");

        fxdriver.get(chdriver.getTitle());
        fxdriver.get("https://perl.com");
        
    }
    
}
