package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMangereTest
{

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup(); // WebDrivermethod is taking care of ChromeDriver.exe
        WebDriver driver = new ChromeDriver(); // Lanunch chrome.//ddba744446d770252739cf6b075fbced(session id)
        driver.get("https://www.google.com");// the protocol is must.
        String title = driver.getTitle();
        System.out.println("Page title is :" + title);

        if (title.equals("Google")) {
            System.out.println("PASS -- correct title");
        } else {
            System.out.println("FAIL -- incorrect title");
        }

        String strCurrUrl = driver.getCurrentUrl(); // getting the current url
        System.out.println(strCurrUrl);
        if (strCurrUrl.equals("https://www.google.com/")) {
            System.out.println("PASS -- correct url");
        } else {
            System.out.println("FAIL -- incorrect url ");
        }

        // closing the browser

        // driver.quit();

        driver.close();// session id expired

    }

}
