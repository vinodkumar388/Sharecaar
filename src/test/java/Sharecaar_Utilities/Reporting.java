package Sharecaar_Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting implements ITestListener{
	public ExtentHtmlReporter htmlreporter;  //UI
	public ExtentReports extent;  ///basic information about user
	public ExtentTest test;  // add the status about test (pass/fail/skip)
	
	public void onStart(ITestContext context) {
		//time stamp
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.mm.ss").format(new Date());
		
		//to create report name
		String repName="Test-Report - "+timestamp+ " .html";
		
		//to specify the location
		
		htmlreporter= new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Reports\\" +repName);
		
		//configurate the extent-config .xml file
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent_config.xml\\");
		
		//provide the basic information about user
		
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Host", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "vinodkumar");
		extent.setSystemInfo("OS", "Windows 10");
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		String Screenshotpath=System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png";
		File f=new File(Screenshotpath);
		
		if(f.exists()) {
			try {
				test.fail("screenshot is below:"+test.addScreenCaptureFromPath(Screenshotpath));
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	 
	 
	
	}
	
		
	
	
	public void onTestSkipped(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
		
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	

}
