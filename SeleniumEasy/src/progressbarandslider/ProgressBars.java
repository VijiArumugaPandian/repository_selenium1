package progressbarandslider;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.KeywordDriven;

public class ProgressBars extends KeywordDriven {

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
		driver.findElement(By.partialLinkText("Progress Bars")).click();
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

	// JQUERY DOWNLOADD PROGRESS BAR
	@Test
	public void TC01() {
		try {
			TCname="progressbarandslider/ProgressBars-TC01";

			driver.findElement(By.linkText("JQuery Download Progress bars")).click();
			driver.findElement(By.id("downloadButton")).click();
			Thread.sleep(3000);
			WebElement closebtn = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/button"));
			if (closebtn.isDisplayed()) {
				System.out.println("Close button is displayed");
				closebtn.click();
			} else
				System.out.println("close button is not displayed");
		} catch (Exception e)

		{
		}
	}

	// BOOTSTRAP PROGRESS BAR
	@Test
	public void TC02() {
		try {
			TCname="progressbarandslider/ProgressBars-TC02";
			driver.findElement(By.linkText("Bootstrap Progress bar")).click();
			ClickOn(OR.bootstrapbutton);
			WebElement progress = driver.findElement(By.xpath("//*[@id=\"circle\"]/div/div[1]"));
			Thread.sleep(3000);
			String complete = progress.getText();
			System.out.println("complete percentage is " + complete);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			int per = Integer.parseInt(complete);
			System.out.println("per ===" + per);
			while (per < 100) {
				System.out.println("inside while per=" + per);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			if (per == 100) {
				System.out.println("download complete");
				System.out.println("complete %" + progress);

			}
		} catch (Exception e) {

		}
	}

	@Test
	public void TC03() {
		TCname="progressbarandslider/ProgressBars-TC03";

		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"slider1\"]/div/input"));
		Actions act = new Actions(driver);
//CASE 1

		int sliderwidth = slider1.getSize().getWidth();
		System.out.println("Slider " + sliderwidth);
		String percenta = driver.findElement(By.xpath("//output[@id=\'range\']")).getText();
		System.out.println("percentage is " + percenta);

		act.moveToElement(slider1, 100,0).click();
		act.build().perform();
		String percenta2 = driver.findElement(By.xpath("//output[@id=\'range\']")).getText();

		System.out.println("percentage is after " + percenta2);

	

	}

}
