package inputform;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.DataDriven;
import framework.KeywordDriven;

public class SimpleFormDemo extends KeywordDriven {
	@BeforeMethod
	public void StartBrowser() {
		OpenBrowser("https://www.seleniumeasy.com/test/");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(datepickers.OR.initialalert))));
		WebElement aler = driver.findElement(By.xpath(datepickers.OR.initialalert));
		if (aler.isDisplayed()) {
			aler.click();
		}
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
	public void TC01() {
		 TCname="inputform/SimpleFormDemo-TC01";
		try {
		
			ClickOn(OR.inputform);
			ClickOn(OR.simpleform);

			// driver.switchTo().alert().dismiss();
			sendValues(OR.inputtxt, "This is simple program");
			ClickOn(OR.showinputtxt);
		} catch (Exception e) {
			System.out.println("exception occured");
		}

	}

 @Test
	public void TC02() {
	 TCname="inputform/SimpleFormDemo-TC02";
		try {

					ClickOn(OR.inputform);
			ClickOn(OR.simpleform);
			sendValues(OR.entera, "5");
			sendValues(OR.enterb, "6");
			ClickOn(OR.addbtn);

		} catch (Exception e) {

		}
	}

@Test
	public void TC03() {
	
		try {
			 TCname="inputform/SimpleFormDemo-TC03";


		driver.findElement(By.partialLinkText("All Examples")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		driver.findElement(By.id("isAgeSelected")).click();
		driver.findElement(By.xpath("//div[3][@class=\'checkbox\']")).click();
		//    //*[@id="easycont"]/div/div[2]/div[2]/div[2]/div[3]
	
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	//Radio button
	@Test
	public void TC04()
	{
		 TCname="inputform/SimpleFormDemo-TC04";


		driver.findElement(By.partialLinkText("All Examples")).click();
		driver.findElement(By.linkText("Input Forms")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input")).click();
		driver.findElement(By.id("buttoncheck")).click();
		if(driver.findElement(By.xpath("//p[@class=\'radiobutton\']")).isDisplayed()) {
			System.out.println("Radio Button is clicked");
		Reporter.log("Radio Button is clicked");
		}else
		{
			System.out.println("Radio Button is not clicked");
			Reporter.log("Radio Button is not clicked");
		}
		driver.findElement(By.xpath("//label[@class=\'radio-inline\']/input[@value=\'Female\' and @name=\'gender\']")).click();
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
		if(driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")).isDisplayed())
		{
			System.out.println("Group Radio button is enabled");
			Reporter.log("Group Radio button is enabled");
		}
		else
		{
			System.out.println("Group Radio button is not enabled");
			Reporter.log("Group Radio button is not enabled");	
		}
	}
//drop down
@Test
public void TC05()
{
	 TCname="inputform/SimpleFormDemo-TC05";


	driver.findElement(By.partialLinkText("All Examples")).click();
	driver.findElement(By.linkText("Input Forms")).click();
	driver.findElement(By.partialLinkText("Select Dropdown List")).click();
	WebElement singledrpdown=driver.findElement(By.xpath("//*[@id=\"select-demo\"]"));
	 Select s=new Select(singledrpdown);
	 s.selectByValue("Sunday");
WebElement multipledrp=driver.findElement(By.id("multi-select"));
s=new Select(multipledrp);
s.selectByIndex(3);
s.selectByIndex(5);
driver.findElement(By.xpath("//*[@id=\"printMe\"]")).click();
	
}

}
