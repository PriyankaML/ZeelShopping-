package practiceTestNg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class avedaTest {
public static void main(String[] args) {
	
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	
	
	Actions a=new Actions(driver);
	a.moveToElement(null);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}
