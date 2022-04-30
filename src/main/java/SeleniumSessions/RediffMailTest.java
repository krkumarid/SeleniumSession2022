package SeleniumSessions;

public class RediffMailTest
{

    public static void main(String[] args)
    {
        BrowserUtil browser = new BrowserUtil();

        browser.launchBrowser("firefox");
        browser.enterUrl("https://www.rediff.com");
        String title = browser.getPageTitle();
        System.out.println(title);
        if (title.contains("Rediff")) {
            System.out.println("Correct title");
        }
        String url = browser.getAppCurrentUrl();
        System.out.println(url);

        browser.closeBrowser();
    }

}
