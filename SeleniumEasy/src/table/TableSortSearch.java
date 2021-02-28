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

import framework.KeywordDriven;

public class TableSortSearch extends KeywordDriven{
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
		TCname="table/TableSortSearch-TC01";
		driver.findElement(By.linkText("Table Sort & Search")).click();
		//sendValues(OR.searchtext, "Account");
		driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input")).sendKeys("Account");
//HANDLE THIS DYNAMIC TABLE AND CHECK IF THE COLUMN CONTAINS THE VALUE ACC
		
		Thread.sleep(2000);	
		}catch(Exception e)
		{
			System.out.println(TCname + " execption occured "+e.getMessage());
		}
	
	}

}
