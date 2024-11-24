package tutorialsNinja.Register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_005 {
	
	@Test
	public void verifyNewsletterOptions() {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.manage().window().maximize();
	driver.get("https://tutorialsninja.com/demo/");
	
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.xpath("//a[text()='Register']")).click();
	
	driver.findElement(By.id("input-firstname")).sendKeys("Saty");
	driver.findElement(By.id("input-lastname")).sendKeys("Kumar");
	driver.findElement(By.id("input-email")).sendKeys("Saty"+generateNewEmail());
	driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
	driver.findElement(By.id("input-password")).sendKeys("54321");
	driver.findElement(By.id("input-confirm")).sendKeys("54321");
	
	driver.findElement(By.xpath("//input[@name='agree']")).click();
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	//Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
	//Assert.assertTrue(driver.findElement(By.linkText("Account")).isDisplayed());
	
	driver.findElement(By.xpath("//a[text()='Continue']")).click();
	driver.findElement(By.xpath("//a[text()='Subscribe / unsubscribe to newsletter']")).click();
	
	Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
	driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
	Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).isSelected());
	
    //driver.close();
	
	
	
	
}

public  String generateNewEmail() {
	Date date = new Date();
	String dateString = date.toString();
	String datewithnospace = dateString.replaceAll("\\s", "");
	String datewithnospaceandColon = datewithnospace.replaceAll("\\:", "")+"@gmail.com";
	return datewithnospaceandColon;
}
}
