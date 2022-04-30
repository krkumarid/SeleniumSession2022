
package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest
{

    @Test(priority = 1)
    public void searchTest()
    {
        // driver.get("https://www.google.com/");
        boolean flag = driver.findElement(By.name("q")).isDisplayed();
        Assert.assertTrue(flag);
    }

    @Test(priority = 2)
    public void searchButtonTest()
    {
        boolean flag = driver.findElement(By.xpath("//input[@name='btnK']")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test(priority = 3)
    public void urlTest()
    {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google"));
    }
}
