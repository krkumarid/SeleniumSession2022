package AppTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest
{
    
    @Test
    public void searchTest()
    {
        // driver.get("https://www.orangehrm.com/");
        boolean flag = driver.findElement(By.xpath("//a[text()='Contact Sales']")).isDisplayed();
        Assert.assertTrue(flag);
    }
    
    @Test
    public void urlTest()
    {
        String str = driver.getCurrentUrl();
        Assert.assertTrue(str.contains("contact-sales"));
    }
}
