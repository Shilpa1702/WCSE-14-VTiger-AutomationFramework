package vtiger.OrganizationTestng;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass{

	@Test(groups="SmokeSuite")
	public void createOrgTest() throws IOException
	{
		
		
		/*Excel File - Test Data*/
		String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		
		
		//Step 4: Click on Organizations Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Assert.fail();
		
		//Step 5: click on create organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 6: Create new organization with mandatory information and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 7: Validate:
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		//Step 8: logout
		hp.logoutOfApp(driver);
		
	
	}


	@Test(groups="ReggressionSuite")
	
	public void demoTest()
	{
		System.out.println("This is Demo");
	}






	}
	
	
