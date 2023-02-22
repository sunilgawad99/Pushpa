package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	
	WebDriver driver;
	
	public WebDriver webDriverInitilizer(String browser )
	{
		if(browser.equals("firefox"))
		{
		
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		}
		else if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.imdb.com/title/tt9389998/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
	}

}
