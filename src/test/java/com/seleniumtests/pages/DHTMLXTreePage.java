package com.seleniumtests.pages;

import com.seleniumtests.actionsClass.SafeActions;
import com.seleniumtests.selectors.DHTMLXTreePageSelectors;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DHTMLXTreePage extends BasePage {
    public DHTMLXTreePage(WebDriver driver) {
        super(driver);
    }

    @Step("Perform the first element drag and drop")
    public DHTMLXTreePage moveFirstElement(){
        try {
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.LAWRENCE_BLOCK.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            return this;
        } catch (Exception e){
            e.getCause().printStackTrace();
        }
        return this;
    }

    @Step("Perform the second element drag and drop")
    public DHTMLXTreePage moveSecondElement(){
        try {
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.IAN_RANKIN.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            return this;
        } catch (Exception e){
            e.getCause().printStackTrace();
        }
        return this;
    }

    @Step("Perform the third element drag and drop")
    public DHTMLXTreePage moveThirdElement(){
        try {
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.NANCY.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            return this;
        } catch (Exception e){
            e.getCause().printStackTrace();
        }
        return this;
    }

    @Step("Perform the fourth element drag and drop")
    public DHTMLXTreePage moveFourthElement(){
        try {
            SafeActions.safeDragAndDrop(driver,
                    By.xpath(DHTMLXTreePageSelectors.IFRAME.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.MAGAZINES.getXpath()),
                    By.xpath(DHTMLXTreePageSelectors.ZEND_FRAMEWORK_ACTION.getXpath()));
            return this;
        } catch (Exception e){
            e.getCause().printStackTrace();
        }
        return this;
    }

}
