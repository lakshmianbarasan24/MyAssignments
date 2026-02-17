package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--guest");

		// Instantiate the Browser driver
		ChromeDriver driver = new ChromeDriver(opt);

		// Maximize the browser window.
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Load the url
		driver.get("http://leaftaps.com/opentaps/");

		// Enter the username as ‘demosalesmanager’
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		// Enter the password as 'crmsfa'
		driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("crmsfa");

		// Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Click on the Leads tab.
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click on the Create Lead link from shortcuts.
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();

		// Enter an company name using Elder to younger cousin Xpath.
		driver.findElement(By.xpath("//span[text()='Company Name']/following::input[@id='createLeadForm_companyName']"))
				.sendKeys("Tester");

		// Enter an last name using Elder to younger cousin Xpath.
		driver.findElement(
				By.xpath("//span[text()='Last name']/following::input[@id='createLeadForm_lastName']"))
				.sendKeys("Lakshmi");

		// Enter an first name using Elder to younger cousin Xpath.
		driver.findElement(By.xpath("//span[text()='First name']/following::input[@id='createLeadForm_firstName']"))
				.sendKeys("Lakshmi");

		// Enter an first name local using Elder to younger cousin Xpath.
		driver.findElement(
				By.xpath("//span[text()='First Name (Local)']/following::input[@id='createLeadForm_firstNameLocal']"))
				.sendKeys("Lakshmilocal");

		// Enter an department using younger to elder cousin Xpath.
		driver.findElement(
				By.xpath("//span[text()='Annual Revenue']/preceding::input[@id='createLeadForm_departmentName']"))
				.sendKeys("IT");

		// Enter description using elder sibling to younger sibling
		driver.findElement(By.xpath("//td[span[text()='Description']]/following-sibling::td/textarea"))
				.sendKeys("Automation tester");

		// Enter an email using descendents.
		driver.findElement(By.xpath("//form[@id='createLeadForm']//input[@id='createLeadForm_primaryEmail']"))
				.sendKeys("liuckin.24@gmail.com");

		// Select "New York" as the state/province using SelectByValue.
		WebElement generalStateProvinceDropdown = driver
				.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select generalStateProvinceDropdownOptions = new Select(generalStateProvinceDropdown);
		generalStateProvinceDropdownOptions.selectByVisibleText("New York");

		// Click the "Create Account" button.
		driver.findElement(By.name("submitButton")).click();

		// Click on Edit button
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		// clear description field
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();

		// Enter important note text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Its a important note");
		
		//Click on update button
		driver.findElement(By.xpath("//input[@name='submitButton' and @value='Update']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}
}
