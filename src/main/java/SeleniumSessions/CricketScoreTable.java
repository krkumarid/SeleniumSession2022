package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/west-indies-in-india-2021-22-1278661/india-vs-west-indies-3rd-t20i-1278681/full-scorecard");

		String strBatsMan = driver.findElement(By.xpath("//a[text()='Ruturaj Gaikwad']")).getText();
		// driver.findElement(By.xpath("//a[contains(@href,'ruturaj')]")).getText(); --
		// this will aslo give Ruturaj
		// a[text()='Ruturaj']
		System.out.println(strBatsMan);
		String strBowler = driver
				.findElement(By.xpath("//a[text()='Ruturaj Gaikwad']//parent::td//following-sibling::td/span"))
				.getText();
		System.out.println(strBowler);
		int count = driver.findElements(By.xpath("//a[text()='Ruturaj Gaikwad']//parent::td//following-sibling::td"))
				.size();
		System.out.println(count);

		List<WebElement> scoreCard = driver
				.findElements(By.xpath("//a[text()='Ruturaj Gaikwad']//parent::td//following-sibling::td"));
		for (WebElement e : scoreCard) {
			System.out.println(e.getText());
		}
		List<String> scoreList = new ArrayList<String>();
		for (int i = 1; i < count; i++) {
			scoreList.add(scoreCard.get(i).getText());
		}

		System.out.println(scoreList);

	}

}
