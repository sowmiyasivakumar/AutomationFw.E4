package generalUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count=0;
	int retryCount=3;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<retryCount)//0<3,1<3,2<3
		{
			count++;
			return true;//retry,retry,retry
		}
		return false;//stop
	}
	

}
