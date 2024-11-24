package tutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_004 {

	@Test
	public void verifyProperNotificationmsg() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String expFirstNameWarn = "First Name must be between 1 and 32 characters!";
		String explastNameWarn = "Last Name must be between 1 and 32 characters!";
		String expEmailwarn = "E-Mail Address does not appear to be valid!";
		String exptelephoneWarn= "Telephone must be between 3 and 32 characters!";
		String expPasswordWarn = "Password must be between 4 and 20 characters!";
		
		String actFirstName = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(actFirstName, expFirstNameWarn);
		String actLastNamewarn = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(actLastNamewarn, explastNameWarn);
		String actEmailWarn=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(actEmailWarn, expEmailwarn);
		String actTelephonearn = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(actTelephonearn, exptelephoneWarn);
		String actPasswordWarn = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(actPasswordWarn, expPasswordWarn);
		
		driver.quit();
		
	
	}
}
