package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganisationPractice {

	public static void main(String[] args)  {
		
		//launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//click on organisation link
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organisation lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//create new organisation with manadatory fields
		
		driver.findElement(By.name("accountname")).sendKeys("Qspiders12");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
				
		
		

	}
	}


