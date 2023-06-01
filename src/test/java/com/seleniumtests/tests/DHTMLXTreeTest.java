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
    
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, description = "DragAndDrop Exercise Scenario")
    @Description("Test to send the first drag and drop")
    public void dragAndDropTreeDHX(){
        new DHTMLXTreePage(driver)
/*                .moveFirstElement()
                .moveSecondElement()
                .moveThirdElement()*/
                .moveFourthElement()
        ;
    }
}
