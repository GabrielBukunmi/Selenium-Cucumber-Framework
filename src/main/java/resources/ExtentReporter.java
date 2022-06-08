package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

	
	static ExtentReports extent;
	//all variables of a static method declared outside the method must be made static
	
	public static ExtentReports getReportObject() {
		//ExtentReports,  ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		//ExtentSparkReporter is responsible to create html file and do some configurations
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//do some more configuration on the report
		reporter.config().setReportName("WEB AUTOMATION RESULT");
		reporter.config().setDocumentTitle("Test Results");
		
		//ExtentSparkReporter is a helper class that will eventually communicate with its main class
		//the main class is ExtentReport
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bukunmi Odunlami");
		return extent;
		
			
		}
	}

