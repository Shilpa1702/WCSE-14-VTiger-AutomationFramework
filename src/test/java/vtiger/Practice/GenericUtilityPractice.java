package vtiger.Practice;

import java.io.IOException;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil =new PropertyFileUtility();
		String value=pUtil.readDataFromPropertyFile("url");
		System.out.println(value);

		ExcelFileUtility eUtil= new ExcelFileUtility();
		String data=eUtil.readDataFromExcel("Organizations", 1,2);
		System.out.println(data);
		
		int row=eUtil.getRowCount("Organizations");
		System.out.println(row);
		
		eUtil.writeDataIntoExcel("Organizations", 1, 6,"Shilpa");
		System.out.println("data added");
	}

}
