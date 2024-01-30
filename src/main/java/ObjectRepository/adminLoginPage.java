package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminLoginPage {

	
	//declaration
	@FindBy(xpath = "//input[@id='inputEmail']")
	private WebElement adminUserNameEdt;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement adminPasswordEdt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement loginBtn;
	
	
	//initialization
	public adminLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getAdminUserNameEdt() {
		return adminUserNameEdt;
	}

	public WebElement getAdminPasswordEdt() {
		return adminPasswordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	public void adminLogin(String ADMINUSERNAME, String ADMINPASSWORD)
	{
		adminUserNameEdt.sendKeys(ADMINUSERNAME);
		adminPasswordEdt.sendKeys(ADMINPASSWORD);
		loginBtn.click();
	}
	
}
