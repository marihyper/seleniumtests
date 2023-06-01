package com.seleniumtests.selectors;

public enum DHTMLXTreePageSelectors {
    BOOKS("//span[text()='Books']"),
    IAN_RANKIN("//span[text()='Ian Rankin']"),
    IFRAME("//iframe[@class='js-iframe active']"),
    LAWRENCE_BLOCK("//span[text()='Lawrence Block']"),
    MAGAZINES("//span[text()='Magazines']"),
    NANCY("//span[text()='Nancy Atherton']"),
    ZEND_FRAMEWORK_ACTION("//li[text()='Zend Framework in Action']");
    private final String xpath;

    DHTMLXTreePageSelectors(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
