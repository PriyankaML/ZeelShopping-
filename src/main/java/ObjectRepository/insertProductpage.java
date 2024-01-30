package ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.FileUtils;
import genericUtilities.webdriverUtils;

public class insertProductpage extends webdriverUtils{

	//declaration
	@FindBy(xpath = "//select[@name='category']")
	private WebElement categoryNameEdit;
	
	@FindBy(xpath = "//select[@name='subcategory']")
	private WebElement subCategoryNameEdt;
	
	@FindBy(xpath = "//select[@name='productAvailability']")
	private WebElement productAvailabilitydd;
	
	@FindBy(xpath = "//input[@name='productimage1']")
	private WebElement productImage1;
	
	@FindBy(xpath = "//input[@name='productimage2']")
	private WebElement productImg2;
	
	@FindBy(xpath = "//input[@name='productimage3']")
	private WebElement productImg3;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement insertBtn;
	
	@FindBy(xpath = "//div[@class=\"alert alert-success\"]")
	private WebElement productConfrmMsgTxt;
	
	public WebElement getProductConfrmMsgTxt() {
		return productConfrmMsgTxt;
	}

	//initialization
	public insertProductpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

    //utilization
	public WebElement getCategoryNameEdit() {
		return categoryNameEdit;
	}


	public WebElement getSubCategoryNameEdt() {
		return subCategoryNameEdt;
	}

	public WebElement getProductAvailabilitydd() {
		return productAvailabilitydd;
	}


	public WebElement getProductImage1() {
		return productImage1;
	}


	public WebElement getProductImg2() {
		return productImg2;
	}


	public WebElement getProductImg3() {
		return productImg3;
	}

	public WebElement getInsertBtn() {
		return insertBtn;
	}
	
	public void insertProduct(String catgName,String subCtgName,HashMap<String, String> map,String stock,WebDriver driver) throws Throwable
	{
		webdriverUtils wLib=new webdriverUtils();
		FileUtils fLib=new FileUtils();
		//categoryNameEdit.click();
		wLib.select(categoryNameEdit,  catgName);
		//subCategoryNameEdt.click();
		wLib.select(subCategoryNameEdt, subCtgName);
		   //fLib.hashMapData(SheetName, cell);
			for ( Entry<String, String> set : map.entrySet()) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			//productAvailabilitydd.click();
			wLib.selectByVisibleText(productAvailabilitydd, stock);
			productImage1.sendKeys("G:\\project automation workspace\\001\\src\\test\\resources\\prodImg.jpg");
			productImg2.sendKeys("G:\\project automation workspace\\001\\src\\test\\resources\\prodImg.jpg");
			productImg3.sendKeys("G:\\project automation workspace\\001\\src\\test\\resources\\prodImg.jpg");
			insertBtn.click();
			
			
			String prdMsg = productConfrmMsgTxt.getText();
			if (prdMsg.contains("Successfully ")) {
				System.out.println("product added");
				
			}
			
			
			
	}
	
}
