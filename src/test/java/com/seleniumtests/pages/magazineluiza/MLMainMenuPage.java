package com.seleniumtests.pages.magazineluiza;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumtests.pages.BasePage;
import com.seleniumtests.actionsClass.SafeActions;
import com.seleniumtests.actionsClass.SafeActions.SafeActionsException;
import com.seleniumtests.selectors.MLMainMenuPageSelectors;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class MLMainMenuPage extends BasePage{
	public MLMainMenuPage(WebDriver driver) {
		super(driver);
	}
	
	/** Click all products
	 * @return Main Menu page
	 */
	@Step ("Click all products")
	public MLMainMenuPage clickAllProducts() {
		try {
			
			//	click 'All products' button
			SafeActions.safeClick(driver, By.xpath(MLMainMenuPageSelectors.ALL_PRODUCTS_BUTTON.getXpath()));
			
			//	'allure' framework image capture
			captureEvCenario(driver);
			
			return this;
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'All products': " + e);		
		}
		return this;
	}
	
	/** Click 'Department'
	 * @param department which department of the store will be accessed through the method
	 * @return Department Page
	 */
	@Step ("Click 'Informatica'")
	public MLDepartmentPage clickDepartment(String department) {
		try {

			//	menu open wait
			SafeActions.safeWaitPage(driver);
			
			//	click 'Informatica' 
			SafeActions.safeClick(driver, By.linkText(department));

			//	'allure' framework image capture
			captureEvCenario(driver);

			return new MLDepartmentPage(driver);
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with '" + department + "' page': " + e);		
		}
		return new MLDepartmentPage(driver);
	}
	
	@Attachment(value = "Capture_Evidence_Main_MagazineLuiza", type = "image/png")
	public static byte[] captureEvCenario(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
