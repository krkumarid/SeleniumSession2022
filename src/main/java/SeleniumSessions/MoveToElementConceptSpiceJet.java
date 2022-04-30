package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConceptSpiceJet

{
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.spicejet.com/");

        WebElement parentElement = driver.findElement(By.xpath(
                "//div[contains(@class,'css-76zvg2 r-jwli3a r-ubezar r-16dba41 r-1pzd9i8') and contains(text(),'Add-ons')]"));
        WebElement ChildEle = driver.findElement(
                By.xpath("//div[contains(@class,'css-76zvg2 r-homxoj r-ubezar') and contains(text(),'SpiceFlex')]"));
        // parentElement.click();
        Thread.sleep(3000);
        Actions act = new Actions(driver);

        act.moveToElement(parentElement).build().perform();
        Thread.sleep(3000);
        ChildEle.click();
        
    }

}
