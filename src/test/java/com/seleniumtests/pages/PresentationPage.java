package com.seleniumtests.pages;

import com.seleniumtests.actionsClass.SafeActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumtests.actionsClass.SafeActions.SafeActionsException;
import com.seleniumtests.selectors.PresentationPageSelectors;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class PresentationPage extends BasePage{

	public PresentationPage(WebDriver driver) {
		super(driver);
	}
	
	/** Search bar
	 * @param searchContentString the String used as content on the search bar.
	 * @return a PresentationPage object.
	 */
	@Step ("Search on Google search bar")
	public PresentationPage submitSearch(String searchContentString) {
		try {
			//	find element, type 'searchContentString' and hit 'enter' key
			SafeActions.safeSendKeys(driver, By.xpath(PresentationPageSelectors.SEARCH_BAR.getXpath()), searchContentString);
			SafeActions.safeSendSpecialKeys(driver, By.xpath(PresentationPageSelectors.SEARCH_BAR.getXpath()), Keys.ENTER);
			//	'allure' framework image capture
			captureEvScenario(driver);
			return this;
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Search Bar': " + e);		
		}
		return this;
	}
	
	/** Enter Maven Repo website
	 * @return PresentationPage type object.
	 */
	@Step ("Enter 'Maven Repository' website")
	public PresentationPage enterMavenRepoWebsite() {
		try {
			//	click 'Maven Repo website'
			SafeActions.safeClick(driver, By.xpath(PresentationPageSelectors.MAVEN_REPO_WEBSITE.getXpath()));
			//	'allure' framework image capture
			captureEvScenario(driver);
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Maven Repository' website: " + e);	
		}
		return this;
	}
	
	/**Search in Maven Repo website search bar
	 * @param searchContentString the String used as content on the search bar.
	 * @return PresentationPage type object.
	 */
	@Step ("Search on the 'Maven Repository' website search bar" )
	public PresentationPage submitSearchInMavenRepoWebsite (String searchContentString) {
		try {
			//	send keys 'searchContentString' on 'Maven Search Bar'
			SafeActions.safeSendKeys(driver, 
					By.xpath(PresentationPageSelectors.MAVEN__WEBSITE_SEARCH_BAR.getXpath()), searchContentString);
			SafeActions.safeSendSpecialKeys(driver, 
					By.xpath(PresentationPageSelectors.MAVEN__WEBSITE_SEARCH_BAR.getXpath()), Keys.TAB);
			SafeActions.safeSendKeys(driver,
					By.xpath(PresentationPageSelectors.MAVEN__WEBSITE_SEARCH_BAR.getXpath()), searchContentString);
			SafeActions.safeSendSpecialKeys(driver,
					By.xpath(PresentationPageSelectors.MAVEN__WEBSITE_SEARCH_BAR.getXpath()), Keys.TAB);

			//	'allure' framework image capture
			captureEvScenario(driver);
			
			//	click 'search button'
			SafeActions.safeClick(driver, By.xpath(PresentationPageSelectors.MAVEN_SEARCH_BUTTON.getXpath()));
			SafeActions.safeWaitPage(driver);
			
			//	'allure' framework image capture
			captureEvScenario(driver);

			//	hit checkbox
			SafeActions.safeClick(driver, By.xpath(PresentationPageSelectors.MAVEN_CHECKBOX.getXpath()));
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Maven Repository' search bar: " + e);	
		}
		return this;
	}
	
	@Attachment(value = "Capture_Evidence_Presentation_page", type = "image/png")
	public static byte[] captureEvScenario(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
