package SeleniumWork;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporter;



public class Listener extends Base implements ITestListener{
	 ExtentTest test;
 ExtentReports extent = ExtentReporter.getReportObject();
 //to run test in parallel, you need threadlocal method - Threadsafe for parallel execution
 
 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		
		//instead of putting the extentTest create test in all class
		//put it in listener
		
		// TODO Auto-generated method stub
		
		
		test =extent.createTest(result.getMethod().getMethodName());
		//so everytime a new test is started, it will be stored in the extenTest thread local method
		/**
		 * No matter how many test cases are run in parallel, they will be placed
		 * in a new thread
		 */
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//log the test status from the extent reporter in the listener
		//test.log(Status.Pass, "Test passed") can be used when test is not run in parallel
	   extentTest.get().log(Status.PASS, "Test passed");	
	   //this gets the particular test started in parallel
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver=null;
		//Send driver object to the screenshot method in the listener
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Screenshot
		String testMethodName = result.getMethod().getMethodName();
		try {
			//since the getScreenshot from path is returning the screenshot in a destination file
			//the will be added to the current thread in the extentTest object
			extentTest.get().addScreenCaptureFromPath(getScreenshotpath(testMethodName, driver));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	extent.flush();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

}
