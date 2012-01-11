package org.lope.creations.integration;

import java.util.List;

import org.joda.time.DateTime;
import org.lope.creations.model.EgemsUser;
import org.lope.creations.model.email.SendEmail;
import org.lope.creations.parser.CredentialsParser;

public class EgemsLoginTest extends AbstractSeleniumTestCase {

	public void testLoginEgems() throws Exception {
		DateTime date = new DateTime();
		List<EgemsUser> egemsUserList = CredentialsParser
				.getCredentialsCSVList("/home/lemano/.thunderbird/18oxex5l.default/ImapMail/exist.com/login.txt");
		for (int i = 0; i < egemsUserList.size(); i++) {
			if (date.getHourOfDay() > 19) {
				logout(egemsUserList.get(i).getUsername(), egemsUserList.get(i)
						.getPassword());
				SendEmail.sendSuccessMail(egemsUserList.get(i).getUsername(),
						"logged out");
			} else {
				login(egemsUserList.get(i).getUsername(), egemsUserList.get(i)
						.getPassword());
				SendEmail.sendSuccessMail(egemsUserList.get(i).getUsername(),
						"logged in");
			}
		}
	}

	public synchronized void login(String username, String password) {
		selenium.open("https://portal.g2ix.net/egems");
		selenium.waitForPageToLoad("100000");
		selenium.selectFrame("_iframe-agreebox");
		selenium.type("name=login", username);
		selenium.type("name=password", password);
		selenium.click("name=OK");
		selenium.waitForPageToLoad("100000");
		selenium.selectWindow("null");
		selenium.click("css=input[type=\"submit\"]");
		assertTrue(selenium.getConfirmation().matches("^Are you sure[\\s\\S]$"));
		selenium.open("https://portal.g2ix.net/egems/account/logout");
		selenium.waitForPageToLoad("100000");
	}

	public synchronized void logout(String username, String password) {
		selenium.open("https://portal.g2ix.net/egems");
		selenium.waitForPageToLoad("100000");
		selenium.selectFrame("_iframe-agreebox");
		selenium.type("name=login", username);
		selenium.type("name=password", password);
		selenium.click("name=OK");
		selenium.waitForPageToLoad("100000");
		selenium.selectWindow("null");
		selenium.click("//input[@value='Time Out']");
		assertTrue(selenium.getConfirmation().matches("^Are you sure[\\s\\S]$"));
		selenium.open("https://portal.g2ix.net/egems/account/logout");
		selenium.waitForPageToLoad("100000");
	}

}