package com.seleniumtests.selectors;

public enum MLDepartmentPageSelectors {
	PRODUCT_LIST ("//*[@id=\"__next\"]//main/section[4]/div[4]//ul/li[%s]");
	
	private final String xpath;
	
	MLDepartmentPageSelectors(String xpath) {
	    this.xpath = xpath;
	}

	public String getXpath() {
	    return xpath;
	}
}





