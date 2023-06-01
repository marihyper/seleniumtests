package com.seleniumtests.pages.magazineluiza;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumtests.pages.BasePage;
import com.seleniumtests.actionsClass.SafeActions;
import com.seleniumtests.actionsClass.SafeActions.SafeActionsException;
import com.seleniumtests.selectors.MLDepartmentPageSelectors;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.Map;

public class MLDepartmentPage extends BasePage {

	public MLDepartmentPage(WebDriver driver) {
		super(driver);
	}
	
	/** CLICK A PRODUCT BY XPATH
	 * @param chosenProduct product order number in the selected department page
	 * @return a Product Page object
	 */
	@Step ("Click a product")
	public MLProductPage clickAProduct(String chosenProduct) {
		try {
			/* Path map by index */
			Map<String, Integer> xpathMap = new HashMap<>();
			int maxProducts = 60;

			/*	The loop iterates from 1 to maxProducts and populates the xpathMap with keys and values that are the same.
			Each key and value represents a product index.	*/
			for (int i = 1; i <= maxProducts; i++) {
				String key = String.valueOf(i);
				xpathMap.put(key, i);
			}

			/* Assigns index value to chosen product xpathMap */
			Integer index = xpathMap.get(chosenProduct);

			/* Searches in Hash map for 'index' = 'chosen product' and clicks it */
			if (index != null) {
				String optionXPath = String.format(MLDepartmentPageSelectors.PRODUCT_LIST.getXpath(), index);
				SafeActions.safeClick(driver, By.xpath(optionXPath));
			}

			/* 'allure' framework image capture */
			captureEvCenario(driver);
			
			return new MLProductPage(driver);
			
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with product in the department page: " + e);		
		}
		return new MLProductPage(driver);
	}
	
	@Attachment(value = "Capture_Evidence_MagazineLuiza_Department_page", type = "image/png")
	public static byte[] captureEvCenario(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
