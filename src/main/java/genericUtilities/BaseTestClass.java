package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTestClass {

	public webdriverUtils wLib=new webdriverUtils();
	public FileUtils fLib=new FileUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeClass
	public void confg_BC() throws Throwable
	{
//		driver=new ChromeDriver();
//		sdriver=driver;
//		driver.manage().window().maximize();
//		driver.get(fLib.readDataFromPropertyFile("url"));
//		wLib.waitForPageLoad(driver, 20);
		System.out.println("launched the browser");
		
	}
	
	@AfterClass
	public void confg_AC()
	{
		driver.quit();
		System.out.println("browser closed");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
