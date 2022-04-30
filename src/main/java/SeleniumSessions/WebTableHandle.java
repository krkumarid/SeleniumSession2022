package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		Thread.sleep(5000);

		String strPath = "//strong[text()='Canada']/parent::td/preceding-sibling::td/input"; // --Canada
		String strKabul = "//td[text()='Kabul']//preceding-sibling::td/input";
		String strNepali = "//td[text()='Nepali']//preceding-sibling::td/input";

		driver.findElement(By.xpath(strPath)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(strKabul)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(strNepali)).click();

		Thread.sleep(5000);
		doCheckBox("India");

		String strForward = "//strong[text()='Canada']/parent::td//following-sibling::td[text()='Canadian Dollar']";
		System.out.println(driver.findElement(By.xpath(strForward)).getText());
	}

	public static void doCheckBox(String value) {
		String strXpath = "//strong[text()='" + value + "']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(strXpath)).click();
	}

}
