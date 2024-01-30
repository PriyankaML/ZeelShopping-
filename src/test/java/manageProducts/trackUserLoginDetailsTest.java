package manageProducts;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trackUserLoginDetailsTest {

	public static void main(String[] args) throws Throwable {
		
		//login as user
		
		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fip);

		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));	
		
		//creating the user account
		driver.findElement(By.xpath("//a[@href='my-account.php']")).click();
		

		
		//login to application
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		Thread.sleep(3000);
		//click on logout
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
		//login as admin
			
		String ADMINURL = pobj.getProperty("adminurl");
		String ADMINUN = pobj.getProperty("adminusername");
		String ADMINPWD = pobj.getProperty("adminpassword");
		
		FileInputStream fixl = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fixl);
		String User = wb.getSheet("userLoginLog").getRow(0).getCell(0).getStringCellValue();

		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get(ADMINURL);
		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUN);
		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPWD);
		driver.findElement(By.name("submit")).click();
		
		//click on userLoginLog link
		driver.findElement(By.xpath("//a[@href='user-logs.php']")).click();
		
		driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(User);
		
		
	}

}
