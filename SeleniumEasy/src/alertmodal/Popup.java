package alertmodal;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.KeywordDriven;

public class Popup extends KeywordDriven {
	@BeforeMethod
	public void startBrowser() {

		OpenBrowser("https://www.seleniumeasy.com/test/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(datepickers.OR.initialalert))));
		WebElement aler = driver.findElement(By.xpath(datepickers.OR.initialalert));
		if (aler.isDisplayed()) {
			aler.click();
		}

		driver.findElement(By.partialLinkText("All Examples")).click();
		driver.findElement(By.partialLinkText("Alerts & Modals")).click();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		try {
			System.out.println("--------EXECUTED : " + TCname);

			if (!result.isSuccess()) {
				File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File("./failedScreenShots/" + TCname + ".png"));
			}
			driver.quit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void TC01() {
		try {
			TCname="AlertModel/Popup-TC01";

			driver.findElement(By.linkText("Window Popup Modal")).click();
			String parentWindow = driver.getWindowHandle();
			ClickOn(OR.facebooksingle);
			Set<String> wind = driver.getWindowHandles();

			Iterator<String> i = wind.iterator();
			while (i.hasNext()) {
				driver.switchTo().window(i.next());
				Thread.sleep(2000);
				if (driver.getCurrentUrl().equalsIgnoreCase("data:;")) {
					driver.close();
				}
				if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))

				{
					driver.findElement(By.xpath(OR.facebookusername)).sendKeys("Selenium@gmail.com");

				}
				System.out.println("current page is " + driver.getCurrentUrl());

			}
			driver.switchTo().window(parentWindow);
			Thread.sleep(2000);
			System.out.println("current page is " + driver.getCurrentUrl());
		} catch (Exception e) {

		}
	}

	@Test
	public void TC02() {
		try {
			TCname="AlertModel/Popup-TC02";

			driver.findElement(By.linkText("Window Popup Modal")).click();
			String parentWindow = driver.getWindowHandle();
			ClickOn(OR.twittersingle);
			Set<String> wind = driver.getWindowHandles();

			Iterator<String> i = wind.iterator();
			while (i.hasNext()) {
				driver.switchTo().window(i.next());
				Thread.sleep(2000);
				if (driver.getCurrentUrl().equalsIgnoreCase("data:;")) {
					driver.close();
				}
				if (driver.getCurrentUrl()
						.equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy")) {
					driver.findElement(By.xpath(OR.twitterUsername)).sendKeys("Selenium");

				}
				System.out.println("current page is " + driver.getCurrentUrl());

			}
			driver.switchTo().window(parentWindow);
			Thread.sleep(2000);
			System.out.println("current page is " + driver.getCurrentUrl());
		} catch (Exception e) {

		}
	}

	 @Test
	public void TC03() {
		try {
			TCname="AlertModel/Popup-TC03";

			driver.findElement(By.linkText("Window Popup Modal")).click();
			driver.findElement(By.xpath(OR.followall)).click();
			String Parent = driver.getWindowHandle();
			Set<String> s = driver.getWindowHandles();
			Iterator<String> i = s.iterator();
			while (i.hasNext()) {

				String child = (String) i.next();
				driver.switchTo().window(child);
				Thread.sleep(3000);
				if (driver.getCurrentUrl().equalsIgnoreCase("data:;")) {
					System.out.println("INSIDE DATA WINDOW");
					driver.close();
				}
				if (driver.getCurrentUrl().equalsIgnoreCase(
						"https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fplus.google.com%2F%2BSeleniumeasy&followup=https%3A%2F%2Fplus.google.com%2F%2BSeleniumeasy&flowName=GlifWebSignIn&flowEntry=ServiceLogin")) {
					System.out.println("INSIDE GOOGLE WINDOW");
					driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("MYGOOGLENAME");
					Thread.sleep(2000);
				}
				if (driver.getCurrentUrl()
						.equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy")) {

					System.out.println("INSIDE TWITTER WINDOW");
					driver.findElement(By.xpath(OR.twitterUsername)).sendKeys("Selenium");
					Thread.sleep(2000);
				}
				if (driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy")) {
					System.out.println("INSIDE FACEBOOK WINDOW");

					driver.findElement(By.xpath(OR.facebookusername)).sendKeys("Selenium@gmail.com");
					Thread.sleep(2000);
				}
				System.out.println("The Current Page is " + driver.getCurrentUrl());
			}
			driver.switchTo().window(Parent);

			System.out.println("Cuurent Page URL is " + driver.getCurrentUrl() + "\nTitle is " + driver.getTitle());
		} catch (Exception e) {

		}

	}

	@Test
	public void TC04() {
		try {
			TCname="AlertModel/Popup-TC04";

			driver.findElement(By.linkText("Progress Bar Modal")).click();

			ClickOn(OR.showdialog1);
			System.out.println("--Show Dialog 1 ");
			WebElement progress = driver.findElement(By.xpath(OR.progressbar));
			if (progress.isDisplayed()) {
				System.out.println("Progress bar is displayed - 1");
			} else {
				System.out.println("Progress bar is not displayed - 1");

			}
			Thread.sleep(3000);
			ClickOn(OR.showdialog2);
			System.out.println("--Show Dialog 2 ");
			progress = driver.findElement(By.xpath(OR.progressbar));
			Thread.sleep(2000);
			if (progress.isDisplayed()) {
				System.out.println("Progress bar is displayed - 2");
			} else {
				System.out.println("Progress bar is not displayed - 2");

			}

			Thread.sleep(3000);
			ClickOn(OR.showdialog3);
			System.out.println("--Show Dialog 3 ");
			Thread.sleep(1000);
			progress = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div"));
			if (progress.isDisplayed()) {
				System.out.println("Progress bar is displayed - 3");
			} else {
				System.out.println("Progress bar is not displayed - 3");

			}
		} catch (Exception e) {

		}
	}

}
