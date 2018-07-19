package by.htp.selenium.run;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Selenium5 {
	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.it-academy.by/");

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.className("nav-menu-item__title"));
		action.moveToElement(we).build().perform();

		List<WebElement> groups = driver.findElements(By.className("panel-section-list__item"));

		while (true) {
			try {
				for (WebElement gr : groups) {

					if (!gr.findElement(By.className("list-item__page-link")).getText().isEmpty()) {

						System.out.println("Group:" + gr.findElement(By.className("list-item__page-link")).getText());

						List<WebElement> subs = gr.findElements(By.className("panel-section-sublist__item"));

						for (WebElement sub : subs) {
							System.out.println(sub.findElement(By.className("list-subitem__page-link")).getText());
						}
					}
				}
			} catch (NoSuchElementException e) {
				break;
			}
			continue;
		}

		Thread.sleep(2000);
		driver.close();
	}

}
