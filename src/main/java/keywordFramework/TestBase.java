package keywordFramework;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import keywords.Keyword;

public class TestBase {
	private static final String APP_URL = "https://www.cawale.com";
	@BeforeMethod
	public void openBrowser() {
		Keyword.openBrowser("Chrome");
		Keyword.launchUrl(APP_URL);

	}

	@AfterMethod
	public void closeBrowser() {
		Keyword.closeBrowser();

	}
}
