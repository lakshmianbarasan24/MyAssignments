package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLead {

	public static void main(String[] args) {
		// Initialize the WebDriver (ChromeDriver)
		ChromeDriver driver = new ChromeDriver();

		// Load the URL http://leaftaps.com/opentaps/
		driver.get("http://leaftaps.com/opentaps/");

		// Maximize the browser window.
		driver.manage().window().maximize();

		// Enter a username and password
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click the "Login" button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the "CRM/SFA" link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the "Leads" tab
		driver.findElement(By.linkText("Leads")).click();

		// Click on the "Create Lead" button
		driver.findElement(By.linkText("Create Lead")).click();

		// Enter an first name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Tester");

		// Enter an last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Lakshmi");

		// Enter an company name
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");

		WebElement titleElement = driver.findElement(By.id("createLeadForm_generalProfTitle"));
		// Enter a title.
		titleElement.sendKeys("Test Lead");

		// Get title from DOM
		String title = titleElement.getDomProperty("value");

		// Click the "Create Account" button.
		driver.findElement(By.name("submitButton")).click();

		// Print title
		System.out.println(title);

		// Close the browser window
		driver.close();

	}

}
