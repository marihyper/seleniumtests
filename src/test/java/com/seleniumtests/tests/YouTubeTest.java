package com.seleniumtests.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumtests.pages.BrowserWebDriverPage;
import com.seleniumtests.pages.YouTubePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("YouTube tests")
@Feature("Java, Selenium WebDriver, TestNG")
public class YouTubeTest {
	private static final String URL_YOUTUBE_STRING = "https://www.youtube.com/";
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = BrowserWebDriverPage.getFreshChromeDriver(URL_YOUTUBE_STRING);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "YouTube Scenario")
	@Description("Test to send input String and search it inside YouTube")
	public void youtubeWebsite() {
		new YouTubePage(driver)
		.submitSearch("Selenium")
		.chooseVideo("2");
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1
			,description = "YouTube Scenario"
//			,enabled = false
	)
	@Description("Test to send input String and search it inside YouTube")
	public void youtubeWebsite2() {
		new YouTubePage(driver)
		.submitSearch("Selenium")
		.chooseVideo("3");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
