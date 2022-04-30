package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount
{
    // You have to get the count of all the images on the page
    // then print the src/alt attributes of each link on the console.
    public static WebDriver driver;

    public static void main(String[] args)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        By loactor = By.tagName("img");

        List<WebElement> listImages = getElements(loactor);
        System.out.println(listImages.size());

        for (WebElement e : listImages) {
            String altValue = e.getAttribute("alt");
            String srcValue = e.getAttribute("src");

            System.out.println(altValue + "--->" + srcValue);

        }

    }

    public static List<WebElement> getElements(By loactor)
    {
        return driver.findElements(loactor);
    }

}
