package practiceTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sampleDataProvider {

	@Test(dataProvider = "bookTicketTest()")
	public void sampleDataTest(String src, String dest, int ticket )
	{
		System.out.println("book tickets from =>"+src+" to"+dest);
	}
	
	
	@DataProvider
	public Object[][] bookTicketTest() {
		
		Object[][] obj=new Object[5][3];
		
		obj[0][0]="Surat";
		obj[0][1]="delhi";
		obj[0][2]=10;
		
		obj[1][0]="Sultanpur";
		obj[1][1]="vadodhara";
		obj[1][2]=15;
		
		obj[2][0]="rampur";
		obj[2][1]="dehradon";
		obj[2][2]=30;
		
		obj[3][0]="mysore";
		obj[3][1]="Bangalore";
		obj[3][2]=20;
		
		
		obj[4][0]="Belagavi";
		obj[4][1]="Maharashtra";
		obj[4][2]=40;
		
		return obj;
		
	}
	
}
