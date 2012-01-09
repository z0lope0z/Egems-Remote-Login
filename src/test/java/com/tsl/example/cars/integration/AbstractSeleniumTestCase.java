package com.tsl.example.cars.integration;

import junit.framework.TestCase;

import com.thoughtworks.selenium.DefaultSelenium;

public abstract class AbstractSeleniumTestCase extends TestCase {

	protected DefaultSelenium selenium;

	protected DefaultSelenium createSeleniumClient(String url) throws Exception {
	    return new DefaultSelenium("localhost", 4444, "*firefox", url);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	    selenium = createSeleniumClient("http://localhost:8080/");
	    selenium.start();
	}
    
    @Override
    protected void tearDown() throws Exception {
    	selenium.stop();
    	super.tearDown();
    }
}
