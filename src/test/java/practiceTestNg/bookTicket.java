package practiceTestNg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class bookTicket {
	
	@Test(dataProvider ="dataProviderTest")
	public void bookTicketTest(String src, String dest)
	{
		System.out.println("book ticket from "+src+" to"+dest);
	}
	
	
	@DataProvider
	public Object[][] dataProviderTest()
	{
		Object[][] obj=new Object[5][2];
		
		obj[0][0]="Bangalore";
		obj[0][1]="Pune";
		
		obj[1][0]="Delhi";
		obj[1][1]="Ayodhya";
		
		obj[2][0]="Belagavi";
		obj[2][1]="delhi";
		
		obj[3][0]="Bagalkot";
		obj[3][1]="Mysore";
		
		obj[4][0]="Indore";
		obj[4][1]="WestBengal";
		
		return obj;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
