package MyTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * BS--- DBConnection(1) BT ---Create User(2) BC--launch browser(3) BM-- login
 * to App(4) Account Info Test AM-- Logout BM-- login to App user info test AM--
 * Logout AC-- Close browser AT-- delete user PASSED: accountInfoTest PASSED:
 * userInfoTest AC-- Close browser AT-- delete user PASSED: accountInfoTest
 * PASSED: userInfoTest =============================================== Default
 * test Tests run: 2, Failures: 0, Skips: 0
 * =============================================== AS-- disconnect DB
 */
public class AnnotationConcept
{
    @BeforeSuite
    public void dbConnection()
    {
        System.out.println("BS--- DBConnection");
    }

    @BeforeTest
    public void CreateUser()
    {
        System.out.println("BT ---Create User");
    }

    @BeforeClass
    public void launchBrowser()
    {
        System.out.println("BC--launch browser");
    }

    @BeforeMethod
    public void loginToApp()
    {
        System.out.println(" BM-- login to App");
    }

    @Test
    public void userInfoTest()
    {
        System.out.println(" user info test");
    }

    @Test
    public void accountInfoTest()
    {
        System.out.println(" Account Info Test");
    }

    @AfterMethod
    public void logout()
    {
        System.out.println(" AM-- Logout");
    }

    @AfterClass
    public void closeBrowser()
    {
        System.out.println("AC-- Close browser");
    }

    @AfterTest
    public void deleteUser()
    {
        System.out.println("AT-- delete user");
    }

    @AfterSuite
    public void disconnectDB()
    {
        System.out.println("AS-- disconnect DB");
    }
}
