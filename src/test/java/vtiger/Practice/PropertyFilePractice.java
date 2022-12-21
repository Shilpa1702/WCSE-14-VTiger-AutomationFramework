package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
	
		//Step 1: load the file location into file input stream
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2:create object for properties from java.utilpackage
		
		Properties pObj= new Properties();
		
		//step3:load fileinputstream into properties
		
		pObj.load(fis);
		
		//step4: read the value using key
		
		String value=pObj.getProperty("browser");
		System.out.println(value);
		
		
	}

}
