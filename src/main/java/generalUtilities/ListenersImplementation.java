package generalUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"----Test Execution Started----");
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"----Test Pass----");
		test.log(Status.PASS,methodName +"----Test Pass----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"----Test Fail----");
		System.out.println(result.getThrowable());
		//extend report
		test.log(Status.FAIL,methodName +"----Test Fail----" );
		test.log(Status.INFO, result.getThrowable());
		
		//capture screenshot
		SeleniumUtility s=new SeleniumUtility();
		JavaUtilityFile j=new JavaUtilityFile();
		String screenshotName=methodName+"-"+j.getSystemDate();
		try {
			s.captureScreenShot(BaseClass.sdriver, screenshotName);
			}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName +"----Test skip----");
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, "methodName +\"----Test skip----");
		test.log(Status.INFO, result.getThrowable());
		}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----suite execution started----");
		ExtentSparkReporter htmlrep = new ExtentSparkReporter(".\\ExtendReports\\Report-"+new JavaUtilityFile().getSystemDate()+".html");
	htmlrep.config().setDocumentTitle("Execution Report");
	htmlrep.config().setReportName("Vtiger Report");
	htmlrep.config().setTheme(Theme.DARK);
	
	report=new ExtentReports();//object creation
	report.attachReporter(htmlrep);
	report.setSystemInfo("Base Platform", "Windows");
	report.setSystemInfo("Base Browser", "Edge");
	report.setSystemInfo("Base Environment", "Test Environment");
	report.setSystemInfo("Reporter Name", "Sowmiya");
	
	
	
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("----suite execution finished----");
		report.flush();
	}
	

}
