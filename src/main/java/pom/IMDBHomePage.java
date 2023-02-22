package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.UtilClass;

public class IMDBHomePage {

	WebDriver driver;

	public IMDBHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//li[@class='ipc-inline-list__item']/a)[41]")
	WebElement releaseDate;
	@FindBy(xpath = "//li[@data-testid=\"title-details-origin\"]/div")
	WebElement country;

	public String imdbDate() {

		UtilClass.waitElementDisplay(releaseDate);
		String dateIMBD = releaseDate.getText();
		return dateIMBD;
	}

	public String imdbCountry() {
		UtilClass.waitElementDisplay(country);
		String ContryIMBD = country.getText();
		return ContryIMBD;
	}

}
