package testcases;

import org.testng.annotations.Test;

import keywords.ApplicationKeywords;
import keywords.GenericKeywords;
import keywords.ValidationKeywords;

public class CreatePortfolioTest 
{
	@Test
	public void createPortFolioTest()
	{

		// login
		// create
		// verify
		// Call k/w s
		/*
		 * GenericKeywords gKeywords = new GenericKeywords();
		 * gKeywords.openBrowser("Chrome");
		 * gKeywords.navigate("https://in.rediff.com/");
		 * 
		 * //validate title ValidationKeywords vKeywords = new ValidationKeywords();
		 * vKeywords.validateTitle(); vKeywords.validateElementPresent("Ele");
		 * 
		 * gKeywords.type("userName", "brahma.qa1@gmail.com");
		 * gKeywords.click("Login_Button");
		 * 
		 * // Call appl k/w ApplicationKeywords aKeywords = new ApplicationKeywords();
		 * aKeywords.selectDateFromCalendar();
		 */
		// or use inheritance 
		ApplicationKeywords appl = new ApplicationKeywords();
		appl.openBrowser("Chrome");
//		appl.openBrowser("firefox");
//		appl.navigate("https://in.rediff.com/");
		appl.navigate("url");
		
//		appl.validateTitle();
//		appl.validateElementPresent("USer");
		appl.type("username_css", "brahma.qa1");
		appl.type("password_xpath", "Samyu@123321");
		
//		appl.click("login_submit");// error: java.lang.NullPointerException: 
		appl.click("login_submit_id");
		appl.validateLogin();
		
		appl.selectDateFromCalendar();
		
	}
}
