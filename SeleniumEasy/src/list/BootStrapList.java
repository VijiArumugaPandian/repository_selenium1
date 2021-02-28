package list;

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

import datepickers.DatePicker;

import framework.KeywordDriven;

public class BootStrapList extends KeywordDriven {
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
		driver.findElement(By.linkText("List Box")).click();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {
		try {
			System.out.println("--------EXECUTED : " + TCname);

			if (!result.isSuccess()) {
				File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File("./failedScreenShots/" + TCname + ".png"));
			}			driver.quit();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void TC01()
	{
		TCname="list/BootStrapList-TC01";
		driver.findElement(By.linkText("Bootstrap List Box")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[3]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div/ul/li[4]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button[2]")).click();
		
		
	}
	@Test
	public void TC02() {
		TCname="list/BootStrapList-TC02";

		driver.findElement(By.linkText("JQuery List Box")).click();
		ClickOn(OR.option5);
		ClickOn(OR.option6);
		ClickOn(OR.addbtn);
		
		WebElement selecteditems=driver.findElement(By.xpath("//*[@id=\"pickList\"]/div/div[3]/select"));
		WebElement item=driver.findElement(By.xpath("//*[@id=\"pickList\"]/div/div[3]/select/option"));
		WebDriverWait wait=new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(item));
		if(item.isDisplayed())
		{
			System.out.println("DIsplayed Successfully"+item);
		}
		else
			System.out.println("not displyed");
	}
@Test
public void TC03()
{
	TCname="list/BootStrapList-TC03";

	driver.findElement(By.linkText("Data List Filter")).click();
	driver.findElement(By.xpath("//*[@id=\"input-search\"]")).sendKeys("Brenda");
}


}
