package SeleniumSessions;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocator
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.aqi.in/dashboard/Canada");

        // WebElement ele = driver.findElement(By.linkText("London, Canada"));
        // String strRight =
        // driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
        // System.out.println(strRight);
        //
        // String strLeft =
        // driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
        // System.out.println(strLeft);
        //
        // String strTop =
        // driver.findElement(with(By.tagName("p")).above(ele)).getText();
        // System.out.println(strTop);
        //
        // String strBelow =
        // driver.findElement(with(By.tagName("p")).below(ele)).getText();
        // System.out.println(strBelow);
        //
        // String strNear =
        // driver.findElement(with(By.tagName("p")).near(ele)).getText();
        // System.out.println(strNear);

        WebElement eleRel = driver.findElement(By.xpath("//a[text()='Manitoba']"));
        System.out.println(eleRel.getText());
        List<WebElement> lstRel = driver.findElements(
                with(By.xpath("//a[text()='Manitoba']/parent::th//following-sibling::td")).toRightOf(eleRel));
        for (WebElement e : lstRel)
        {
            System.out.print(e.getText() + " ");
        }
        
    }

}
