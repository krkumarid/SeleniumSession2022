package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept
{

    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.opencart.com/index.php?route=account/login");

        // JavascriptExecutor js = (JavascriptExecutor) driver;

        // js.executeScript("alert('hi')");
        JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
        String title = jsUtil.getTitleByJS();
        // System.out.println(title);

        // jsUtil.generateAlert("Hello JS");
        // String innerText = jsUtil.getPageInnerText();
        // System.out.println(innerText);
        // System.out.println(innerText.contains("Career"));
        // jsUtil.refreshBrowserByJS();
        // WebElement element = driver.findElement(By.xpath("//label[text()=\"Full
        // Name\"]"));
        // jsUtil.drawBorder(element);
        // WebElement eleFlash =
        // driver.findElement(By.xpath("//h3[@class=\"text-center\"]"));
        // jsUtil.flash(eleFlash);
        // WebElement eleContactSales = driver.findElement(By.linkText("Register"));
        // jsUtil.clickElementByJS(eleContactSales);
        // jsUtil.scrollPageDown();
        // Thread.sleep(3000);
        // jsUtil.scrollPageUP();
        // Thread.sleep(3000);
        // jsUtil.scrollPageDown("225");

        WebElement eleProduct = driver.findElement(By.xpath("//aside/div/a[text()=\"Address Book\"]"));
        jsUtil.scrollIntoView(eleProduct);
        // System.out.println(eleProduct.getText());

        jsUtil.sendKeysUsingWithID("input-email", "krkumarid@gmail.com");
        
        WebElement eleEmailId = driver.findElement(By.id("input-email"));
        String val = eleEmailId.getAttribute("value");
        System.out.println(val);
    }

}
