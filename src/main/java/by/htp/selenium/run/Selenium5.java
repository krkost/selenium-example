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
					// check if a Group name is not empty
					if (!gr.findElement(By.className("list-item__page-link")).getText().isEmpty()) {

						System.out.println("\nGroup:" + gr.findElement(By.className("list-item__page-link")).getText());

						// find all sub-groups
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

		driver.get("https://www.it-academy.by/");
		driver.findElement(By.xpath("/html/body/div[1]/main/section[2]/section[3]/div/ul/li[10]/a/div[2]/span"))
				.click();

		List<WebElement> courses = driver.findElements(By.className("course-item-block"));
		
		
		//getting of the preparatory courses
		System.out.println("\nList of preparatory courses with dates:");
		for (WebElement course : courses) {
			System.out.println(course.findElement(By.className("course-item-block__title")).getText());

			try {
				System.out.println("Course Date:" + course.findElement(By.className("course-item__date")).getText());
			} catch (NoSuchElementException e) {
				continue;
			}

		}

		Thread.sleep(2000);
		driver.close();
	}

}
