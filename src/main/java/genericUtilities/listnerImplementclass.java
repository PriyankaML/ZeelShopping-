

package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class listnerImplementclass implements ITestListener{
	
	ExtentSparkReporter htmlReport;
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//testScripts execution starts from here
		String methodName = result.getMethod().getMethodName();
		 test = report.createTest(methodName);
		 Reporter.log(methodName+" execution started", true);
	}

	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" Passed");
		Reporter.log(methodName+" executed successfully", true);
	}

	@Override
	
	public void onTestFailure(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		try {
			String path = webdriverUtils.getScreenShot(BaseTestClass.sdriver, methodName);
			test.addScreenCaptureFromPath(path);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, methodName+" Failed");
		test.log(Status.FAIL, result.getThrowable());//once scripts got failed it throws exception the result stores exception
		Reporter.log(methodName+" failed", true);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+" skipped");
		test.log(Status.SKIP, result.getThrowable());
	     Reporter.log(methodName+" skipped", true);
	}

	@Override
	public void onStart(ITestContext context) {
		//configure report
		
		htmlReport=new ExtentSparkReporter(".\\ExtentReports\\report.html");//(\\report.html need to give explicitly)
		htmlReport.config().setDocumentTitle("SDET-45");
		htmlReport.config().setTheme(Theme.STANDARD);
		htmlReport.config().setReportName("Zeel-Shopee");
		
		 report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "OS");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Base URL", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		report.setSystemInfo("ReporterName", "Priyanka");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	
}
