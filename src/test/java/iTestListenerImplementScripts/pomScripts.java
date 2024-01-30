package iTestListenerImplementScripts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseTestClass;

@Listeners(genericUtilities.listnerImplementclass.class)
public class pomScripts extends BaseTestClass {

	@Test()
	public void test() throws Throwable

	{

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Online_Shopping_Application/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fip);

		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
		Assert.fail();
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='login']")).click();

	}

	

}
