package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminHomePage {

	//declaration
	@FindBy(xpath ="//a[@class=\"collapsed\"]")
	private WebElement orderManagementLnk;
	
	@FindBy(xpath = "//a/i[@class='menu-icon icon-group']")
	private WebElement manageUsersLnk;
	
	@FindBy(xpath = "//a[.=' Create Category ']")
	private WebElement createCategoryLnk;
	
	@FindBy(xpath = "//a[.='Sub Category ']")
	private WebElement subCategoryLnk;
	
	@FindBy(xpath = "//a[.='Insert Product ']")
	private  WebElement insertProductLnk;
	
	@FindBy(xpath = "//a[.='Manage Products ']")
	private WebElement manageProductsLnk;
	
	@FindBy(xpath = "//a[.='User Login Log ']")
	private WebElement userLoginLogLnk;
	
	@FindBy(xpath = "//a/i[@class='menu-icon icon-signout']")
	private WebElement adminLogOutLnk;
	
	@FindBy(xpath = "//span[.='You have successfully logout']")
	private WebElement logOutTxt;
	
	
	//initialization
	public adminHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrderManagementLnk() {
		return orderManagementLnk;
	}
	
	public WebElement getLogOutTxt() {
		return logOutTxt;
	}


	public WebElement getManageUsersLnk() {
		return manageUsersLnk;
	}

	public WebElement getCreateCategoryLnk() {
		return createCategoryLnk;
	}

	public WebElement getSubCategoryLnk() {
		return subCategoryLnk;
	}

	public WebElement getInsertProductLnk() {
		return insertProductLnk;
	}

	public WebElement getManageProductsLnk() {
		return manageProductsLnk;
	}

	public WebElement getUserLoginLogLnk() {
		return userLoginLogLnk;
	}

	public WebElement getAdminLogOutLnk() {
		return adminLogOutLnk;
	}
	
	//Business library
	public void clickCreateCategory() {
		createCategoryLnk.click();
	}

	public void clickCreateSubCategory() {
		subCategoryLnk.click();
	}
	
	public void clickInsertProduct() {
		insertProductLnk.click();
	}
	
	public void clickManageProducts() {
		manageProductsLnk.click();
	}
	
	public void clickUserLoginLog() {
		userLoginLogLnk.click();
	}
	
	public void clickLogout(WebDriver driver) {
		adminLogOutLnk.click();
		String logOutverf = driver.findElement(By.xpath("//span[.='You have successfully logout']")).getText();
		if (logOutverf.contains("logout")) {
			System.out.println("successfully logged out");
		}
		
			
		}
	}

