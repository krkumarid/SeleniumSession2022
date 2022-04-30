package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept
{
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        WebElement element = driver.findElement(By.xpath("//span[text()='right click me']"));
        
        Actions act = new Actions(driver);

        act.contextClick(element).build().perform();// -- will work tru

        Thread.sleep(5000);

        // act.contextClick(element).perform(); // -- single perform also will
        // work--true

        // act.contextClick(element);// this will not perform any action
        List<WebElement> contextText = driver.findElements(By.xpath(
                "//ul[@class='context-menu-list context-menu-root']//li[contains(@class,'context-menu-icon')]/span"));

        for (WebElement e : contextText)
        {
            String text = e.getText();
            System.out.println(text);
            if (text.equals("Copy"))
            {
                e.click();
                driver.switchTo().alert().accept();
                Thread.sleep(5000);
                break;
            } else if (text.equals("Cut"))
            {
                e.click();
                driver.switchTo().alert().accept();
                Thread.sleep(5000);
                break;

            }
        }
        
    }

}
