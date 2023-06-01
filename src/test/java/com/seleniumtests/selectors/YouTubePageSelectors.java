package com.seleniumtests.selectors;

public enum YouTubePageSelectors {
	
	SEARCH_BAR ( "//*[@id=\"search\"]//input"),
	YOUTUBE_RENDERER_VIDEO ("//*[@id=\"contents\"]/ytd-video-renderer[%s]")
	;
	
	private final String xpath;

    private YouTubePageSelectors(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
	
}
