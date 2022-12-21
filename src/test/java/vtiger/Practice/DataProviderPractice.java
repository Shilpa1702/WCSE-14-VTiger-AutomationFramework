package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider="getData")
	
	public void dataProviderPractice(String name,String model,int price,int qty )
	{
	System.out.println("Test run==>"+name+""+model+""+price+""+qty);	
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]=10000;
		data[0][3]=12;
				
		data[1][0]="Iphone";
		data[1][1]="s13";
		data[1][2]=30000;
		data[1][3]=10;
		
		data[2][0]="Nokia";
		data[2][1]="1100";
		data[2][2]=50000;
		data[2][3]=20;
		
		return data;
	}
	
}
