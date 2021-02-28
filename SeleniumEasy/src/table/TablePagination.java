package table;

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
import datepickers.OR;

import framework.KeywordDriven;

public class TablePagination extends KeywordDriven {
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
		driver.findElement(By.linkText("Table")).click();
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
		TCname = "table/TablePagination-TC01";

		driver.findElement(By.linkText("Table Pagination")).click();
		driver.findElement(By.partialLinkText("2")).click();
		driver.findElement(By.partialLinkText("»")).click();
		Thread.sleep(2000);
	}catch(Exception e)
		{
		System.out.println(TCname);
		System.out.println(e.getMessage());
		}
	}
	@Test
	public void TC02() {
		try {
			TCname = "table/TablePagination-TC02";

			driver.findElement(By.linkText("Table Data Search")).click();
			WebElement filserach = driver.findElement(By.xpath(table.OR.filSearch));
			filserach.click();
			Thread.sleep(2000);
			filserach.sendKeys("John");

//second table
//enable the search after clicking on filter
			ClickOn(table.OR.enableSearch);
			WebElement filter = driver
					.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[1]/input"));
			Thread.sleep(2000);
			if (filter.isEnabled()) {
				filter.sendKeys("2");
				System.out.println("Filter is enabled");
			} else {
				System.out.println("Filter is disabled");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Test
	public void TC03() {
		try {
			TCname = "table/TablePagination-TC03";

			driver.findElement(By.linkText("Table Filter")).click();
			driver.findElement(By.xpath(table.OR.greenbtn)).click();
			// check only green is displayed
			// get a list of table elements and check if orange is displayed
			Thread.sleep(3000);
			driver.findElement(By.xpath(table.OR.orangebtn)).click();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
