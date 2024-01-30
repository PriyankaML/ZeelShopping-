package userModule;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.homepage;
import genericUtilities.BaseClass;
import genericUtilities.BaseTestClass;

public class moveProductFromWishlistToMyCartTest extends BaseTestClass{

	@Test
//	public void movePrdFrmWishlist() throws Throwable {

		public void movePrdFromWishlistToCart() throws Throwable{
			
		
//		FileUtils fLib = new FileUtils();
//		webdriverUtils wLib=new webdriverUtils();
		
		
		//get the data from property file
//		String URL = fLib.readDataFromPropertyFile("url");
//		String USERNAME =fLib.readDataFromPropertyFile("username");
//		String PASSWORD =fLib.readDataFromPropertyFile("password");

		//		FileInputStream fip = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties pobj = new Properties();
//		pobj.load(fip);
//
//		String URL = pobj.getProperty("url");
//		String USERNAME = pobj.getProperty("username");
//		String PASSWORD = pobj.getProperty("password");
		
		
		//get data from excel file
		String prodName =fLib.readSingleDataFromExcel("wishList", 0, 0);
//		FileInputStream fixl = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fixl);
//		String prodName = wb.getSheet("wishList").getRow(0).getCell(0).getStringCellValue();


//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		driver.get(URL);
//		Thread.sleep(5000);
//		wLib.waitForPageLoad(driver, 20);	

        //login to application
		homepage hp=new homepage(driver);
//	    hp.login();
//		loginpage lp=new loginpage(driver);
//		lp.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.xpath("//a[@href='login.php']")).click();
//		driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
//		driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
//		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		//search for product and add to wishlist and then add to cart
		
		hp.addProduct(prodName, driver);
		
//		driver.findElement(By.xpath("//input[@class='search-field']")).sendKeys(prodName);
//		driver.findElement(By.xpath("//button[@class='search-button']")).click();
//		driver.findElement(By.xpath("//img[@src='admin/productimages/2/apple-iphone-6-1.jpeg']")).click();
//		driver.findElement(By.xpath("//a[@data-original-title='Wishlist']")).click();
//		driver.findElement(By.xpath("//tbody/tr/td[@class='col-md-2']/a[@href='my-wishlist.php?page=product&action=add&id=2']")).click();
//		
//		//click on my cart
//		driver.findElement(By.xpath("//a[@href='my-cart.php']")).click();
//		
//		//validation
//		String cartConfrm = driver.findElement(By.xpath("//tbody/tr/td[@class='cart-product-name-info']//h4/a")).getText();
//		if (cartConfrm.contains("Apple iPhone 6")) {
//			System.out.println("product added from wishlist to cart");
//			
//		}
//		
		//logout
	 // hp.logoutFromApp();
		
		//driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		
	}

}
