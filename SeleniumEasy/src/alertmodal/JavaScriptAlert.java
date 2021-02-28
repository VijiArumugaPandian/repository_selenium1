package alertmodal;

import java.io.File;
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
import org.testng.reporters.Files;

import framework.KeywordDriven;

public class JavaScriptAlert extends KeywordDriven {
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
			TCname="AlertModel/JavaScriptAlert-TC01";

			driver.findElement(By.linkText("Javascript Alerts")).click();
			ClickOn(OR.jsalertbox);
			System.out.println("clicked on JavaScript alertbox ");
			driver.switchTo().alert().accept();

			ClickOn(OR.jsconfirmbox);
			System.out.println("clicked on JavaScript confirm box OK ");
			driver.switchTo().alert().accept();

			ClickOn(OR.jsconfirmbox);
			System.out.println("clicked on JavaScript confirm box CANCEL");
			driver.switchTo().alert().dismiss();

			ClickOn(OR.jspromptbox);
			System.out.println("clicked on JavaScript prompt box ");
			driver.switchTo().alert().sendKeys("Selenium 2.0");
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			if (driver.findElement(By.xpath("//*[@id=\"prompt-demo\"]")).isDisplayed()) {
				System.out.println("name is displayed");
			} else
				System.out.println("name sent is not received");

		} catch (Exception e) {

		}

	}

	@Test
	public void TC02() {
		TCname="AlertModel/JavaScriptAlert-TC02";
		try {
			driver.findElement(By.linkText("File Download")).click();
			Thread.sleep(1000);

			driver.findElement(By.id("textbox")).sendKeys("Selenium is an open source web application automation tool");
			Thread.sleep(1000);
			driver.findElement(By.id("create")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Download")).click();
		} catch (Exception e) {

		}
	}

}
