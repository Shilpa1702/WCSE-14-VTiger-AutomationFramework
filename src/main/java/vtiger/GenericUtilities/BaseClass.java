package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public ExcelFileUtility eUtil= new ExcelFileUtility();
	public JavaUtility jUtil= new JavaUtility();
	public WebDriverUtility wUtil= new WebDriverUtility();
	public static WebDriver sdriver=null;
	
	
	public WebDriver driver=null;
	
	@BeforeSuite(groups={"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("==== Database connection susseccful====");
		
	}
	
	@BeforeClass(groups={"SmokeSuite","ReggressionSuite"})
	public void bcConfig() throws IOException
	{
		String 	BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL=pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println("====="+BROWSER+ "===========");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("====="+BROWSER+ "===========");
		}
		else
		{
			System.out.println("===invalid browser====");
		}
			sdriver=driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
			
		}
			@BeforeMethod(groups={"SmokeSuite","ReggressionSuite"})
			public void bmConf() throws IOException
			{
				String USERNAME=pUtil.readDataFromPropertyFile("username");
				String PASSWORD =pUtil.readDataFromPropertyFile("password");
				
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				System.out.println("Login to app susseccfull");
			}
			
			@AfterMethod(groups={"SmokeSuite","ReggressionSuite"})
			public void amConfig()
			
			{
				
				HomePage hp=new HomePage(driver);
				hp.logoutOfApp(driver);
				System.out.println("Logout susseccfull");
				
			}
			
			@AfterClass(groups={"SmokeSuite","ReggressionSuite"})
			
			public void acConfig()
			{
				driver.quit();
				System.out.println("====Browser is closed");
			}
		
		@AfterSuite(groups={"SmokeSuite","ReggressionSuite"})
		public void asConfig()
		{
			System.out.println("Data is closed");
		}
	}
	
	
			
	


