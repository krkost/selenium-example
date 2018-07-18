package by.htp.selenium.run;

import java.util.Scanner;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/home/kristina/AutoCourses/chromedriver/chromedriver";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty(CHROME, CHROME_PATH);

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.quizful.net/test");
		
		driver.findElement(By.xpath("//*[@id=\"user-panel\"]/li[3]/a")).click();		
		driver.findElement(By.id("login")).sendKeys("dbdfbfdg");
		driver.findElement(By.name("registrationForm.password")).sendKeys("password");		
		driver.findElement(By.name("registrationForm.repassword")).sendKeys("password");		
		driver.findElement(By.name("registrationForm.email")).sendKeys("test"+(int)(Math.random()*100)+"qat@tst.tst");		
		driver.findElement(By.id("corporate")).click();
		
		String capchaVal = JOptionPane.showInputDialog("Input capcha value");
		driver.findElement(By.name("registrationForm.captcha")).sendKeys(capchaVal);
				
		driver.findElement(By.name("ok")).click();
		
		Thread.sleep(2000);
		driver.close();	

	}

}
