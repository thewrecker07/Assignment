package edge.mobile.resolutionB;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

public class TeamFeatures {
	
	public static WebDriver driver;
	
	@Test
	public void teamFeatures() {
		driver = new EdgeDriver();
		driver.manage().window().setSize(new Dimension(414, 896));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.getcalley.com/calley-teams-features/");
		
		Date currentDate = new Date();
		String date = currentDate.toString().replace(" ", "-").replace(":", "-");
		Shutterbug.shootPage(driver, Capture.FULL, true).withName("teamFeatures_mob_edgeB " + date).save();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
