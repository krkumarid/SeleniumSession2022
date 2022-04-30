package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest
{

    public static void main(String[] args) throws InterruptedException
    {

        BrowserUtil browserUtil = new BrowserUtil();
        WebDriver driver = browserUtil.launchBrowser("chrome");
        browserUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register");
        String title = browserUtil.getPageTitle();
        System.out.println(title);

        By fName = By.id("input-firstname");
        By lName = By.id("input-lastname");
        By email = By.id("input-email");
        By telephone = By.id("input-telephone");
        By password = By.id("input-password");
        By conPassword = By.id("input-confirm");

        ElementUtil elmUtil = new ElementUtil(driver);
        elmUtil.doSendKeys(fName, "Karthikeyan");
        elmUtil.doSendKeys(lName, "Rajeevkumar");
        elmUtil.doSendKeys(email, "krkumarid@gmail.com");
        elmUtil.doSendKeys(telephone, "7034345082");
        elmUtil.doSendKeys(password, "venkida");
        elmUtil.doSendKeys(conPassword, "venkida");

        Thread.sleep(5000);

        browserUtil.closeBrowser();

    }

}
