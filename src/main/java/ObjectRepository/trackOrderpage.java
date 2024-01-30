package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class trackOrderpage {

	//declaration
	@FindBy(xpath = "//input[@id='exampleOrderId1']")
	private WebElement orderIdEdt;
	
	@FindBy(xpath = "//input[@id='exampleBillingEmail1']")
	private WebElement registerEmailIdEdt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement trackBtn;
	
	
	//initialization'
	public trackOrderpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrderIdEdt() {
		return orderIdEdt;
	}


	public WebElement getRegisterEmailIdEdt() {
		return registerEmailIdEdt;
	}


	public WebElement getTrackBtn() {
		return trackBtn;
	}
	
	public void trackUserOrder(String orderId,String USERNAME )
	{
		orderIdEdt.sendKeys(orderId);
		registerEmailIdEdt.sendKeys(USERNAME);
		trackBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
