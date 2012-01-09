package com.tsl.example.cars.integration;

public class CarIntegrationTest extends AbstractSeleniumTestCase {
	
	public void testLoginEgems() throws Exception {
		selenium.open("https://portal.g2ix.net/egems");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("_iframe-agreebox");
		selenium.type("name=login", "lemano");
		selenium.type("name=password", "123qwe");
		selenium.click("name=OK");
		selenium.waitForPageToLoad("30000");
		selenium.selectWindow("null");
		selenium.click("css=input[type=\"submit\"]");
		assertTrue(selenium.getConfirmation().matches("^Are you sure[\\s\\S]$"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}	
}
