package parallel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseTestClass;
import genericUtilities.baseClassTestNgclass;

public class flikartTest extends baseClassTestNgclass{
	@Test
	public void flipkartTest()
	{
	WebDriver driver=new ChromeDriver();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("tv");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[.='Mi A series 80 cm (32 inch) HD Ready LED Smart Google TV 2023 Edition with HD |Dolby Audio | DTS:HD | ...']")).click();
		//driver.findElement(By.xpath("//button[@type='button']")).click();	
	}
}
