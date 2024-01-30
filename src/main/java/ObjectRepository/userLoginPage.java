package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userLoginPage {

	//declaration
		@FindBy(id="exampleInputEmail1")
		private WebElement userNameEdt;
		
		@FindBy(id="exampleInputPassword1")
		private WebElement passwordEdt;
		
		@FindBy(xpath = "//button[@name='login']")
		private WebElement loginBtn;
		
		//initialization
		public userLoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Utilization
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//buisness library
		public void loginToApplication(String USERNAME, String PASSWORD) {
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
		}
		
}
