package MyTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnMethodConcept
{
    // @Test
    // public void loginTest()
    // {
    // System.out.println("login....");
    // int i = 9 / 0;
    // }
    //
    // @Test(dependsOnMethods = "loginTest", priority = 1)
    // public void homePageTest()
    // {
    // System.out.println("home page test..");
    // }
    //
    // @Test(dependsOnMethods = "loginTest", priority = 2)
    // public void searchTest()
    // {
    // System.out.println("search test......");
    // }
    
    // The LoginTest will fail, and other two tests are skipped becauese its depends
    // upon login test.
    // The same will happen for the below test too
    // @BeforeTest
    // public void launchBrowswer()
    // {
    // System.out.println("browser launch.....");
    // }
    @BeforeMethod
    public void launchBrowswer()
    {
        System.out.println("browser launch.....");
        int i = 9 / 0;
    }

    @Test
    public void createUser()
    {
        System.out.println("Create user.....");
        // int i = 9 / 0;
    }
    
    @Test(priority = 2)
    public void loginTest()
    {
        System.out.println("login....");
        // int i = 9 / 0;
    }

    @Test(dependsOnMethods = { "loginTest", "createUser" }, priority = 1)
    public void homePageTest()
    {
        System.out.println("home page test..");
    }

    @Test(dependsOnMethods = "loginTest", priority = 3)
    public void searchTest()
    {
        System.out.println("search  test......");
    }
}
