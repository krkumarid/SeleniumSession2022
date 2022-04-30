package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintedDressSearchPractice
{
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        //// div[@class='ac_results']//li[contains(text(),'Casual Dress> Printed')]
        
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");

        Thread.sleep(5000);
        String value = "Casual Dresses > Printed";
        // driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'"
        // + value + "')]")).click();
        selectOptionFromSuggList(value);
        // By searchLocator =
        // By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses >
        // Printed')]");
        // driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual
        // Dresses > Printed')]"))
        // .click();
        // List<WebElement> optionDress =
        // driver.findElements(By.xpath("//div[@class='ac_results']//li"));
        //
        // System.out.println(optionDress.size());
        //
        // for (WebElement e : optionDress)
        // {
        // String text = e.getText();
        // System.out.println(text);
        // if (text.contains("Casual"))
        // {
        // System.out.println(text);
        // e.click();
        // break;
        // }
        // }
        
    }

    public static List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }

    public static void selectOptionFromSuggList(String value)
    {
        System.out.println(value);
        driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'" + value + "')]")).click();
    }
    
}
