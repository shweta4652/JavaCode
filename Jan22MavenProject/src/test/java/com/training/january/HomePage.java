package com.training.january;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	static ExtentReports report;
	static ExtentTest logger;
	public static void main(String[] args) throws InterruptedException {
		String path = "C:\\ExtentReport\\ReportResult11.html";
	//	String path = "/test-output/STMExtentReport.html";
		report = new ExtentReports(path);
		logger = report.startTest("Launch Application");
		System.setProperty("webdriver.chrome.driver", "ChromeDriver/chromedriver.exe");
		WebDriver driver;
		System.out.println("Selenium Code");
		
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 40);
		driver.get("https://selenium-prd.firebaseapp.com/");
		System.out.println("Application launched successfully");
		Thread.sleep(5000);
		// wait.wait(20);
		
		//logger = report.startTest("Launch Application");
		WebElement emailUserName = driver.findElement(By.id("email_field"));
		emailUserName.clear();
		emailUserName.sendKeys("admin123@gmail.com");
		//System.out.println("username entered sucessfully");
		logger.log(LogStatus.PASS,"username entered sucessfully" );
		// Enter Password
		WebElement password = driver.findElement(By.id("password_field"));
		password.clear();
		password.sendKeys("admin123");
		//System.out.println("password entered sucessfully");
		logger.log(LogStatus.PASS,"password entered sucessfully");
		WebElement LoginButton = driver.findElement(By.xpath("//button[@onclick='login()']"));
		LoginButton.click();
		// Click on the home button
		//System.out.println("Login button clicked sucessfully");
		logger.log(LogStatus.PASS,"Login button clicked sucessfully");
		Thread.sleep(5000);
		WebElement HomeTab = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		HomeTab.click();
		//System.out.println("HomeTab button clicked sucessfully");
		logger.log(LogStatus.PASS,"HomeTab button clicked sucessfully");
		WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
		Name.clear();
		Name.sendKeys("Shweta");
		System.out.println("Name clicked sucessfully");
		WebElement FatherName = driver.findElement(By.xpath("//input[@id='lname']"));
		FatherName.clear();
		FatherName.sendKeys("Ram");
		System.out.println("Father Name clicked sucessfully");
		WebElement PostalCode = driver.findElement(By.id("postaladdress"));
		PostalCode.clear();
		PostalCode.sendKeys("110037");
		System.out.println("PostalCode entered sucessfully");
		WebElement personaladdress = driver.findElement(By.id("personaladdress"));
		personaladdress.clear();
		personaladdress.sendKeys("Delhi");
		System.out.println("personaladdress entered sucessfully");
		// Radio Button code
		WebElement genderFemale = driver.findElement(By.id("radiobut"));
		genderFemale.click();
		System.out.println("Gender Female has been selected sucessfully");
		// But it didn't click Female Radio Button

		// Select the city from the drop down

		WebElement City = driver.findElement(By.name("city"));
		Select select = new Select(City);
		select.selectByVisibleText("MUMBAI");
		// select.selectByIndex(2);
		System.out.println("Mumbai has been selected from dropdown");

		WebElement Course = driver.findElement(By.name("course"));
		Select selectCourse = new Select(Course);
		// select.selectByVisibleText("MUMBAI");
		selectCourse.selectByIndex(2);
		System.out.println("MBA has been selected from dropdown");

		WebElement District = driver.findElement(By.name("district"));
		Select selectDistrict = new Select(District);
		// select.selectByVisibleText("MUMBAI");
		// selectCourse.selectByIndex(2);
		selectDistrict.selectByValue("patna");
		System.out.println("Bihar has been selected from dropdown");

		WebElement PinCode = driver.findElement(By.id("pincode"));
		PinCode.sendKeys("110097");
		System.out.println("Pin code has been selected");

		WebElement EmailId = driver.findElement(By.id("emailid"));
		EmailId.clear();
		EmailId.sendKeys("yadavshweta965@gmail.com");
		System.out.println("EmailId has been Entered");

		WebElement SubmitButton = driver.findElement(By.xpath("//button[@class='bootbutton']"));
		SubmitButton.click();
		System.out.println("Submit button has been clicked");

		// ----Home screen complete-------------------
		// Switch to Tab Action

		WebElement SwitchToButton = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		SwitchToButton.click();
		System.out.println("SwitchToButton  has been clicked");
		WebElement AlertButton = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		AlertButton.click();
		System.out.println("AlertButton  has been clicked");
		WebElement WindowsAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
		WindowsAlertButton.click();
		System.out.println("WindowAlertButton  has been clicked");
		
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		System.out.println("Alert Text   " + AlertText);
		Assert.assertEquals("Hello! I am an alert box!", AlertText);
		System.out.println("Content has been verified");
		
		Thread.sleep(4000);
		alert.accept();
		System.out.println("Alert has been accepted");
		WebElement promptAlertButton = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
		promptAlertButton.click();
		System.out.println("promptAlertButton  has been clicked");
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Shweta");
		Thread.sleep(6000);
		// then the prompt text will be "Hello shweta"
		promptAlert.dismiss();
		System.out.println("PromtAlert has been cancelled");
		WebElement AlertTextDismiss = driver.findElement(By.xpath("//p[@id='Selenium']"));
		String DismissAlertText = AlertTextDismiss.getText();
		Assert.assertEquals(DismissAlertText, "User cancelled the prompt.");
		System.out.println("Alert dismiss content has been verified");
		
		
		report.endTest(logger);
		report.flush();
		
		

	}
}
