package alertmodal;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetElementAttribute;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.KeywordDriven;

public class BootStrapAlert extends KeywordDriven {

	@BeforeMethod
	public void startBrowser() {
		OpenBrowser("https://www.seleniumeasy.com/test/");
		WebDriverWait wait = new WebDriverWait(driver, 20);
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
			TCname="AlertModel/BootStrapAlert-TC01";
			driver.findElement(By.linkText("Bootstrap Alerts")).click();

			ClickOn(OR.autoclosablebtn);
			System.out.println("----------AUTOCLOSABLE SUCCESS MESSAGE----------");
			String msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[1]")).getText();
			System.out.println(msg);

			ClickOn(OR.normalsuccessbtn);
			System.out.println("----------NORMAL SUCCESS MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]")).getText();
			System.out.println(msg);
			ClickOn(OR.normalsuccessclose);

			ClickOn(OR.autoclosewarnbtn);
			System.out.println("----------AUTOCLOSABLE WARNING MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]")).getText();
			System.out.println(msg);

			ClickOn(OR.normalwarn);
			System.out.println("----------NORMAL WARNING MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[4]")).getText();
			System.out.println(msg);
			ClickOn(OR.normalwarnclose);

			ClickOn(OR.autoclosedanger);
			System.out.println("----------AUTOCLOSABLE DANGER MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[5]")).getText();
			System.out.println(msg);

			ClickOn(OR.normaldanger);
			System.out.println("----------NORMAL DANGER MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[6]")).getText();
			System.out.println(msg);
			ClickOn(OR.normaldangerclose);

			ClickOn(OR.autoclosableinfo);
			System.out.println("----------AUTOCLOSABLE INFO MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[7]")).getText();
			System.out.println(msg);

			ClickOn(OR.normalinfo);
			System.out.println("----------NORMAL INFO MESSAGE----------");
			msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[8]")).getText();
			System.out.println(msg);
			ClickOn(OR.normalinfoclose);
		} catch (Exception e) {

		}

	}

	@Test
	public void TC02() {
		try {
			TCname="AlertModel/BootStrapAlert-TC02";

			driver.findElement(By.linkText("Bootstrap Modals")).click();
			
			
			System.out.println("----------Clicking on single modal launch----------");
			WebElement singlelaunch = driver.findElement(By.xpath(OR.singleModalLaunch));
			singlelaunch.click();
			Thread.sleep(3000);
			String msg = driver.findElement(By.xpath("//div[@class='modal-body'][1]")).getText();
			System.out.println(msg);
			ClickOn(OR.singlemodalclose);
			
			
			System.out.println("\n\n----------Clicking on multiple modal launch----------\n");
			driver.findElement(By.xpath(OR.multipleModalLaunch)).click();
			Thread.sleep(3000);
			msg=driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[3]")).getText();
			System.out.println("\nMESSAGE IN MULTIPLE MODAL 1"+msg);
			Thread.sleep(2000);
			ClickOn(OR.secondlaunchbtn);
			 msg=driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[5]")).getText();
			 System.out.println("\nMESSAGE IN MULTIPLE MODAL 2"+msg);
			 driver.findElement(By.xpath("//*[@id=\"myModal2\"]/div/div/div[6]/a[1]")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//*[@id=\"myModal\"]/div/div/div[4]/a[1]")).click();
			
			
			
		} catch (Exception e) {

		}

	}
}
