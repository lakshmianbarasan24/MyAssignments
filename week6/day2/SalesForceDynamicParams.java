package week6.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SalesForceDynamicParams {

	WebDriver driver;
	@BeforeMethod
	@Parameters({"url","username","password"})
	public void preConditions(String url, String username, String password) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		 options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        
		//Login to https://login.salesforce.com
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
	}
	
	@Test(dataProvider ="getLegalEntityNames", dataProviderClass = SalesForceDataProvider.class)
	public void createLegalEntity(String entityName) {

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		//Click View All and click Legal Entities from App Launcher
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();
		driver.findElement(By.xpath("//input[@type='search' and @role='combobox']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//input[@type='search' and @role='combobox']")).sendKeys(Keys.ENTER);

		//Click on New Legal Entity
		driver.findElement(By.xpath("//li[.//div[@title='New']]")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by "+entityName);
	
		//Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		String entityNameFromToast = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]//a")))
				.getText();
		//Verify the Alert message (Complete this field) displayed for Name
		if (entityNameFromToast.equals("Salesforce Automation by "+entityName))
			System.out.println("Verification passed");
		else
			System.out.println("Verification failed");

		driver.quit();
	}
}
