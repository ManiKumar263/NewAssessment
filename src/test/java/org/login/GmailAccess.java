package org.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailAccess {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://mail.google.com/");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("manikumar122022");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']/following-sibling::span[contains(text(), 'Next')]")).click();
		WebDriverWait w = new WebDriverWait(driver, 30);
		WebElement until = w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
		until.sendKeys("10Aero50!");
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']/following-sibling::span[contains(text(), 'Next')]")).click();
		WebElement logo = driver.findElement(By.xpath("//div[@class='gb_Ef gb_2a gb_qg gb_l']//a[@role='button']"));
		String attribute = logo.getAttribute("aria-label");
		boolean contains = attribute.contains("manikumar122022");
		logo.click();
		
		driver.navigate().to("https://www.ebay.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Electric Guitar");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("(//div[@class='s-item__info clearfix']//div[@class='s-item__title'])[2]")).click();
		String text = driver.findElement(By.xpath("//div[@class='vim x-item-title']//span")).getText();
		System.out.println(text);
	}
}
