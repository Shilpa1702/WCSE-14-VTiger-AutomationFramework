package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule1

	
	//Rule2: Decleration
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	//rule3:Initialization
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//rule4:Utilization
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	//Rule5:Business Libraries
	
	public void loginToApp(String username,String password)
	{
		
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
		
	}
	
}
	
	

