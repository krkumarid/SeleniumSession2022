package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        By firstnameLoc = By.id("input-firstname");
        WebElement elFirstame = driver.findElement(firstnameLoc);
        Actions action = new Actions(driver);

        action.sendKeys(elFirstame, "Rajeevkumar").click().build().perform();

    }

}
