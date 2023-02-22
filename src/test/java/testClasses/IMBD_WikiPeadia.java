package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pom.IMDBHomePage;
import pom.Wikipedia;
import utility.UtilClass;

public class IMBD_WikiPeadia {
	IMDBHomePage imdb;
	Wikipedia wiki;
	WebDriver driver;
	UtilClass util;

	@BeforeClass
	@Parameters
	public void initiliation(String browser) {
		BaseClass base = new BaseClass();
		driver = base.webDriverInitilizer(browser);
		imdb = new IMDBHomePage(driver);
		wiki = new Wikipedia(driver);
		util = new UtilClass(driver);
	}

	@Test
	public void dateAndCountryValidation() {
		String date = imdb.imdbDate();
		String con = imdb.imdbCountry();
		driver.navigate().to("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		String d = wiki.wikipediaDate();
		String c = wiki.wikiCountry();
		Assert.assertEquals(con, c);
		Assert.assertEquals(date, d);

	}

	@AfterClass
	public void unLoadDriver() {
		driver.close();
	}

}
