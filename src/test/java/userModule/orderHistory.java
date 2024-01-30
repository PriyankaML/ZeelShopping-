package userModule;


import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class orderHistory {

	@Test
		public void order() throws Throwable {
		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fip);

		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));	

		
		//login to application
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		   
		   driver.findElement(By.xpath("//a[@href='my-account.php']/i")).click();
		   driver.findElement(By.xpath("//a[.='Order History']")).click();
		   
		   Set<String> windows = driver.getWindowHandles();
		   Iterator<String> it = windows.iterator();
		   while (it.hasNext()) {
			   
			   String window = it.next();
			  String expected = "Order History";
			   String actual = driver.switchTo().window(window).getTitle();
			   Assert.assertEquals(actual, expected, "condition satisfies");
//			   if (Title.contains("History")) {
//				   System.out.println("order history page loaded");
//				   break;
//			
//			}
			System.out.println("validation done");
		}
		 //logout
			driver.findElement(By.xpath("//a[@href='logout.php']")).click();
			
		   
	}

}
