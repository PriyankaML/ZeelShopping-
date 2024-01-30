package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer {
	int count=0;
	int retryCount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retryCount)
		{
			count++;
			return true;
		
		}
		return false;
		
	}

}
