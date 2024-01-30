package pom_TestScripts;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ObjectRepository.adminHomePage;
import ObjectRepository.adminLoginPage;
import ObjectRepository.createCategorypage;
import ObjectRepository.createSubCategorypage;
import ObjectRepository.insertProductpage;
import ObjectRepository.manageProductspage;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.webdriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class deleteProdctScriptPomTest {
	public static void main(String[] args) throws Throwable {
		FileUtils fLib = new FileUtils();
	    JavaUtils jLib = new JavaUtils();
	    webdriverUtils wLib = new webdriverUtils();
	    
	    
		
	    //get common data from property file
	    String ADMINURL = fLib.readDataFromPropertyFile("adminurl");
	    String ADMINUSERNAME = fLib.readDataFromPropertyFile("adminusername");
		String ADMINPASSWORD = fLib.readDataFromPropertyFile("adminpassword");

//	    FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties pobj = new Properties();
//		pobj.load(fip);
//		String ADMINURL = pobj.getProperty("adminurl");
//		String ADMINUN = pobj.getProperty("adminusername");
//		String ADMINPWD = pobj.getProperty("adminpassword");
		
		//get testdata from excel file
		String catgName=fLib.readSingleDataFromExcel("createCategory", 0, 1);
		String Description=fLib.readSingleDataFromExcel("createCategory", 1, 1);
		
		String subCategryName=fLib.readSingleDataFromExcel("subCategory", 0, 1);
		String prodName =fLib.readSingleDataFromExcel("insertProduct", 0, 1);

		//		FileInputStream fixl = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fixl);
//		Sheet sh = wb.getSheet("createCategory");
//		int rowCount = sh.getLastRowNum();
//		String catgName = sh.getRow(0).getCell(1).getStringCellValue();
//		String Description = sh.getRow(1).getCell(1).getStringCellValue();
//		
//		Sheet sh1 = wb.getSheet("subCategory");
//		String subCategryName = sh1.getRow(0).getCell(1).getStringCellValue();
//		
//	    Sheet sh2 = wb.getSheet("insertProduct");
//	    int rowCount1 = sh2.getLastRowNum();
//	  String prodName = sh2.getRow(0).getCell(0).getStringCellValue();
//	  
		//launching the application
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		//driver.manage().window().maximize();
		driver.get(ADMINURL);
		Thread.sleep(5000);
		wLib.waitForPageLoad(driver, 20);
		
		//adminLogin
		adminLoginPage alp=new adminLoginPage(driver);
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
//		driver.findElement(By.id("inputEmail")).sendKeys(ADMINUSERNAME);
//		driver.findElement(By.id("inputPassword")).sendKeys(ADMINPASSWORD);
//		driver.findElement(By.name("submit")).click();
		
		//creating the category
		adminHomePage ahp = new adminHomePage(driver);
		ahp.clickCreateCategory();
		createCategorypage ccp=new createCategorypage(driver);
		ccp.createCategory(catgName);
		
//		driver.findElement(By.xpath("//a[text()=' Create Category ']")).click();
//		driver.findElement(By.name("category")).sendKeys(catgName);
//		driver.findElement(By.name("description")).sendKeys(Description);
//		driver.findElement(By.name("submit")).click();
		
		
		//creating the subcategory
		ahp.clickCreateSubCategory();
		createSubCategorypage cscp=new createSubCategorypage(driver);
		cscp.createSubCategory(catgName, subCategryName);
		Thread.sleep(3000);
		
		
//		driver.findElement(By.xpath("//a[text()='Sub Category ']")).click();
//		WebElement CatNamedd = driver.findElement(By.xpath("//select[@name='category']"));
//		wLib.select(CatNamedd, catgName);
		
//		Select sel=new Select(CatNamedd);
//		sel.selectByVisibleText(catgName);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@placeholder='Enter SubCategory Name']")).sendKeys(subCategryName);
//		driver.findElement(By.xpath("//button[.='Create']")).click();
		
		//inserting the product
		ahp.clickInsertProduct();
		insertProductpage ipp=new insertProductpage(driver);
		//HashMap<String, String> map = null;
		ipp.insertProduct(catgName, subCategryName, fLib.hashMapData("insertProduct", 0), "In Stock", driver);
	//	ipp.insertProduct(catgName, subCategryName, "insertProduct", 0, driver, fLib.hashMapData("insertProduct", 0), 1);
//		ipp.insertProduct(catgName, subCategryName, null, catgName, 0, 0, driver, null, Description, subCategryName, prodName, 0);
//		
//		driver.findElement(By.xpath("//a[@href='insert-product.php']")).click();
//		
//		
//		
//       HashMap<String,String> map=fLib.hashMapData("insertProduct", 0) ;   //empty map
////	for (int i = 0; i <=rowCount1; i++) {
////		
////		String key = sh2.getRow(i).getCell(0).getStringCellValue();
////		String value = sh2.getRow(i).getCell(1).getStringCellValue();
////		map.put(key, value);
////	}
//	for ( Entry<String, String> set : map.entrySet()) {
//		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
//	}
//	
//	
//	WebElement categorydd = driver.findElement(By.xpath("//select[@name='category']"));
//	wLib.select(categorydd, catgName);
//	
////	Select selectCategory = new Select(categorydd);
////	selectCategory.selectByVisibleText(catgName);
//	
//	WebElement subCategorydd = driver.findElement(By.xpath("//select[@id='subcategory']"));
//	wLib.select(subCategorydd, subCategryName);
////	Select selectSubCategory = new Select(subCategorydd);
////	selectSubCategory.selectByVisibleText(subCategryName);
//	
//	
//	
//	WebElement prodAvaildd = driver.findElement(By.xpath("//select[@name='productAvailability']"));
//	wLib.select(prodAvaildd, 1);
////	Select selectProdAvail = new Select(prodAvaildd);
////	selectProdAvail.selectByIndex(1);
//	
//	driver.findElement(By.xpath("//input[@id='productimage1']")).sendKeys("C:\\Users\\HP\\Desktop\\prodImg.jpg");
//	driver.findElement(By.xpath("//input[@name='productimage2']")).sendKeys("C:\\Users\\HP\\Desktop\\prodImg.jpg");
//	driver.findElement(By.xpath("//input[@name='productimage3']")).sendKeys("C:\\Users\\HP\\Desktop\\prodImg.jpg");
//	driver.findElement(By.xpath("//button[@name='submit']")).click();
	
//	//validation
//	String prodConfrm = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
//	
//	if(prodConfrm.contains("Successfully "))
//	{
//		System.out.println("product added");
//	}
//		
	//clicks on manage products
		ahp.clickManageProducts();
	manageProductspage mpp=new manageProductspage(driver);
	mpp.searchProduct(prodName, driver);
	driver.switchTo().alert().accept();
	
		
//	driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
//	driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']")).sendKeys(prodName);
//	driver.findElement(By.xpath("//i[@class='icon-remove-sign']")).click();
	
	
//	
//	//validation
//	String deleteConfrm = driver.findElement(By.xpath("//div[@class='alert alert-error']")).getText();
//	if (deleteConfrm.contains("deleted")) {
//		System.out.println("product deleted");}
//		
	
	
	//logout
	ahp.clickLogout(driver);
	
	
	
//	driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
//	WebElement logout = driver.findElement(By.xpath("//a[.='Logout']"));
//	wLib.clickOnElement(driver, logout);
//	Actions a=new Actions(driver);
//	a.moveToElement(logout).click().perform();
	}

}
