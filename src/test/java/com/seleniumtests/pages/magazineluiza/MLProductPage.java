package com.seleniumtests.pages.magazineluiza;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumtests.pages.BasePage;
import com.seleniumtests.actionsClass.SafeActions;
import com.seleniumtests.actionsClass.SafeActions.SafeActionsException;

import io.qameta.allure.Step;

public class MLProductPage extends BasePage{
	public MLProductPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * CLICK BUY NOW
	 * @return TODO a BUY page
	 */
	@Step("Click Buy Now")
	public MLProductPage clickBuyNow() {
		try {
			//	click the Buy product button
			SafeActions.safeClick(driver, By.cssSelector
					("#__next > div > main > section:nth-child(6) > div.sc-jrcTuL.kQzMUn > div:nth-child(1)"));
			
			//	'allure' framework image capture
			captureEvCenario(driver);
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Buy Now' button: " + e);
		}
		return this;
	}

	@Attachment(value = "Capture_Evidence_MagazineLuiza_Informatica_page", type = "image/png")
	public static byte[] captureEvCenario(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
