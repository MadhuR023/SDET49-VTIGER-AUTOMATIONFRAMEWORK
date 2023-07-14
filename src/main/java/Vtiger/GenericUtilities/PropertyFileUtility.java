package Vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *This class contains Generic methods related to PropertyFile
 * @author Madhusudhan 
 */

public class PropertyFileUtility {
	/**
	 * This method will read key and return value
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
		public String readFromPropertyFile(String key) throws IOException {
			FileInputStream fis=new FileInputStream(IConstantsUtility.PropertyFilePath);
			Properties pdata=new Properties();
			pdata.load(fis);
			String value = pdata.getProperty(key);
			return value;			
	
}
}
