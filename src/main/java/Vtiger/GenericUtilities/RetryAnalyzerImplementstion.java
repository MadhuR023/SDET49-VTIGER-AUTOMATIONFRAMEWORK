package Vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This is to implement IRetryAnalyzer
 * @author Madhusudhan R
 *
 */

public class RetryAnalyzerImplementstion implements IRetryAnalyzer {
	int count=0;
	int retrycount=3;
	
	public boolean retry(ITestResult result) {

		
		while (count<retrycount) {
			count++;
			return true;
			
		}
		return false;
		
	}

}
