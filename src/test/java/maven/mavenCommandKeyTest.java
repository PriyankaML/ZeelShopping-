package maven;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class mavenCommandKeyTest {

@Test
public void comandPropertTest() throws Throwable
{
	String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("url");
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");

	WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(URL);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    driver.findElement(By.xpath("//a[@href='login.php']")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
    driver.findElement(By.name("login")).click();
	
	
}

}
