package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFireFox
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.gecko.driver", "D:\\JavaXps\\MarchSelenium\\geckodriver.exe");
        
        WebDriver driver = new FirefoxDriver();
        driver.get("https://facebook.com");
        
        String strTitle = driver.getTitle();
        System.out.println(strTitle);
        if( strTitle.equals("Facebook - Log In or Sign Up"))
        {
            System.out.println("PASS -->" + strTitle);
        }
        else
        {
            System.out.println("FAIL-->" + strTitle);
        }
        
        driver.quit();
    }

}
