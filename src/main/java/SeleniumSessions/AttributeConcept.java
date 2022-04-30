package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttributeConcept
{
    public static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        By hrefLoc = By.linkText("Amazon Devices");
        String attName = "href";
        String hrefVal = getAttribute(hrefLoc, attName);

        if (hrefVal.contains("footer_devices"))
        {
            System.out.println(" Correct href value");
        }

    }
    
    public static WebElement getElement(By loactor)
    {
        return driver.findElement(loactor);
    }
    
    public static String getAttribute(By loactor, String attName)
    {
        String att = getElement(loactor).getAttribute(attName);
        System.out.println(att);
        return att;
    }
}
