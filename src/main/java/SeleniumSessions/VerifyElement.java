package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement
{
    static WebDriver driver;
    
    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

        By fromFields = By.className("text");

        int fieldCount = driver.findElements(fromFields).size();
        if (fieldCount == 0)
        {
            System.out.println(" Thre form fields are not available");
        } else
        {
            System.out.println(" Thre form fields  are  available");
        }

        // to verify the single element
        // The FREE TRAIL is written in capital letter ,but the link text is in Free
        // Trial.
        // It will work on Visible on the page.It will not work with the text inside the
        // DOM
        By freeTrial = By.linkText("FREE TRIAL11");
        // driver.findElement(freeTrial).click();
        boolean flag = driver.findElement(freeTrial).isDisplayed();
        System.out.println(flag);

        if (driver.findElements(freeTrial).size() >= 1)
        {
            System.out.println("Free trail link is present on the page!");
        }
        
        System.out.println(isElementExist(freeTrial));
    }

    public static boolean isElementExist(By locator)
    {
        int count = driver.findElements(locator).size();
        System.out.println(" The number of elements found :" + count);
        if (count >= 1)
        {
            System.out.println("The element is found.." + locator);
            return true;
        } else
        {
            System.out.println("The element is not found.." + locator);
            return false;
        }
    }

}
