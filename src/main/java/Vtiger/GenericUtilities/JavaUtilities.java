package Vtiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	/**
	 * @return 
	 * 
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(3000);
	}
	
	public String getSystemDate() {
		
		Date d=new Date();
		return d.toString();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d=new Date();
		String[] dArr=d.toString().split(" ");
		String date= dArr[2];
		String month= dArr[1];
		String year= dArr[5];
		String time= dArr[3].replace(":", "-");
		String dateInFormat= date+" "+month+" "+year+" "+time;
		return dateInFormat;
		
		
	}

}
