package vtiger.OrganizationTestng;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
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

public class CreateContactWithOrganizationTest extends BaseClass{
	
		
		@Test
		public void createContactTest() throws IOException
		{
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNumber();
		
		
		
		
		//Step 5: Navigate to Organization
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("Organization is clicked",true);
		
		
		//Step 6: Click On create Organization look up image
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Organization look up image is clicked",true);
		
		
		//Step 7: Create Organization with Mandatory details and Save
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("NewOrganization is created",true);
		
		//Step 8 Validate Organization
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		
		//Step 9: Navigate to Contacts link
		hp.clickOnContactsLink();
		Reporter.log("Contacts link is clicked",true);
		
		//Step 10: Click on Create Contact look up image
		ContactPage cp=new ContactPage(driver);
		cp.clickOnCreateContactImg();
		Reporter.log("Create new Contact image is clicked",true);
		
		
		//Step 11: Create Contact with mandatory fields 
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME,ORGNAME,driver);
		Reporter.log("Details are added",true);
		
		
		//Step 16: Validate for Contacts
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader=cip.getContactHeader();
		Assert.assertEquals(contactHeader.contains(LASTNAME), true);
		//logout of application
		
		hp.logoutOfApp(driver);
		
	}
		
		
		
		
	}


