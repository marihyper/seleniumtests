package com.seleniumtests.selectors;

public enum MLMainMenuPageSelectors {

	ALL_PRODUCTS_BUTTON ("//*[@id=\"__next\"]//main/section[1]/div[2]/header//div[3]//ul/li[1]/div[1]/a");
	
	private final String xpath;

    private MLMainMenuPageSelectors(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
