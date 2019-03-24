package com.training.january;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Intercations extends ReusableFunctions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		Thread.sleep(4000);
		driver.get("https://selenium-prd.firebaseapp.com/");
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		System.out.println("Test code needs to be commited");

		enterText(emailUserName, "admin123@gmail.com");
		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password, "admin123");

		WebElement LoginButton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		clickObject(LoginButton);

		/*
		 * Select City = new Select(driver.findElement(By.name("city")));
		 * City.selectByVisibleText("MUMBAI");
		 */
		// Select value from Dropdown
		WebElement Course = driver.findElement(By.name("course"));
		SelectByIndex(Course, 1);

	}

}
