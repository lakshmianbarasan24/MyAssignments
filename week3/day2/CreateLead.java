package week3.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the CRM/SFA link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Click on the Leads tab.
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

		// Click on the Create Lead link from shortcuts.
		driver.findElement(By.xpath("//a[text()='Create Lead']")).click();

		// Enter an company name using preceding xpath
		driver.findElement(By.xpath(
				"//input[@id='createLeadForm_parentPartyId']/preceding::input[@id='createLeadForm_companyName']"))
				.sendKeys("Tester");

		// Enter an last name using immediate child xpath
		driver.findElement(By.xpath("//td/input[@id='createLeadForm_lastName']")).sendKeys("Lakshmi");
 
		// Enter an first name using ancestor - grandparent to child xpath
		driver.findElement(By.xpath("//tr//input[@id='createLeadForm_firstName']")).sendKeys("Lakshmi");

		// Enter an title using following xpath
		driver.findElement(By.xpath("//tr/following::input[@name='generalProfTitle']")).sendKeys("Title");

		// Print title
		System.out.println(driver.getTitle());
		
		// Click the "Create Account" button.
		driver.findElement(By.name("submitButton")).click();

	}

}
