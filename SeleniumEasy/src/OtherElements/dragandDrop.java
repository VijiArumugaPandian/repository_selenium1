package OtherElements;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.KeywordDriven;

public class dragandDrop extends KeywordDriven{

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
		driver.findElement(By.partialLinkText("Others")).click();
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
		TCname="OtherElements/dragAndDrop-TC01";
		
		driver.findElement(By.linkText("Drag and Drop")).click();
		
		WebElement src=driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
		src.click();
		
		WebElement dest=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div"));
		Actions a=new Actions(driver);
		a.dragAndDrop(src,dest).perform();;
	}
@Test
public void TC02() {
	try {
	TCname="OtherElements/dragAndDrop-TC02";

	driver.findElement(By.linkText("Dynamic Data Loading")).click();
	Actions a=new Actions(driver);
	a.doubleClick(driver.findElement(By.xpath(OR.dynamicbyn)));
	a.perform();
	WebElement load=driver.findElement(By.xpath("//div[@id='loading']"));

	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.visibilityOf(load));
	
	if(load.isDisplayed())
	{
		System.out.println("Dynamic Data Successfully loaded");
		
	}
	else
	{
		System.out.println("Dynamic Data not  loaded");

	}
}catch(Exception e)
	{
	System.out.println(TCname);
	System.out.println("exception occured"+e.getMessage());
	}
}
@Test
public void TC03() {
	TCname="OtherElements/dragAndDrop-TC03";

	driver.findElement(By.linkText("Charts Demo")).click();
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
