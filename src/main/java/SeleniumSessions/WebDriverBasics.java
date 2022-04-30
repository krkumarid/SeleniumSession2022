package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics
{

    public static void main(String[] args)
    {
        
        // Open Chrome
        // Enter the URL
        // Get the title --> validation point( actual vs expected )
        // get the url 
        // Close the url
        System.setProperty("webdriver.chrome.driver", "D:\\JavaXps\\MarchSelenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Lanunch chrome.
        driver.get("https://www.google.com");// the protocol is must.
        
       //  driver.get("www.google.com");// http removed mut it will give an exception //org.openqa.selenium.InvalidArgumentException
        
        String title =  driver.getTitle();
        System.out.println ("Page title is :" +  title );
        // validation point / checkpoint :( act vs expected
        
        if( title.equals("Google"))
        {
            System.out.println("PASS -- correct title");
        }
        else
        {
            System.out.println("FAIL -- incorrect title");
        }
        
        // Automation steps + validation points =>  Automation testing
        String strCurrUrl = driver.getCurrentUrl(); // getting the current url
        System.out.println( strCurrUrl );
        if( strCurrUrl.equals("https://www.google.com/"))
        {
            System.out.println("PASS -- correct url");
        }
        else
        {
            System.out.println("FAIL -- incorrect url ");
        }
        
        // closing the browser
       
       // driver.quit();
        driver.close();
    }

}
