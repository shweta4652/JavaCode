package com.training.january;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReusableFunctions {

	static WebDriver driver;
	

	/**
	 *Name of the Method : enterText  --> TextBox 
	 *Brief Description : Enter text into textbox
	 *Arguments     : WebElement String
	 *Created By    : Automation Team
	 *Created date  : 03/12/2019
	 *Last Modified : 
	 */

	public static void enterText(WebElement obj, String textVal) throws InterruptedException {
		Thread.sleep(5000);
		if (obj.isDisplayed()) {
			obj.sendKeys(textVal);

			System.out.println("Entering in to Text field");
		} else {
			System.out.println("Field does not exist please check !!!!!");
		}

	}
	
	/**
	 * Name Of The Method : clickObj --> Button
	 * Brief Description  : Clicking on the Button
	 * Arguments          : WebElement
	 * CreatedBy          : AutomationTeam
	 * Created date       :
	 * Last Modified      :
	 * @throws InterruptedException 
	 * 
	 */
	
	public static void clickObject(WebElement element) throws InterruptedException{
		if(element.isDisplayed()){
			Thread.sleep(5000);
			element.click();
			System.out.println("Element is successfully clicked");
		}else{
			System.out.println("Unable to find the element");
		}
		
	}
	
	/**
	 * Select By Value
	 * 
	 * 
	 * 
	 */
	
	public static void SelectByIndex(WebElement element, int Value) throws InterruptedException{
		if(element.isDisplayed()){
			Select City = new Select(element);
			City.selectByIndex(Value);
			
			System.out.println("Element is successfully clicked");
		}else{
			System.out.println("Unable to find the element");
		}
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static void SelectByVisibleText(WebElement element, String Value) throws InterruptedException{
		if(element.isDisplayed()){
			Select City = new Select(element);
			City.deselectByVisibleText(Value);
			
			System.out.println("Element is successfully clicked");
		}else{
			System.out.println("Unable to find the element");
		}
		
	}

}
