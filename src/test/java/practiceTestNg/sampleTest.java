package practiceTestNg;

import org.testng.annotations.Test;

public class sampleTest {

	@Test//(groups = {"smoke","regression"})
	public void mouseTest()
	{
		System.out.println("mouse on");
	}
	
	@Test//(groups = {"integration","smoke","regression"})
	public void desktopTest()
	{
		System.out.println("desktop open");
	}
	
}
