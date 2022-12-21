package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException  {
		// step 1:load file locatin into  file input stream
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2: create a workbook
		
		Workbook wb=WorkbookFactory.create(fis);
		
		//Step3:navigate to requitred sheet
		Sheet sh=wb.getSheet("Organizations");
				
		
		//step 4:navigate to required row
		
		Row rw=sh.getRow(1);
		
			
		//step5:navigate to required cell
		Cell ce= rw.getCell(2);
		
		//Step 6: capture the data present in the cell
		
		String value= ce.getStringCellValue();
		
		System.out.println(value);
		
			 
		
	}

}
