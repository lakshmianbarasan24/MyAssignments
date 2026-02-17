package week3.day1;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		// Initialize the WebDriver (ChromeDriver)
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		// Load the URL http://leaftaps.com/opentaps/
		driver.get("http://leaftaps.com/opentaps/");

		// Maximize the browser window.
		driver.manage().window().maximize();

		// Enter a username and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click the "Login" button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the "CRM/SFA" link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the "Accounts" tab
		driver.findElement(By.linkText("Accounts")).click();

		// Click on the "Create Account" button
		driver.findElement(By.linkText("Create Account")).click();

		// Enter an account name
		Random random = new Random();
		int randomInt = random.nextInt();
		String accountName = "Tester"+randomInt;
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys(accountName);

		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester");

		//Select "ComputerSoftware" as the industry. 
		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select industryDropdownOptions = new Select(industryDropdown);
		industryDropdownOptions.selectByVisibleText("Computer Software");
		
		//Select "S-Corporation" as ownership using SelectByVisibleText. 
		WebElement ownershipDropdown = driver.findElement(By.xpath("//select[@name='ownershipEnumId']"));
		Select ownershipDropdownOptions = new Select(ownershipDropdown);
		ownershipDropdownOptions.selectByVisibleText("S-Corporation");
		
		//Select "Employee" as the source using SelectByValue. 
		WebElement sourceDropdown = driver.findElement(By.xpath("//select[@name='dataSourceId']"));
		Select sourceDropdownOptions = new Select(sourceDropdown);
		sourceDropdownOptions.selectByValue("LEAD_EMPLOYEE");
		
		//Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex. 
		WebElement marketingCampaignDropdown = driver.findElement(By.xpath("//select[@name='marketingCampaignId']"));
		Select marketingCampaignDropdownOptions = new Select(marketingCampaignDropdown);
		marketingCampaignDropdownOptions.selectByIndex(6);
		
		//Select "Texas" as the state/province using SelectByValue.
		WebElement generalStateProvinceDropdown = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select generalStateProvinceDropdownOptions = new Select(generalStateProvinceDropdown);
		generalStateProvinceDropdownOptions.selectByValue("TX");

		// Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement accountNameElement = driver.findElement(By.xpath("//td[span[text()='Account Name']]//following-sibling::td/span"));
		
		// Verify account name
		if(accountNameElement.getText().contains(accountName))
			System.out.println("Account Name Verification Passed");
		else
			System.out.println("Account Name Verification Failed");
		
		// Close the browser window
		driver.close();

	}

}
