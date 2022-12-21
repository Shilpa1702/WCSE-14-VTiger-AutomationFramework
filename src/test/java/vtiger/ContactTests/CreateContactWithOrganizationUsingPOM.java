package vtiger.ContactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateContactWithOrganizationUsingPOM {
	public static void main(String [] args) throws IOException {
	
	JavaUtility jUtil =  new JavaUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver = null;
	
	//Step 2: Read the required Data
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
	String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
	
	//Step 3: Launch the browser
	if(BROWSER.equalsIgnoreCase("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
	}
	else if(BROWSER.equalsIgnoreCase("FIREFOX"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser name");
	}

	wUtil.maximizeWindow(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	
	//Step 4: Login to Application
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME,PASSWORD);
	
	//Step 5: Navigate to Organization
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationLink();
	
	
	//Step 6: Click On create Organization look up image
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	
	
	//Step 7: Create Organization with Mandatory details and Save
	
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME);
	
	//Step 8 Validate Organization
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader=oip.getOrganizationHeaderText();
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println(OrgHeader);
		System.out.println("Organization created");
	}
	else
	{
		System.out.println("Organization not created");
	}
	
	
	//Step 9: Navigate to Contacts link
	hp.clickOnContactsLink();
	
	
	//Step 10: Click on Create Contact look up image
	ContactPage cp=new ContactPage(driver);
	cp.clickOnCreateContactImg();
	
	
	//Step 11: Create Contact with mandatory fields 
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.createNewContact(LASTNAME,ORGNAME,driver);
	
	
	//Step 16: Validate for Contacts
	ContactInfoPage cip=new ContactInfoPage(driver);
	String contactHeader=cip.getContactHeader();
	if(contactHeader.contains(LASTNAME))
	{
		System.out.println(contactHeader);
		System.out.println("Pass");
	}
	else
	{
		System.out.println("fail");
	}
	//logout of application
	
	hp.logoutOfApp(driver);
	
}
	
	
	
	
	
}










