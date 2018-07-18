package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleSeleniumExamples {
	
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(CHROME, CHROME_PATH);
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("what is web driver");
		element.submit();
		
		List <WebElement> results = driver.findElements(By.className("r"));
		
		for(WebElement el: results) {
			//String tagName = el.getTagName();
			//System.out.println(tagName);
			
			//String aTag = el.findElement(By.xpath("a")).getTagName();
			//System.out.println(aTag);
			
			////*[@id="maincontent"]/div[3]/table/tbody/tr/th
			WebElement a = el.findElement(By.xpath("a"));
			String linkname = a.getText();
			System.out.println(linkname);
		}
		
		element = driver.findElement(By.name("q"));
		element.clear();
		element.sendKeys("Java");
		element.submit();
		
		Thread.sleep(5000);
		
		driver.close();		

	}

}
