package practiceTestNg;

import org.testng.annotations.Test;

public class saturday {
@Test(groups = {"smoke","regression"})
public void TuesdayTest()
{
	System.out.println("today is yesterday");
}

@Test(groups = "smoke")
public void mondayTest()
{
	System.out.println("tomorrow is monday");
}
}
