package vtiger.OganizationsTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationUsingDDT {

	public static void main(String[] args) throws IOException {
	
		//Step1: Read the neccessray data
		/* Property file -common data*/
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL =pObj.getProperty("url");
		String USERNAME =pObj.getProperty("username");
		String PASSWORD =pObj.getProperty("password");
		
		/*Excel file-Test data*/
		
		
		FileInputStream fis1 =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Organizations");
		Row rw=sh.getRow(1);
		Cell ce=rw.getCell(2);
		String ORGNAME=ce.getStringCellValue();
		
		WebDriver driver=null;
		
		//Step 2: Launch the Browser(Runtime Polymorphism)
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browsername");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		//Step 3: Login to application
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step 4:click on create organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5:click on create organisation lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
		//create new organisation with manadatory fields
				
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		}
		
		
		
		
	}


