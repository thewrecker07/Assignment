package chrome.mobile.resolutionB;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class ProFeatures {
	
	public static WebDriver driver;
	
	@Test
	public void proFeatures() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(414, 896));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.getcalley.com/calley-pro-features/");
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replace(":", "-");
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("proFeatures_mob_chromeB " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

