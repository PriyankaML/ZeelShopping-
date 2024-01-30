package parallel;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.baseClassTestNgclass;

public class superTest extends baseClassTestNgclass{

	@Test
	public void amazonTest()
	{
		WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
		
	}
	
	
	}
