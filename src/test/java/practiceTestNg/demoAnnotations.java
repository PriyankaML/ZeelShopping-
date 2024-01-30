package practiceTestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class demoAnnotations {

	@BeforeSuite
	public void beforeSuiteTest()
	{
		System.out.println("before suite");
	}
	

	@AfterSuite
	public void afterSuiteTest()
	{
		System.out.println("after suite");
	}
	
	@BeforeSuite
	public void beforeSuite1Test()
	{
		System.out.println("before suite-1");
	}
	@BeforeSuite
	public void beforeSuite2Test()
	{
		System.out.println("before suite-2");
	}
	@BeforeClass
	public void beforeClassTest()
	{
		System.out.println("beforeClass");
	}
	
	@AfterClass
	public void afterClassTest()
	{
		System.out.println("afterClass");
	}
	
	@AfterSuite
	public void afterSuite1Test()
	{
		System.out.println("after suite1");
	}
	
	@BeforeMethod
	public void beforeMethodTest()
	{
		System.out.println("beforeMethod");
	}
	
	@AfterMethod
	public void afterMethodTest()
	{
		System.out.println("afterMethod");
	}

	@Test
	public void test()
	{
		System.out.println("test started");
	}
	
	
	@Test
	public void sampletest()
	{
	System.out.println("test executed");
	}
	
	
	
}
