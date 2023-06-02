package com.seleniumtests.tests;

import com.seleniumtests.pages.BrowserWebDriverPage;
import com.seleniumtests.pages.DHTMLXTreePage;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("DHTMLXTreeTest")
@Feature("Java, Selenium WebDriver, TestNG")
public class DHTMLXTreeTest {
    private static final String URL_DHTMLX_STRING =
            "https://dhtmlx.com/docs/products/dhtmlxTree/";
    private WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        driver = BrowserWebDriverPage.getFreshChromeDriver(URL_DHTMLX_STRING);
    }

    @Test(priority = 1, description = "DragAndDrop Exercise Scenario 1")
    @Description("Test to send several drag and drop commands")
    public void dragAndDropTreeDHX(){
        new DHTMLXTreePage(driver)
                .moveLawrenceBlock()
                .moveIanRankin()
                .moveNancy()
                .moveMagazines()
        ;
    }

    @Test(priority = 2, description = "DragAndDrop Exercise Scenario 2")
    @Description("Test to send only one drag and drop command with element out of view")
    public void dragAndDrop2TreeDHX(){
        new DHTMLXTreePage(driver)
                .moveMagazines()
        ;
    }
}
