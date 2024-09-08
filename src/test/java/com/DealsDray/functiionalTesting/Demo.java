package com.DealsDray.functiionalTesting;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class Demo {
	
	public static WebDriver driver;
	
	@Test
	public void fileUpload() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demo.dealsdray.com/");
		
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		
		driver.findElement(By.xpath("//div[@class = 'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 MuiCard-root css-1cl20sq']//button[@type = 'button'][1]")).click();
		
		driver.findElement(By.xpath("//button[@class = 'MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-vwfva9']")).click();
		driver.findElement(By.xpath("//input[@class = 'MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5']"))
			.sendKeys("C:\\Users\\asus\\Downloads\\demo-data.xlsx");
		driver.findElement(By.xpath("//button[@class = 'MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy']")).click();
		driver.findElement(By.xpath("//button[@class = 'MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.alertIsPresent());
		
		driver.switchTo().alert().accept();
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replace(":", "-");
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("FileValidation " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
