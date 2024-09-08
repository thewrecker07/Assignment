package chrome.mobile.resolutionC;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class DemoPage {
	
	public static WebDriver driver;
	
	@Test
	public void demoPage() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(375, 667));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.getcalley.com/see-a-demo/");
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replace(":", "-");
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("demoPage_mob_chromeC " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
