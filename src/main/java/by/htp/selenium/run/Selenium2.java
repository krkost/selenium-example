package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium2 {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tut.by/");
		
		WebElement element = driver.findElement(By.className("b-general"));		
		element.click();
		
		//find by id then by tag <p>
		List<WebElement> results = driver.findElements(By.xpath("//*[@id=\"article_body\"]/p"));
		
		System.out.println(results.size());
		
		Thread.sleep(2000);
		driver.close();

	}

}
