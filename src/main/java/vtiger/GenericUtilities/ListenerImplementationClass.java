package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test Execution Started");
		 test=report.createTest(methodName);
		
		
}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"Test Execution Success");
		test.log(Status.PASS, methodName+"Success");

		}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"Test Execution failure");
		test.log(Status.FAIL,methodName+"failed");
		test.log(Status.FAIL,result.getThrowable());
		String screenShotName=methodName+"_"+jUtil.getSystemDateInFormat();
		
		try {
			String path=wUtil.taketheScreenShot(BaseClass.sdriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName=result.getMethod().getMethodName();
		//System.out.println(methodName+"Test Execution Skipped");
		test.log(Status.SKIP,methodName+"Skipped");
		test.log(Status.SKIP,result.getThrowable());
		
		}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution started");
		//crete object for ExtentSparkReport class
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+ new JavaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Extend Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger Report");
		
		//attach the html report to extent Report
		
		 report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("BasePlatform", "Windows");
		report.setSystemInfo("BaseBrowser", "Chrom");
		report.setSystemInfo("BaseEnvironment", "Testing");		
		report.setSystemInfo("BaseURL", "http://localhost:8888");
		report.setSystemInfo("Author", "Shilpa");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution Finished");
		
		report.flush();
		}
	
	

}
