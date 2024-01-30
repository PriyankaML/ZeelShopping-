package genericUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class baseClassTestNgclass {
	WebDriver driver;
	
	@BeforeSuite
	public void config_BS() throws Throwable
	{

	Reporter.log("DB connected",true);     //to print the stmt in both console and emailable report
	
	}
	
	//launching the browser
	@BeforeClass
	public void config_BC() throws Throwable
	{
		
		System.out.println("launched the browser");
		
	}
	
	@AfterClass
	public void config_AC()
	{
		driver.quit();
		System.out.println("closed the browser");
	}

}
