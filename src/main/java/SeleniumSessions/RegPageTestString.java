package SeleniumSessions;

import org.openqa.selenium.WebDriver;

public class RegPageTestString
{

    public static void main(String[] args) throws InterruptedException
    {
        BrowserUtil broUtil = new BrowserUtil();
        WebDriver driver = broUtil.launchBrowser("chrome");
        broUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register");
        String title = broUtil.getPageTitle();
        System.out.println(title);

        String fName = "input-firstname";
        String lName = "input-lastname";
        String email = "input-email";
        String phone = "input-telephone";
        String password = "input-password";
        String conPassword = "input-confirm";
        ElementUtil elmUtil = new ElementUtil(driver);

        elmUtil.doSendKeys("id", fName, "Kasinathan");
        elmUtil.doSendKeys("id", lName, "Rajeevkumar");
        elmUtil.doSendKeys("id", email, "Kasinathan@gamil.com");
        elmUtil.doSendKeys("id", phone, "9447331186");
        elmUtil.doSendKeys("id", password, "venkida");
        elmUtil.doSendKeys("id", conPassword, "venkida");

        Thread.sleep(5000);

        broUtil.closeBrowser();
    }

}
