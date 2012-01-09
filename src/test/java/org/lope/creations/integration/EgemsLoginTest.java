package org.lope.creations.integration;

import java.util.List;

import org.lope.creations.model.EgemsUser;
import org.lope.creations.parser.CredentialsParser;


public class EgemsLoginTest extends AbstractSeleniumTestCase{

	public void testLoginEgems2() throws Exception {
		List<EgemsUser> egemsUserList = CredentialsParser.getCredentialsCSVList("/home/lemano/.thunderbird/18oxex5l.default/ImapMail/exist.com/login.txt");
		for (int i = 0;i < egemsUserList.size();i++){
			login(egemsUserList.get(i).getUsername(), egemsUserList.get(i).getPassword());
		}
	}
	
	public synchronized void login(String username, String password){
	    selenium.open("https://portal.g2ix.net/egems");
		selenium.waitForPageToLoad("30000");
		selenium.selectFrame("_iframe-agreebox");
		selenium.type("name=login", username);
		selenium.type("name=password", password);
		selenium.click("name=OK");
		selenium.waitForPageToLoad("30000");
		selenium.selectWindow("null");
		selenium.click("css=input[type=\"submit\"]");
		assertTrue(selenium.getConfirmation().matches("^Are you sure[\\s\\S]$"));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}
	
}