package com.seleniumtests.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumtests.pages.BrowserWebDriverPage;
import com.seleniumtests.pages.magazineluiza.MLMainMenuPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Magazine Luiza 'Product' tests")
@Feature("Java, Selenium WebDriver, TestNG")
public class MLProductTest {
	private static final String URL_MAGAZINE_LUIZA_STRING = "https://www.magazineluiza.com.br/#";
	private WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = BrowserWebDriverPage.getFreshChromeDriver(URL_MAGAZINE_LUIZA_STRING);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Magazine Luiza 'Product' page Scenario")
	@Description("Buy a product in its page")
	public void productTest() {
		new MLMainMenuPage(driver)
				.clickAllProducts()
				.clickDepartment("Informática")
				.clickAProduct("1")
				.clickBuyNow();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
