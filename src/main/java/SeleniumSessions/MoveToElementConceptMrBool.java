package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConceptMrBool
{
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
    {

        // move to element
        // parent to child menu
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://mrbool.com/");

        By parentLocator = By.cssSelector("a.menulink");
        // WebElement childEle =
        // driver.findElement(By.xpath("//a[contains(text(),'Courses')]"));

        // Actions act = new Actions(driver);
        // act.moveToElement(parentEle).build().perform();

        By childLocator = By.xpath("//span[@id='headermenudesktop']/ul//li/a[contains(text(),'Courses')]");

        doClickOnChildMenu(parentLocator, childLocator);
    }

    public static WebElement getElement(By locator)
    {
        return driver.findElement(locator);
    }

    public static void doMoveToElement(By locator)
    {

        Actions action = new Actions(driver);
        action.moveToElement(getElement(locator)).build().perform();

    }

    public static void doClickOnChildMenu(By parentLocator, By childMenuLocator) throws InterruptedException
    {
        doMoveToElement(parentLocator);
        Thread.sleep(5000);
        getElement(childMenuLocator).click();
    }
}
