package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// table[@id="customers"]/tbody/tr[2]/td[1]
		String beforeXpath = "//table[@id=\"customers\"]/tbody/tr[";
		String afterXpath = "]/td[";
		// String strLast = "]";
		By rowLocator = By.xpath("//table[@id='customers']/tbody/tr");
		By colLocatro = By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td");
		// int nRow =
		// driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
		// int nCol =
		// driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();
		PrintYTable(rowLocator, colLocatro, beforeXpath, afterXpath);

	}

	public static void PrintYTable(By rowLocator, By colLocator, String beforePath, String afterPath) {
		int nRow = driver.findElements(rowLocator).size();
		int nCol = driver.findElements(colLocator).size();

		for (int i = 2; i <= nRow; i++) {
			for (int j = 1; j <= nCol; j++) {
				// String xPath = beforeXpath + i + afterXpath + j + strLast;
				// System.out.println(xPath);
				String xPath = beforePath + i + afterPath + j + "]";
				// System.out.println(driver.findElement(By.xpath(xPath)).getText());
				System.out.print(driver.findElement(By.xpath(xPath)).getText() + "||");
			}
			System.out.println();

		}
	}

}
