package com.seleniumtests.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumtests.pages.BrowserWebDriverPage;
import com.seleniumtests.pages.PresentationPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Google tests")
@Feature("Java, Selenium WebDriver, TestNG")
public class PresentationTest {
    private static final String URL_GOOGLE_STRING = "https://www.google.com/";
    
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = BrowserWebDriverPage.getFreshChromeDriver(URL_GOOGLE_STRING);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Presentation Scenario")
	@Description("Test to send input String and search it with Google")
	public void presentationTest() {
		new PresentationPage(driver)
		.submitSearch("Maven Repository")
		.enterMavenRepoWebsite()
		.submitSearchInMavenRepoWebsite("testng")
		;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
