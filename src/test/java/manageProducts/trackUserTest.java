package manageProducts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class trackUserTest {

	public static void main(String[] args) throws Throwable {

		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fip);
		String URL = pobj.getProperty("url");
		Random ran=new Random();
		int ranNum = ran.nextInt(200);
		
		
		FileInputStream fisxl = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fisxl);
		Sheet sh = wb.getSheet("MyAccount");
		String newUserName = sh.getRow(0).getCell(0).getStringCellValue();
		String newPassword = sh.getRow(1).getCell(0).getStringCellValue();
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.findElement(By.xpath("//a[@href='login.php']")).click();
		
		//login to the application
		driver.findElement(By.xpath("//input[@id='exampleInputEmail1']")).sendKeys(newUserName);
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys(newPassword);
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//search for product
		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys("lenovo");
		driver.findElement(By.xpath("//button[@class='search-button']")).click();
		
		driver.findElement(By.xpath("//a[.='Lenovo Ideapad 110 APU Quad Core A6 6th Gen']/ancestor::div[@class=\"product\"]//button[@class=\"btn btn-primary\"]")).click();
		
		driver.switchTo().alert().accept();
		
	/*	HashMap<String, String> billmap = new HashMap<String,String>();
		Sheet Billingaddress = wb.getSheet("Billingaddress");
		int lastRow = Billingaddress.getLastRowNum();
		for (int i = 0; i <lastRow; i++) {
		String key1 = Billingaddress.getRow(i).getCell(0).getStringCellValue();
		String value1 = Billingaddress.getRow(i).getCell(1).getStringCellValue();
		System.out.println(key1);
		System.out.println(value1);
		billmap.put(key1, value1);	
		}
		
		for ( Entry<String, String> set : billmap.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			driver.findElement(By.xpath("//button[@name='update']")).click();
		}
		*/
		
		HashMap<String, String> billmap = new HashMap<String,String>();
		Sheet Billingaddress = wb.getSheet("BillingAddress");
		int lastRowcount = Billingaddress.getLastRowNum();
		for (int i = 0; i <=lastRowcount; i++) 
		{
		String key1 = Billingaddress.getRow(i).getCell(0).getStringCellValue();
		String value1 = Billingaddress.getRow(i).getCell(1).getStringCellValue();
		billmap.put(key1, value1);	
		}
		
		for ( Entry<String, String> set1 : billmap.entrySet()) {
			driver.findElement(By.name(set1.getKey()+ranNum)).sendKeys(set1.getValue()+ranNum);
			driver.findElement(By.xpath("//button[@name='update']")).click();
		}
		
		HashMap<String, String> shipmap = new HashMap<String,String>();
		Sheet shippingaddress = wb.getSheet("ShippingAddress");
		int Rowcount = shippingaddress.getLastRowNum();
		for (int i = 0; i <=Rowcount; i++) {
			String key2 = shippingaddress.getRow(i).getCell(0).getStringCellValue();
		String value2 = shippingaddress.getRow(i).getCell(1).getStringCellValue();
		shipmap.put(key2, value2);	
		}
		
		for ( Entry<String, String> set1 : shipmap.entrySet()) {
			driver.findElement(By.name(set1.getKey()+ranNum)).sendKeys(set1.getValue()+ranNum);
			driver.findElement(By.xpath("//button[@name='shipupdate']")).click();
	}
	
//		
//		for ( Entry<String, String> set1 : shipmap.entrySet()) {
//			driver.findElement(By.name(set1.getKey())).sendKeys(set1.getValue());
//			driver.findElement(By.xpath("//button[@name='shipupdate']")).click();
	//	}
		driver.findElement(By.xpath("//button[.='PROCCED TO CHEKOUT']")).click();
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
	
		
	}
	
	
}
	
