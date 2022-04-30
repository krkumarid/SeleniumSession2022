package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept
{
    static WebDriver driver;

    public static void main(String[] args)
    {

        // Element to element rap and drop
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
        
        WebElement sourceEle = driver.findElement(By.id("draggable"));
        WebElement targetEle = driver.findElement(By.id("droppable"));
        
        Actions action = new Actions(driver);

        // action.clickAndHold(sourceEle).moveToElement(targetEle).release().build().perform();
        action.dragAndDrop(sourceEle, targetEle).build().perform();
    }
    
}
