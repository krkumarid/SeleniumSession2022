package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserTest
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        String browser = "safari";
        
        if( browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","D:\\JavaXps\\MarchSelenium\\chromedriver.exe");
            driver = new ChromeDriver();
            
           
        }
        else if(browser.equalsIgnoreCase("firefox") )
        {
            System.setProperty("webdriver.gecko.driver","D:\\JavaXps\\MarchSelenium\\geckodriver.exe");
            driver = new FirefoxDriver();
            
        }
        else
        {
            System.out.println(" Please pass the right browser..." + browser);
        }
        
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        if( title.equals("Google"))
        {
            System.out.println("PASS -->" + title );
        }
        else
        {
            System.out.println("FAIL-->" + title );
        }
        
        String strCurUrl = driver.getCurrentUrl();
        
        if( strCurUrl.equals("https://www.google.com/"))
        {
            
            System.out.println("PASS -->" + strCurUrl );
        }
        else
        {
            System.out.println("FAIL-->" + strCurUrl );
        }
        
        driver.quit();
    }

}
