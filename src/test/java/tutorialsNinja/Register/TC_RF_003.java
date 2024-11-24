package tutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_003 {

	
		@Test
		public void verifyRegisteringWithAllFields() {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-firstname")).sendKeys("Ram");
			driver.findElement(By.id("input-lastname")).sendKeys("Baghel");
			driver.findElement(By.id("input-email")).sendKeys("rambaghel4@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys("7897896543");
			driver.findElement(By.id("input-password")).sendKeys("98765");
			driver.findElement(By.id("input-confirm")).sendKeys("98765");
			driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
			driver.findElement(By.xpath("//input[@name='agree'][@value=1]")).click();
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
			
			String ExpproperDetail1 = "Your Account Has Been Created!";
			String ExpproperDetail2 = "Congratulations! Your new account has been successfully created!";
			String ExpproperDetail3 = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
			String ExpproperDetail4 = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
			String ExpproperDetail5 = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please";
			String ExpproperDetail6 = "Continue";
			
			String ActProperDetail =driver.findElement(By.id("content")).getText();
			
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail1));
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail2));
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail3));
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail4));
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail5));
			Assert.assertTrue(ActProperDetail.contains(ExpproperDetail6));
			
			driver.findElement(By.linkText("Continue")).click();
			
			String expString = driver.findElement(By.linkText("Edit your account information")).getText();
			//Edit your account information
			Assert.assertEquals(expString, "Edit your account information");
			driver.quit();
			
			
		}

	}


