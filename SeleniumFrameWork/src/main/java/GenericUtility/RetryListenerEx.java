package GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerEx implements IRetryAnalyzer{
int count=0;
int retrylimit=4;
public boolean retry(ITestResult result)
{
	if(count<retrylimit)
	{
		count++;
		return true;
	}
	else
	{	
	return false;
	}
}
}
