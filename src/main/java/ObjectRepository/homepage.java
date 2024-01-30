package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {

	//declaration
	@FindBy(xpath = "//a[@href=\"my-account.php\"]")
	private WebElement myAccountLnk;
	
	@FindBy(xpath = "//a[@href=\"my-wishlist.php\"]")
	private WebElement wishListLnk;
	
	@FindBy(xpath = "//a[@href=\"my-cart.php\"]")
	private WebElement myCartLnk;
	
	//@FindAll({@FindBy(xpath = "//a[@href='login.php']"), @FindBy(xpath = "//a[.='Login']")} )
	@FindBy(xpath = "//a[@href='login.php']")
	private WebElement loginLnk;
	
	@FindBy(xpath = "//input[@class=\"search-field\"]")
	private WebElement searchTxt;
	
	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@href=\"track-orders.php\"]")
	private WebElement trackOrderLnk;
	
	@FindBy(xpath = "//div[@class='total-price-basket']")
	private WebElement cartTxt;
	
	@FindBy(xpath = "//a[@href=\"logout.php\"]")
	private WebElement logoutLnk;
	
	
	//initialization
			public homepage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
		
	//utilization
	
	public WebElement getMyAccountLnk() {
		return myAccountLnk;
	}


	public WebElement getWishListLnk() {
		return wishListLnk;
	}


	public WebElement getMyCartLnk() {
		return myCartLnk;
	}


	public WebElement getLoginLnk() {
		return loginLnk;
	}


	public WebElement getSearchTxt() {
		return searchTxt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getTrackOrderLnk() {
		return trackOrderLnk;
	}


	public WebElement getCartTxt() {
		return cartTxt;
	}


	public WebElement getLogoutLnk() {
		return logoutLnk;
	}

//buisness library
	public void login()
	{
		loginLnk.click();
	}
	
	public void logoutFromApp()
	{
		logoutLnk.click();
	}
	
	
	public void addProduct(String prodName, WebDriver driver)
	{
		searchTxt.sendKeys(prodName);
		searchBtn.click();
		driver.findElement(By.xpath("//img[@src='admin/productimages/2/apple-iphone-6-1.jpeg']")).click();
		driver.findElement(By.xpath("//a[@data-original-title='Wishlist']")).click();
		driver.findElement(By.xpath("//tbody/tr/td[@class='col-md-2']/a[@href='my-wishlist.php?page=product&action=add&id=2']")).click();
		myCartLnk.click();
		String cartConfrm = driver.findElement(By.xpath("//tbody/tr/td[@class='cart-product-name-info']//h4/a")).getText();
		if (cartConfrm.contains("Apple iPhone 6")) {
			System.out.println("product added from wishlist to cart");
			
		}
		
	}
	
	
}
