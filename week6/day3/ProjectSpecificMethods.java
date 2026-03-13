package week6.day3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethods {

	WebDriver driver;
	String fileName;
	
	@BeforeMethod
	@Parameters({"url","username","password"})
	public void preConditions(String url, String username, String password) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//Login to https://login.salesforce.com
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}
	
	@AfterMethod
	public void postConditions() {
		driver.quit();
	}
	
	@DataProvider(name = "getLegalEntityNames")
	public String[][] getData() throws IOException
	{
		 return SalesForceDataProvider.getExcelData(fileName);
	}
}
