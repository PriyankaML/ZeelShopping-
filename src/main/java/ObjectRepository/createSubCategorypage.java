package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webdriverUtils;

public class createSubCategorypage {

	//declaration
	@FindBy(xpath = "//select[@class='span8 tip']")
	private WebElement categoryEdt;
	
	@FindBy(xpath = "//input[@name='subcategory']")
	private WebElement subCategoryNameEdt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement createBtn;
	
	//initialization
	public createSubCategorypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    
	//utilization
	public WebElement getCategoryEdt() {
		return categoryEdt;
	}

	public WebElement getSubCategoryNameEdt() {
		return subCategoryNameEdt;
	}

	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	public void createSubCategory(String text, String SubCatgName )
	{
		webdriverUtils wLib=new webdriverUtils();
		
		//categoryEdt.click();
		//wLib.select(categoryEdt, text);
		wLib.selectByVisibleText(categoryEdt, text);
		subCategoryNameEdt.click();
		subCategoryNameEdt.sendKeys(SubCatgName);
		createBtn.click();
	}
	
	
}
