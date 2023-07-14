package Practice;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.Assert;
import org.testng.annotations.Test;

public class retryAnalyzerImplementation {
		
		@Test(retryAnalyzer = Vtiger.GenericUtilities.RetryAnalyzerImplementstion.class)
		public void retryPractice1() {
			Assert.fail();
			System.out.println("Test1 working");
			
		}
		
		@Test
		public void retryPractice2() {
			System.out.println("Test2 working");
			
		}
		
	

}
