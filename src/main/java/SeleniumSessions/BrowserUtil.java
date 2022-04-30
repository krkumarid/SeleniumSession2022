package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil
{
    public WebDriver driver;

    /**
     * This method is used to launch the browser on the basis of given name.
     *
     * @param browser
     * @return this will return the driver
     */
    public WebDriver launchBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("chrome")) {
            // System.setProperty("webdriver.chrome.driver","D:\\JavaXps\\MarchSelenium\\chromedriver.exe");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            // System.setProperty("webdriver.gecko.driver","D:\\JavaXps\\MarchSelenium\\geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else {
            System.out.println(" Please pass the right browser..." + browser);
        }

        return driver;
    }

    /**
     * This method is used to enter the url
     *
     * @param url
     */
    public void enterUrl(String url)
    {
        if (url == null) {
            System.out.println("url is null");
            return;
        }
        if (url.indexOf("http") == -1) {
            System.out.println("http is missing the url");
            return; // blank return
        }
        driver.get(url);
    }

    /**
     * This mehtod will retun the current page url
     *
     * @return current url
     */
    public String getAppCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    /**
     * This method will return the current page titel
     *
     * @return
     */
    public String getPageTitle()
    {
        return driver.getTitle();
    }

    /**
     * This method will close the browser
     */
    public void closeBrowser()
    {
        driver.close();
    }

    /**
     * This method will quit the browser.
     */
    public void quitBrowser()
    {
        driver.quit();
    }
}
