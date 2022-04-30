package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser
{

    public static void main(String[] args)
    {
        /**
         * head less no browser launch( not visible ) / hidden browser testing is
         * happening behind the scene faster
         */

        WebDriverManager.chromedriver().setup(); // WebDrivermethod is taking care of ChromeDriver.exe

        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        // Browser window in incognito mode ( Private window )
        co.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(co);

        // for fire fox browser

//        WebDriverManager.firefoxdriver().setup();
//        FirefoxOptions fo = new FirefoxOptions();
//        fo.addArguments("--headless");
//        WebDriver driver = new FirefoxDriver(fo);

        driver.get("https://www.amazon.com");// t
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.quit();
    }

}
