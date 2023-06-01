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

@Epic("Magazine Luiza 'Department page' tests")
@Feature("Java, Selenium WebDriver, TestNG")
public class MLDepartmentTest {
	
	private static final String URL_MAGAZINE_LUIZA_STRING = "https://www.magazineluiza.com.br/#";
	private WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = BrowserWebDriverPage.getFreshChromeDriver(URL_MAGAZINE_LUIZA_STRING);
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Magazine Luiza 'Department' page Scenario")
	@Description("Get second product in 'Informatica' page")
	public void departmentTest() {
		new MLMainMenuPage(driver)
		.clickAllProducts()
		.clickDepartment("Games")
		.clickAProduct("10")
		;
	}

//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
