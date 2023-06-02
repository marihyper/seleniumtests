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
	private static final Duration TIMEOUT = Duration.ofSeconds(15);

	/**	FIND ELEMENT
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
			throw new SafeActionsException("The page didn't load in the time limit: " + locator.toString() + ": " + e.getMessage());
		}
	}

	/**	FIND TEXT
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
			throw new SafeActionsException("Element not found: " + locator.toString() + ": " + e.getMessage());
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/** CLICK
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param locator The By element = location of the element
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */
	public static void safeClick (WebDriver driver, By locator ) throws SafeActionsException {
		try {
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: " + locator.toString() + ": " + e.getMessage());
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/**SCROLL BY AMOUNT
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param deltaX position in the horizontal axis
	 * @param deltaY position in the vertical axis
	 * @throws SafeActionsException If scroll failed
	 */
	public static void safeScrollByAmount(WebDriver driver, int deltaX, int deltaY) throws SafeActionsException {
		try {
			Actions actions = new Actions(driver);
			actions.scrollByAmount(deltaX, deltaY).perform();
		} catch (Exception e) {
			throw new SafeActionsException("Scroll by amount failed due to: " + e.getMessage());
		}
	}

	/**DRAG AND DROP
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param source Location of the element to be dragged
	 * @param destination Location of where the element will be dropped
	 * @throws SafeActionsException If the element is not found, if the page didn't load in time.
	 */
	public static void safeDragAndDrop(WebDriver driver, By source, By destination) throws SafeActionsException {
		try {
			Actions act = new Actions(driver);
			// Assure elements are visible
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(source));
			new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOfElementLocated(destination));
			// Assigning the source and destination to its WebElement counterparts
			WebElement src = safeFindElement(driver, source);
			WebElement dest = safeFindElement(driver, destination);
			// Perform the mouse actions
			act.clickAndHold(src)
					.pause(Duration.ofSeconds(2))
					.moveToElement(dest)
					.pause(Duration.ofSeconds(2))
					.release()
					.build()
					.perform();
		} catch (NoSuchElementException e) {
			throw new SafeActionsException("Element not found: "  + e.getMessage());
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/**IS ELEMENT IN VIEW
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @param locator The By element = location of the element
	 * @return a boolean telling if object is on Viewport or not
	 * @throws SafeActions.SafeActionsException – If there was an error checking the element visibility
	 */
	public static boolean isElementInViewport(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;

			boolean isElementInViewport = (Boolean) js.executeScript(
					"var rect = arguments[0].getBoundingClientRect();" +
							"return (" +
							"rect.top >= 0 &&" +
							"rect.left >= 0 &&" +
							"rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
							"rect.right <= (window.innerWidth || document.documentElement.clientWidth)" +
							");",
					element
			);

			return isElementInViewport;
		} catch (Exception e) {
			System.out.println("Failed to determine if element is in viewport due to: " + e.getMessage());
			return false;
		}
	}

	/**ENTER FRAME
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @throws SafeActionsException If error occur in enter frame
	 */
	public static void enterIframe(WebDriver driver, By iframe) throws SafeActionsException {
		try {
			WebElement frameElement = safeFindElement(driver, iframe);
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/**EXIT FRAME
	 * @param driver The WebDriver instance to pass to the expected conditions
	 * @throws SafeActionsException If error occur in exit frame
	 */
	public static void exitIframe(WebDriver driver) throws SafeActionsException {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/** SEND KEYS
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
			throw new SafeActionsException("Element not found: " + locator.toString() + ": " + e.getMessage());
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/** SEND SPECIAL KEYS
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
			throw new SafeActionsException("Element not found: " + locator.toString() + ": " + e.getMessage());
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
		}
	}

	/**	WAIT PAGE
	 * @param driver The WebDriver instance to pass to the expected conditions.
	 * @throws SafeActionsException If the page didn't load in time.
	 */
	public static void safeWaitPage(WebDriver driver) throws SafeActionsException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
		} catch (TimeoutException e) {
			throw new SafeActionsException("The page didn't load in the time limit: " + e.getMessage());
		} catch (Exception e) {
			throw new SafeActionsException("Unexpected error: " + e.getMessage());
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
