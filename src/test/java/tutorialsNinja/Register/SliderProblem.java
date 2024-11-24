package tutorialsNinja.Register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderProblem {
	

	public static void main(String[] args) throws InterruptedException {
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.fitpeo.com/");
		driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
		Thread.sleep(5000);
		
		Actions actions = new Actions(driver);
		//Scrolling page towords slider
		actions.scrollByAmount(0, 450).perform();
		
		Thread.sleep(3000);
		//move slider to 820 value
		WebElement slider = driver.findElement(By.xpath("//div[@class='MuiBox-root css-j7qwjs']/span[1]"));
		actions.clickAndHold(slider)
		.moveByOffset(-26, 0).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT)
		.release().perform();
		
		WebElement textBox = driver.findElement(By.xpath("//input[contains(@class, 'MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmal')]"));
		
		  String valueOfTextBox = textBox.getAttribute("value");
		  System.out.println("Text Box value: "+valueOfTextBox);
            if(valueOfTextBox.equals("820")) {
            	System.out.println("Test Case Passed");
            }
            else {
            	System.out.println("Test Case Failled");
            }
            Thread.sleep(4000);
            
            //update value in textbox by entering value & reflect on the slider position
            actions.clickAndHold(slider)
    		.moveByOffset(-163, 0)
    		.release().perform();
            
            textBox.sendKeys(Keys.BACK_SPACE);
              textBox.sendKeys("560");
              
              String UpdatedvalueOfTextBox = textBox.getAttribute("value");
    		  System.out.println("Updated Text Box value: "+UpdatedvalueOfTextBox);
    		  //scroll webpage towards checkbox
    		  actions.scrollByAmount(0, 802).perform();
               // check given checkbox
    		 driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]/input")).click();//99091
    		  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/label/span[1]/input")).click();//99453
    		  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/label/span[1]/input")).click();//99454
    		  driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[8]/label/span[1]/input")).click();//99474
    		  
    		  System.out.println("All Given checkbox are checked");
    		  Thread.sleep(4000);
    		  //find Total recurring reimbersement value
		  String actualTotalReimbersement = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/p[4]/p")).getText();
		  String expectedTotalReimbursement = "$75600";
		  Thread.sleep(4000);
		  if(actualTotalReimbersement.equals(expectedTotalReimbursement)) {
			  System.out.println("Total Recuring reimbersement is Matches: "+actualTotalReimbersement);
		  }
		  else System.out.println("Total Recuring reimbersement is not Matches ");
		 Thread.sleep(5000);
		 
		 driver.quit();
		 
		 
		 
		 
		 
		 
		

	}
	}


