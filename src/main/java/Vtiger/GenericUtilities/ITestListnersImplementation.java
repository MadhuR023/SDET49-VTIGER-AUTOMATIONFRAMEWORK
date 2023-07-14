package Vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class ITestListnersImplementation implements ITestListener {
	public ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" ---> execution has started");
		
		test=report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname+ "Success");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtilities jutil=new JavaUtilities();
		String methodname = result.getMethod().getMethodName();
		methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"-->Test Execution Failed ");
		System.err.println(result.getThrowable());
		
		String screenshotname= methodname+"."+jutil.getSystemDateInFormat();
		try {
			wutil.takeScreenShot(driver, screenshotname);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodname+" Skipped" );
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		//Configure Report
		System.out.println("Execution Started");
		
		//Create an Object of ExtentSpark Reporter
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtendReports\\Report"+new JavaUtilities().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTiger Execution Report");
		
		//Attach the HTMLReport to Extent Report
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("Author", "Chaitra");


	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution has Ended");
		
		//Flush the Report - Consolidate the Status of Every Test Script and generate the report
		report.flush();
	}
	

}
