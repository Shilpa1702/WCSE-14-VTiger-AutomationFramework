package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath=" //input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	@FindBy(name="leadsource")
	private WebElement leadDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadDropDown() {
		return leadDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business lib
	
	public void createNewContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	public void createNewContact(String lastName,String orgName, WebDriver driver)
	
	{
		/**
		 * This methos is to create contact with organization
		 * 
		 */
		lastNameEdt.sendKeys(lastName);
		organizationImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
		
	}
	
	


