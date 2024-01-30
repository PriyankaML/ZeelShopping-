package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCategorypage {

	//declaration
	@FindAll({@FindBy(xpath = "//input[@name='category']"),@FindBy(xpath="//input[@class='span8 tip']")})
	private WebElement categoryNameEdt;
	
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement catgDescriptionEdt;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement createBtn;
	
	
	//initialization
	public createCategorypage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCategoryNameEdt() {
		return categoryNameEdt;
	}


	public WebElement getCatgDescriptionEdt() {
		return catgDescriptionEdt;
	}


	public WebElement getCreateBtn() {
		return createBtn;
	}
	
	
	//Business library
	
	public void createCategory(String catgName)
	{
		categoryNameEdt.sendKeys(catgName);
		createBtn.click();
	}
	
	
}
