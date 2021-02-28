package datepickers;

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

public class DatePicker extends KeywordDriven {
	@BeforeMethod
	public void startBrowser() {
		OpenBrowser("https://www.seleniumeasy.com/test/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(datepickers.OR.initialalert))));
		WebElement aler = driver.findElement(By.xpath(datepickers.OR.initialalert));
		if (aler.isDisplayed()) {
			aler.click();
		}
		driver.findElement(By.partialLinkText("All Examples")).click();
		driver.findElement(By.linkText("Date pickers")).click();
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
		TCname="datePickers/DatePicker-TC01";
		driver.findElement(By.linkText("Bootstrap Date Picker")).click();
		driver.findElement(By.xpath("//input[@class='form-control'][1]")).sendKeys("10/02/2021");
	
	driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[2]")).sendKeys("19/02/2021");
	Thread.sleep(2000);	
	driver.findElement(By.xpath("//*[@id=\"datepicker\"]/input[1]")).sendKeys("17/02/2021");
	Thread.sleep(2000);	
	driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]")).click();
	Thread.sleep(2000);	}catch(Exception e)
		{
		System.out.println(TCname);
		System.out.println(e.getMessage());
		}
	}
@Test
public void TC02() {
	try {
	TCname="datePickers/DatePicker-TC02";
	driver.findElement(By.linkText("JQuery Date Picker")).click();
	driver.findElement(By.id("from")).sendKeys("02/02/2021");
	driver.findElement(By.id("to")).sendKeys("03/02/2021");
	Thread.sleep(2000);
}catch(Exception e)
{
System.out.println(TCname);
System.out.println(e.getMessage());
}
}
}
