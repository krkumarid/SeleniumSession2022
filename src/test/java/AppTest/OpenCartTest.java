package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest
{
    
    @Test
    public void searchTest()
    {
        // driver.get("https://demo.opencart.com/index.php?route=account/login");
        boolean flag = driver.findElement(By.xpath("//a[text()='Register']")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test
    public void urlTest()
    {
        String str = driver.getCurrentUrl();
        Assert.assertTrue(str.contains("register"));
    }
    
}
