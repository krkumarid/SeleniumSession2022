package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkTextUtil
{
    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        By links = By.tagName("a");

        System.out.println(getElementsCount(links));
        List<String> actList = getElementsTestList(links);
        for (String s : actList) {
            System.out.println(s);
        }

        if (getElementsTestList(links).contains("Careers")) {
            System.out.println(" Career link is present");
        }
    }

    public static int getElementsCount(By locator)
    {
        return getElements(locator).size();
    }

    public static List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }

    public static List<String> getElementsTestList(By locator)
    {
        List<WebElement> eleList = getElements(locator);
        List<String> eleTextList = new ArrayList<String>();
        for (WebElement e : eleList) {
            String strText = e.getText();
            if (!strText.isEmpty()) {
                eleTextList.add(strText);
            }
        }
        return eleTextList;
    }
}
