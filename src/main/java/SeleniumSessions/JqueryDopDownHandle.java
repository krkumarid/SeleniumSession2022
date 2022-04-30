package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDopDownHandle
{
    
    static WebDriver driver;
    
    public static void main(String[] args) throws InterruptedException
    {
        
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        
        Thread.sleep(3000);
        driver.findElement(By.id("justAnInputBox")).click();
        By dropDownLocaor = By.cssSelector("span.comboTreeItemTitle");
        // tc_01 Single Selection
        String value = "choice 21";
        selectChoice(dropDownLocaor, value);
        // tc_02 Multi selection
        String[] threeChoice = new String[] { "choice 1", "choice 2", "choice 3" };
        // selectChoice(dropDownLocaor, threeChoice);
        // tc_03 All selection
        // selectChoice(dropDownLocaor, "all");
    }
    
    public static void selectChoice(By locator, String... value) // string array
    {
        List<WebElement> lstCheckBox = driver.findElements(locator);
        boolean flag = false;
        int nCount = lstCheckBox.size();
        if (!value[0].equalsIgnoreCase("all"))
        {
            for (WebElement e : lstCheckBox)
            {
                String text = e.getText();
                System.out.println(text);
                for (int i = 0; i < value.length; i++)
                {
                    if (e.getText().equals(value[i]))
                    {
                        flag = true;
                        e.click();
                        break;
                    }

                }
            }
        } else
        {
            try
            {
                for (WebElement e : lstCheckBox)
                {
                    if (e.isDisplayed())
                    {
                        e.click();
                    }
                }
            } catch (ElementNotInteractableException e)
            {
                System.out.println("All choices are over!!!");
            }
        }
        if (flag == false)
        {
            System.out.println("This choice is not available!!");
        }
    }
}
