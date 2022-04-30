package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; // interview

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllDropDownValuesWithSelectTag
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
        
        WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
        
        Select select = new Select(country);// Select class constructor pass WebElement
        
        List<WebElement> countryList = select.getOptions();
        // int count = option.size();
        // System.out.println("Exact count" + (count - 1));
        if (countryList.size() - 1 == 231)
        {
            
            System.out.println("Country count is correct");
        }
        
        int count = 0;
        for (WebElement e : countryList)
        {
            if (count == 0)
            {
                // System.out.println("inside foreach count");
                count++;
                continue;
                
            } else
            {
                System.out.println(count + "::" + e.getText());

            }
            count++;
            
        }

        // for (int i = 0; i < countryList.size(); i++)
        // {
        // String text = countryList.get(i).getText();
        // System.out.println( i + ": :" + text );
        // }
    }
}
