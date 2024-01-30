package practiceTestNg;

import org.testng.annotations.Test;

public class sundayTest {
	
	@Test(groups= {"smoke","regression"})
	public void sundayTest()
	{
		System.out.println("today is sunday");
	
	}
	
	@Test(groups = "smoke")
	public void saturdaySundayTest()
	{
		System.out.println("today is saturday and sunday");
	}

}
