package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {

	@Test(dataProvider = "getData")
	public void name(String name, String model, int price, int qty) {
		System.out.println("Phone Data=>"+name+" "+model+" "+price+" "+qty);
	
	}
	
	@DataProvider
	public Object[][] getData() {
		Object data[][]=new Object[3][4];
		data[0][0]="iphone";
		data[0][1]="12 Mini";
		data[0][2]=50000;
		data[0][3]=40;
		
		data[1][0]="Samsung";
		data[1][1]="S20";
		data[1][2]=30000;
		data[1][3]=120;
		
		data[2][0]="Nokia";
		data[2][1]="M6600";
		data[2][2]=15000;
		data[2][3]=240;
		
		
		return data;
		
	}
}
