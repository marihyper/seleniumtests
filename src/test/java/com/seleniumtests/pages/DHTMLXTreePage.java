package com.seleniumtests.pages;

import com.seleniumtests.actionsClass.SafeActions;
import com.seleniumtests.selectors.DHTMLXTreePageSelectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DHTMLXTreePage extends BasePage {
    public DHTMLXTreePage(WebDriver driver) {
        super(driver);
    }

    @Step("Perform 'Lawrence Block' drag and drop")
    public DHTMLXTreePage moveLawrenceBlock(){
        try {
            //enter iframe
            SafeActions.enterIframe(driver, By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()));
            //verify if the element is visible, if not, scrolls page by amount
            while (!SafeActions.isElementInViewport(driver, By.xpath(DHTMLXTreePageSelectors.LAWRENCE_BLOCK.getXpath()))) {
                SafeActions.safeScrollByAmount(driver, 0, 100);  // Adjust delta value as needed
            }
            //perform mouse actions
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.LAWRENCE_BLOCK.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            //exit iframe
            SafeActions.exitIframe(driver);
            return this;
        } catch (SafeActions.SafeActionsException e){
            System.out.println("Error interacting with 'Lawrence Block': " + e);
        }
        return this;
    }

    @Step("Perform 'Ian Rankin' drag and drop")
    public DHTMLXTreePage moveIanRankin(){
        try {
            //enter iframe
            SafeActions.enterIframe(driver, By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()));
            //verify if the element is visible, if not, scrolls page by amount
            while (!SafeActions.isElementInViewport(driver, By.xpath(DHTMLXTreePageSelectors.IAN_RANKIN.getXpath()))) {
                SafeActions.safeScrollByAmount(driver, 0, 100);  // Adjust delta value as needed
            }
            //perform mouse actions
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.IAN_RANKIN.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            //exit iframe
            SafeActions.exitIframe(driver);
            return this;
        } catch (SafeActions.SafeActionsException e){
            System.out.println("Error interacting with 'Ian Rankin': " + e);
        }
        return this;
    }

    @Step("Perform 'Nancy' drag and drop")
    public DHTMLXTreePage moveNancy(){
        try {
            //enter iframe
            SafeActions.enterIframe(driver, By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()));
            //verify if the element is visible, if not, scrolls page by amount
            while (!SafeActions.isElementInViewport(driver, By.xpath(DHTMLXTreePageSelectors.NANCY.getXpath()))) {
                SafeActions.safeScrollByAmount(driver, 0, 100);  // Adjust delta value as needed
            }
            //perform mouse actions
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.NANCY.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            //exit iframe
            SafeActions.exitIframe(driver);
            return this;
        } catch (SafeActions.SafeActionsException e){
            System.out.println("Error interacting with 'Nancy': " + e);
        }
        return this;
    }

    @Step("Perform 'Magazines' drag and drop")
    public DHTMLXTreePage moveMagazines(){
        try {
            SafeActions.enterIframe(driver, By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()));

            if (!SafeActions.isElementInViewport(driver, By.xpath(DHTMLXTreePageSelectors.MAGAZINES.getXpath()))) {
                SafeActions.safeScrollByAmount(driver, 0, 100);  // Adjust delta value as needed
            }

            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.MAGAZINES.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            SafeActions.exitIframe(driver);
            return this;
        } catch (Exception e){
            e.getCause().printStackTrace();
        }
        return this;
    }

}
