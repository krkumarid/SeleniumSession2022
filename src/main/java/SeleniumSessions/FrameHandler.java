package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandler
{

    public static void main(String[] args)
    {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://londonfreelance.org/courses/frames/index.html");
        
        // driver.switchTo().frame(2); // switching to frame no 3
        // driver.switchTo().frame("main");
        driver.switchTo().frame(driver.findElement(By.name("main")));
        String header = driver.findElement(By.xpath("/html/body/h2")).getText();// no sucj element
        System.out.println(header);
        
    }

}
