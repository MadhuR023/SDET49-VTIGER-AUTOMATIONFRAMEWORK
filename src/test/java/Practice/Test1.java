package Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test1 {

	@BeforeMethod
	public void bM() {
		System.out.println("Before Method");
	}
	
	@BeforeSuite
	public void bS() {
		System.out.println("Before Suite");
	}
	
	@BeforeClass
	public void bC() {
		System.out.println("Before Class");
	}
	@Test(priority = 2)
public void test1() {
	 System.out.println("Bangalore");
}		
	
	@Test(priority = -1)
	public void test2() {
		System.out.println("Chennai");
	}
	
	@Test
	public void test3() {
		System.out.println("Mumbai");
	}
		
	

}
