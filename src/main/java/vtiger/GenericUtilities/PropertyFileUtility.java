package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic methods related to property file
 * @author shilpa
 *
 */
public class PropertyFileUtility {
	
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		
		/**
		 * This generic method will read the key from property file and return the value
		 */
		FileInputStream fis =new FileInputStream(IConstantsUtility.PropertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value=pObj.getProperty(Key);
		return value;
	}

}
