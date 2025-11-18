package Listerners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.base;
import utils.Utility;

public class TestListener extends base implements ITestListener
{
	@Override
	public void onTestFailure (ITestResult result) 
	{
		Utility.captureScreenshot(driver, result.getName());
	}

}
