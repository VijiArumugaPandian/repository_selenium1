package inputform;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.KeywordDriven;

public class AdvancedInputform extends KeywordDriven {
	@BeforeMethod
	public void StartBrowser() {
		OpenBrowser("https://www.seleniumeasy.com/test/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(datepickers.OR.initialalert))));
		WebElement aler = driver.findElement(By.xpath(datepickers.OR.initialalert));
		if (aler.isDisplayed()) {
			aler.click();
		}

		driver.findElement(By.partialLinkText("All Examples")).click();
		driver.findElement(By.linkText("Input Forms")).click();
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
		TCname = "inputform/AdvancedInputfrom-TC01";

		driver.findElement(By.linkText("Input Form Submit")).click();
		sendValues(OR.firstname, "my first name");
		sendValues(OR.lastname, "my last name");
		sendValues(OR.mailid, "sample@gmail.com");
		sendValues(OR.phoneno, "987654321");
		sendValues(OR.address, "sample address");
		sendValues(OR.city, "chennai");

		WebElement drpdwn = driver.findElement(By.xpath(OR.drpdwn));
		Select s = new Select(drpdwn);
		s.selectByIndex(3);
		sendValues(OR.zip, "2356");
		sendValues(OR.website, "www.sample.com");
		driver.findElement(By.xpath(OR.radio)).click();
		sendValues(OR.comments, "sample comment");

		ClickOn(OR.submit);
	}

	@Test
	public void TC02() {
		TCname = "inputform/AdvancedInputfrom-TC02";
		driver.findElement(By.linkText("Ajax Form Submit")).click();
		sendValues(OR.name, "THIS IS NAME");
		sendValues(OR.comm, "this is comment description");
		ClickOn(OR.butn);
	}

	@Test
	public void TC03() {
		TCname = "inputform/AdvancedInputfrom-TC03";
		try {
			driver.findElement(By.linkText("JQuery Select dropdown")).click();

			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('').click()");
			} catch (Exception e) {

		}

	}
}
