package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose
{

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "D:\\JavaXps\\MarchSelenium\\chromedriver.exe");
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

        driver.quit();

        // driver.close();// session id expired
        driver = new ChromeDriver();// new session id created
        driver.get("https://www.google.com");
        title = driver.getTitle();
        System.out.println(title);

    }

}
