package adminModule;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.adminHomePage;
import ObjectRepository.adminLoginPage;
import ObjectRepository.manageProductspage;
import genericUtilities.FileUtils;
import genericUtilities.webdriverUtils;

public class manageProduct {

	@Test
	public void manageProductTest() throws Throwable
	{
		
		//get data from property file
		FileUtils fLib = new FileUtils();
		webdriverUtils wLib=new webdriverUtils();
		String ADMINURL =fLib.readDataFromPropertyFile("adminurl");
		String ADMINUSERNAME=fLib.readDataFromPropertyFile("adminusername");
		String ADMINPASSWORD =fLib.readDataFromPropertyFile("adminpassword");
		
//		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties pobj = new Properties();
//		pobj.load(fip);
//		String ADMINURL = pobj.getProperty("adminurl");
//		String ADMINUN = pobj.getProperty("adminusername");
//		String ADMINPWD = pobj.getProperty("adminpassword");
		
//		FileInputStream fixl = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fixl);
		
	
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		driver.get(ADMINURL);
		Thread.sleep(5000);
		wLib.waitForPageLoad(driver, 20);
		
//		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
//		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
//		driver.findElement(By.name("submit")).cl;
		
		adminLoginPage alp=new adminLoginPage(driver);
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
		adminHomePage ahp=new adminHomePage(driver);
		ahp.clickManageProducts();
		
		
		//driver.findElement(By.xpath("//a[@href='manage-products.php']")).click();
		
		//validating
		manageProductspage mpp=new manageProductspage(driver);
		mpp.manageProductsSmoketest(driver);
		
//		Set<String> windows = driver.getWindowHandles();
//		Iterator<String> it = windows.iterator();
//		while (it.hasNext()) {
//			String win = it.next();
//			String title = driver.switchTo().window(win).getTitle();
//			System.out.println(title);
//			if (title.contains("Products")) 
//			{
//				System.out.println("Manage product page is loaded");
//				break;	
//			}
//		}
//		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//		WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));
//		wLib.clickOnElement(driver, logout);
		
		ahp.clickLogout(driver);
		


	}

}
