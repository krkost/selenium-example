package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");

		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("web driver 3 new features java 8 htp tat 9");
		element.submit();

		// check if tab name contains word java
		String java = "java";
		String tabName = driver.getTitle();
		System.out.println("Tab name: " + tabName);
		System.out.println(tabName.contains("java"));

		int count = 0; // search results counter
		
		//receive the search results on the first page
		List<WebElement> results = driver.findElements(By.className("r"));
		for (WebElement el : results) {
			WebElement a = el.findElement(By.xpath("a"));
			count++;
		}

		// receive the number of search results on pages except first - loop till exception
		while (true) {
			try {
				Thread.sleep(1500);
				WebElement pageNum = driver.findElement(By.id("pnnext"));
				pageNum.click();
				List<WebElement> results1 = driver.findElements(By.className("r"));

				for (WebElement el : results1) {
					el.findElement(By.xpath("a"));
					count++;
				}
			} catch (NoSuchElementException e) {
				break;
			}
			continue;
		}

		System.out.println("Number of results:" + count);

		Thread.sleep(2000);
		driver.close();

	}

}
