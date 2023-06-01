package com.seleniumtests.actionsClass;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

public class SafeActions {
	/*	Safe use methods class with exception handling	*/
	private static final Duration TIMEOUT = Duration.ofSeconds(10);

	/**	FIND ELEMENT GENERIC method
	 * @param driver The WebDriver instance to pass to the expected conditions.
	 * @param locator The By element = location of the element.
	 * @return WebElement object.
	 * @throws SafeActionsException if the page didn't load in time.
	 */
	public static WebElement safeFindElement(WebDriver driver, By locator) throws SafeActionsException {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + locator.toString(), e);
		}
	}

	/**	FIND TEXT method
	 * @param driver The WebDriver instance to pass to the expected conditions.
	 * @param locator The By element = location of the element.
	 * @return captured text String.
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */
	public static String safeFindText(WebDriver driver, By locator) throws SafeActionsException {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: " + locator.toString(), e);
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}

	/** CLICK method
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param locator The By element = location of the element
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */
	public static void safeClick (WebDriver driver, By locator ) throws SafeActionsException {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: " + locator.toString(), e);
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);	
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}

	/**DRAG AND DROP
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param iframe If iframe in which the source is located
	 * @param source Location of the element to be dragged
	 * @param destination Location of where the element will be dropped
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */
	public static void safeDragAndDrop(WebDriver driver, By iframe, By source, By destination) throws SafeActionsException {
		try {
			Actions act = new Actions(driver);
			/*Scroll by amount*/
			act.scrollByAmount(0, 200);
			/*Locate iframe by id or name*/
			WebElement frameElement = driver.findElement(iframe);
			/*Switch to the iframe*/
			driver.switchTo().frame(frameElement);
			/*Making sure elements are visible*/
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(source));
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(destination));
			/*Assigning the source and destination to its WebElement counterparts*/
			WebElement src = driver.findElement(source);
			WebElement dest = driver.findElement(destination);
			/*Performing the mouse actions*/
			act.clickAndHold(src)
					.pause(Duration.ofSeconds(2))
					.moveToElement(dest)
					.pause(Duration.ofSeconds(2))
					.release()
					.build()
					.perform();
			/*After you are done with the iframe, don't forget to switch back to the main document*/
			driver.switchTo().defaultContent();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + e);
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}

	/** SEND KEYS method
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param locator The By element = location of the element
	 * @param sentKeys The text that the user sends as input
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */	
	public static void safeSendKeys(WebDriver driver, By locator, String sentKeys) throws SafeActionsException {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(sentKeys);
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: " + locator.toString(), e);
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}

	/** SEND SPECIAL KEYS method
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param locator The By element = location of the element
	 * @param key Special key used as input
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */	
	public static void safeSendSpecialKeys(WebDriver driver, By locator, Keys key) throws SafeActionsException {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).sendKeys(key);
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: " + locator.toString(), e);
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}

	/**	WAIT PAGE method
	 * @param driver The WebDriver instance to pass to the expected conditions.
	 * @throws SafeActionsException If the page didn't load in time.
	 */
	public static void safeWaitPage(WebDriver driver) throws SafeActionsException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: ", e);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: ", e);
		}
	}
	
	/**	SAFE ACTIONS EXCEPTION CLASS
	 * 
	 * @author Mariana
	 *
	 */
	public static class SafeActionsException extends Exception {
		public SafeActionsException(String message) {
			super(message);
		}

		public SafeActionsException(String message, Throwable cause) {
			super(message, cause);
		}
	}

}
