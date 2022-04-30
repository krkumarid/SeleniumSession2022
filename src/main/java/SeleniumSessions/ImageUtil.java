package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageUtil
{

    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        By imageLink = By.tagName("img");
        System.out.println(getElemetsCount(imageLink));
        String strAlt = "alt";
        List<String> attAtl = getAtrributeList(imageLink, strAlt);
        printAttributeText(attAtl);

        System.out.println("-----------------------------------");
        String strSrc = "src";
        List<String> attSrc = getAtrributeList(imageLink, strSrc);
        printAttributeText(attSrc);

    }

    public static List<String> getAtrributeList(By loactor, String type)
    {
        List<WebElement> elmAttr = getElements(loactor);
        List<String> strText = new ArrayList<String>();
        for (WebElement e : elmAttr) {
            String str = e.getAttribute(type);
            if (!str.isBlank()) {
                strText.add(str);
            }
        }
        return strText;
    }

    public static int getElemetsCount(By locator)
    {
        return getElements(locator).size();
    }

    public static void printAttributeText(List<String> s)
    {
        for (String e : s) {
            System.out.println(e);
        }
    }

    public static List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }

}
