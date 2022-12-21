package vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vtiger.ObjectRepository.LoginPage;

public class POMPractice {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp("admin","admin");

	}

}
