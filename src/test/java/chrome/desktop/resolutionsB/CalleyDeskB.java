package chrome.desktop.resolutionsB;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class CalleyDeskB {
	
	public static WebDriver driver;
	
	@Test
	public void calleyPage() {
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.getcalley.com/");
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replaceAll(":", "-");	
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("firstPageResolutionB " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
