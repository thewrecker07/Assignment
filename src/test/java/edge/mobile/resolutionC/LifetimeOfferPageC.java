package edge.mobile.resolutionC;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class LifetimeOfferPageC {
	
	public static WebDriver driver;
	
	@Test
	public void lifeTimeOfferPage() {
		driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(375, 667));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.getcalley.com/calley-lifetime-offer-expired/");
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replace(":", "-");
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("lifetimeoffer_mob_edgeC " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
