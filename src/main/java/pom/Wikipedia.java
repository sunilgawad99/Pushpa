package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilClass;

public class Wikipedia {
	WebDriver driver;

	public Wikipedia(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='plainlist'])[4]")
	WebElement date;
	@FindBy(xpath = "(//tr/td[@class='infobox-data'])[12]")
	WebElement country;

	public String wikipediaDate() {

		UtilClass.waitElementDisplay(date);
		UtilClass.javaExecutorClick(date);
		String dat = date.getText();
		return dat;
	}

	public String wikiCountry() {
		UtilClass.waitElementDisplay(country);
		String con = country.getText();
		return con;
	}

}
