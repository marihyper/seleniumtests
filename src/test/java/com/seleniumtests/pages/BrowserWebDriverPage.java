package com.seleniumtests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWebDriverPage {

	/**
	 * 
	 * @return WebDriver object
	 */
    public static WebDriver createNewChromeDriver() {
        WebDriverManager.chromedriver().setup();

        //	Set Chrome options
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-infobars"); // Disable infobars
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-dev-shm-usage"); // Disable shared memory usage
        options.addArguments("--disable-browser-side-navigation"); // Disable browser side navigation
        options.addArguments("--disable-gpu"); // Disable GPU acceleration

        return new ChromeDriver(options);
    }

    /**
     * 
     * @param url The website address the WebDriver will go to
     * @return WebDriver type object, with the website in the url param
     */
    public static WebDriver getFreshChromeDriver(String url) {
        WebDriver driver = createNewChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}
