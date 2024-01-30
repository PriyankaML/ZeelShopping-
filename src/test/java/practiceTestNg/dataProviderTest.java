package practiceTestNg;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import genericUtilities.FileUtils;

public class dataProviderTest {

	@DataProvider
	public Object[][] demo() throws Throwable
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Billingaddress");
		int lastrow = sh.getLastRowNum()+1;     //its taking from index 0 so adding +1
	int lastCell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[lastrow][lastCell];
	
	for (int i = 0; i < lastrow; i++) {
		for (int j = 0; j < lastCell; j++) {
			
			obj[i][j]  = sh.getRow(i).getCell(j).getStringCellValue();	
		}
	}
	return obj;
		
	}

	@DataProvider
	public Object[][] readDataExcelGeneric() throws Throwable {
		FileUtils fLib=new FileUtils();
		Object[][] result = fLib.readMultipleDataFromExcel("Billingaddress");
		return result;
	}
}