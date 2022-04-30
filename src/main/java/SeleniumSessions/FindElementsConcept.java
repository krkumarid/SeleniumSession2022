package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept
{
    // you have to get the count of all the links/images on the page
    // how will you print the text?
    // remove blank text
    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        List<WebElement> linkList = driver.findElements(By.tagName("a"));
        System.out.println("Total links :" + linkList.size());

        for (int i = 0; i < linkList.size(); i++) {
            String text = linkList.get(i).getText();
            if (!text.isEmpty()) {
                System.out.println(text);
            }
        }

        System.out.println("-------------------------------");
        for (WebElement e : linkList) {
            String strText = e.getText();
            if (!strText.isEmpty()) {
                System.out.println(strText);
            }

        }

    }
}