package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userLoginLogpage {

	//declaration
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchTxt;
	
	//initialization
	public userLoginLogpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	
}
