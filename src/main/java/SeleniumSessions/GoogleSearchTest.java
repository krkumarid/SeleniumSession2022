package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest
{
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Naveen AutomationLabs");

        Thread.sleep(5000);
        
        List<WebElement> searchOption = driver
                .findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']//span"));

        System.out.println(searchOption.size());

        for (WebElement e : searchOption)
        {
            String text = e.getText();
            // System.out.println( text );
            if (text.contains("youtube"))
            {
                System.out.println(e.getText());
            }
        }

    }

}
