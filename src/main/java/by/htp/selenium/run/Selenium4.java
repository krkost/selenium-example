package by.htp.selenium.run;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium4 {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.quizful.net/test");

		driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[1]/a")).click();
		driver.findElement(By.id("login")).sendKeys("qatestqa");
		driver.findElement(By.name("loginForm.password")).sendKeys("password");
		driver.findElement(By.name("ok")).click();

		driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[1]/b/a")).click();
		driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"profile-personal-form\"]/div[2]")).click();

		driver.findElement(By.name("personalForm.name")).sendKeys("Test");
		driver.findElement(By.name("personalForm.surname")).sendKeys("Selenium");
		driver.findElement(By.name("personalForm.birthyear")).sendKeys("1993");
		driver.findElement(By.name("personalForm.site")).sendKeys("www.test-selenium.com");
		driver.findElement(By.name("personalForm.company")).sendKeys("Test Company");
		driver.findElement(By.name("personalForm.countryId")).sendKeys("Беларусь");

		Select dropdown = new Select(driver.findElement(By.name("personalForm.zone")));
		dropdown.selectByIndex(4);
		driver.findElement(By.name("personalForm.about")).sendKeys("This is a very interesting text about me");
		driver.findElement(By.name("personalForm.save")).click();
		
		driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a")).click();

		driver.findElement(By.xpath("//*[@id=\"profile-notifications-form\"]/div[1]/b")).click();
		driver.findElement(By.name("notificationsForm.notificationsEnabled")).click();
		driver.findElement(By.name("notificationsForm.deliveryEnabled")).click();
		driver.findElement(By.name("notificationsForm.save")).click();
		
		driver.findElement(By.xpath("//*[@id=\"middle\"]/div[2]/div[1]/div[2]/div/a")).click();

		driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[1]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"profile-privacy-form\"]/div[2]/form/table/tbody/tr[4]/td[1]/label"))
				.click();
		driver.findElement(By.name("privacyForm.save")).click();

		Thread.sleep(2000);
		driver.close();

	}

}
