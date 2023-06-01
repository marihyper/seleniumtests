package com.seleniumtests.selectors;

public enum PresentationPageSelectors {

	SEARCH_BAR ("//*[@id=\"APjFqb\"]"),
	MAVEN_REPO_WEBSITE ("//*[@id=\"rso\"]/div[1]/div//div//div//div[1]/a/h3"),
	MAVEN__WEBSITE_SEARCH_BAR ("//*[@id=\"query\"]"),
	MAVEN_SEARCH_BUTTON ("//*[@id=\"search\"]/form/input[2]"),
	MAVEN_CHECKBOX ("//*[@id=\"challenge-stage\"]//label/span[1]//input")
	;
	
	private final String xpath;

    private PresentationPageSelectors(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
