package practiceTestNg;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import ObjectRepository.userLoginPage;
import genericUtilities.BaseClass;

public class demotest {
	
	@Test
	
	public void helloTest() throws Throwable
	{
      System.out.println("exceution begin");
      System.out.println("same day");
      Assert.fail();
	}
		//String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD = fLib.readDataFromPropertyFile("password");
//
//		
//	hp.login();
//		
////		wLib.clickOnElement(driver, loglink);
//		userLoginPage ulp=new userLoginPage(driver);
//		ulp.loginToApplication(USERNAME, PASSWORD);
//		Reporter.log("logged in to appl", true);
//		System.out.println("hello script");
//		hp.logoutFromApp();
//	}
//	
	@Test//(groups = "smoke")
	public void watsupTest()
	{
		System.out.println("watsupTest script");
	}

}
