package ObjectRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webdriverUtils;

public class manageProductspage {

	//declaration
	 @FindBy(xpath = "//input[@type='text']")
	 private WebElement searchTxt;
	 
	 @FindBy(xpath = "//div[@class='alert alert-error']")
	 private WebElement deleteVerification;
	 
	 @FindBy(xpath = "//i[@class='icon-remove-sign']")
	 private WebElement deleteBtn;
	 
	
	//initialization
	 public manageProductspage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	
	 //utilization
	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	public WebElement getDeleteVerification() {
			return deleteVerification;
	}
	
	public WebElement getDeleteBtn() {
		return deleteBtn;
	}
	 
	//business library
	public void searchProduct(String prodName, WebDriver driver)
	{
		webdriverUtils wLib=new webdriverUtils();
		searchTxt.sendKeys(prodName);
		driver.findElement(By.xpath("//td[.='"+prodName+"']")).click();
		deleteBtn.click();
		
//		String deleteConfrm = deleteVerification.getText();
//		if (deleteConfrm.contains("deleted")) {
//			System.out.println("product deleted");
//		}
//		wLib.acceptAlert(driver);
		
	}
	
	public void manageProductsSmoketest(WebDriver driver)
	{
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String win = it.next();
			String title = driver.switchTo().window(win).getTitle();
			System.out.println(title);
			if (title.contains("Products")) 
			{
				System.out.println("Manage product page is loaded");
				break;	
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
