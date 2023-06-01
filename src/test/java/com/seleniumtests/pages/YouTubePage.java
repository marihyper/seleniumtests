package com.seleniumtests.pages;

import java.util.HashMap;
import java.util.Map;

import com.seleniumtests.actionsClass.SafeActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.seleniumtests.actionsClass.SafeActions.SafeActionsException;
import com.seleniumtests.selectors.YouTubePageSelectors;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

public class YouTubePage extends BasePage{

	public YouTubePage(WebDriver driver) {
		super(driver);
	}
	
	/** Search on YouTube search bar
	 * @param searchContentString the String used as content on the search bar 
	 * @return a YouTubePage type object
	 */
	@Step ("Search on YouTube search bar")
	public YouTubePage submitSearch(String searchContentString) {
		try {
			//	 find element, type searchContentString and hit 'enter' key
			SafeActions.safeClick(driver, By.xpath(YouTubePageSelectors.SEARCH_BAR.getXpath()));
			SafeActions.safeSendKeys(driver, By.xpath(YouTubePageSelectors.SEARCH_BAR.getXpath()), searchContentString);
			//	 'allure' framework image capture
			captureEvCenario(driver);
			SafeActions.safeSendSpecialKeys(driver, By.xpath(YouTubePageSelectors.SEARCH_BAR.getXpath()), Keys.ENTER);
			return this;
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Search Bar': " + e);		
		}
		return this;
	}
	
	/** Choose a video by xpath
	 * @param chosenVideo video order number in the page
	 * @return YouTubePage type object
	 */
	@Step ("Choose a video")
	public YouTubePage chooseVideo(String chosenVideo) {
		try {
			//	Path map by 'index'
			Map<String, Integer> xpathMap = new HashMap<>();
			xpathMap.put("1", 1);
			xpathMap.put("2", 2);
			xpathMap.put("3", 3);
			xpathMap.put("4", 4);
			xpathMap.put("5", 5);
			xpathMap.put("6", 6);
			xpathMap.put("7", 7);
			xpathMap.put("8", 8);
			xpathMap.put("9", 9);
			xpathMap.put("10", 10);
			xpathMap.put("11", 11);
			xpathMap.put("12", 12);

			//	Searches in Hash map for 'index' = 'video chosen' and clicks it
			Integer index = xpathMap.get(chosenVideo);
			if (index != null) {
				String optionXPath = String.format(YouTubePageSelectors.YOUTUBE_RENDERER_VIDEO.getXpath(), index);
				SafeActions.safeClick(driver, By.xpath(optionXPath));
				
				//	'allure' framework image capture
				captureEvCenario(driver);
			}
		} catch (SafeActionsException e) {
			System.out.println("Error interacting with 'Videos': " + e);
		}
		return this;
	}
	
	@Attachment(value = "Capture_Evidence_Youtube_page", type = "image/png")
	public static byte[] captureEvCenario(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
