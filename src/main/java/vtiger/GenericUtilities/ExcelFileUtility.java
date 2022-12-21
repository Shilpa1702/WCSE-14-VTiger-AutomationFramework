package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws IOException
	{
	/**
	 * This method will take the value from excel sheet for repeatative sheet name
	 * @author shilpa
	 */
		FileInputStream fis =new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNum);
		Cell ce=rw.getCell(cellNum);
		String value= ce.getStringCellValue();
		wb.close();
		return value;
		
	}
public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
{
	/**
	 * This method will give the total row count in the sheet
	 * @author shilpa
	 */
	FileInputStream fis =new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int rowCount=sh.getLastRowNum();
	wb.close();
	return rowCount;
}
	
public void writeDataIntoExcel(String sheetName,int rowNum,int cellNo,String data) throws EncryptedDocumentException, IOException
{
	/**
	 * This method is for writing data into excel
	 * @Author shilpa
	 * 
	 */
	FileInputStream fis =new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	Row rw=sh.getRow(rowNum);
	Cell ce=rw.createCell(cellNo);
	ce.setCellValue(data);
	
	FileOutputStream fos=new FileOutputStream(IConstantsUtility.ExcelFilePath);
	wb.write(fos);
	wb.close();
	
	
	
}

public Object[][] readMultipleDataintoDataProvider(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fis =new FileInputStream(IConstantsUtility.ExcelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetName);
	int lastRow=sh.getLastRowNum();
	int lastCell=sh.getRow(0).getLastCellNum();
	
	Object[][] data=new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			
		}
	}
	return data;
	
}
			
}

