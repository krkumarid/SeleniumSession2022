package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IFrameSwitch
{

    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
        // https://allwebco-templates.com/support/S_script_IFrame.htm
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"left-content\"]/div/iframe[2]")));
        
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[2]/div[1]/a/img")).click();
        
        // switching back to the main content page.
        driver.switchTo().defaultContent();
        
        driver.findElement(By.linkText("target links support")).click();

    }

}
