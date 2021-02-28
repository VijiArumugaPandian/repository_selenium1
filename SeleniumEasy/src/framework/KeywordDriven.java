package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import inputform.OR;

public class KeywordDriven extends DataDriven {

	public void OpenBrowser(String URL) {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void OpenBrowser(String URL, String Browser)

	{
		System.out.println("Executing : " + TCname);

		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		} else if (Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		} else {
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver = new ChromeDriver();
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		}

	}

	public void ClickOn(String xpat) {
		driver.findElement(By.xpath(xpat)).click();
	}

	public void sendValues(String xpath, String Value) {
		driver.findElement(By.xpath(xpath)).sendKeys(Value);
	}
}
