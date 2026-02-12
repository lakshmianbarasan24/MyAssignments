package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		
		// Initialize the WebDriver (ChromeDriver)
		ChromeDriver driver = new ChromeDriver();

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
		driver.findElement(By.id("accountName")).sendKeys("Tester");

		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");

		// Enter a Number Of Employees.
		driver.findElement(By.id("numberEmployees")).sendKeys("100");

		// Enter a Site Name as “LeafTaps”
		driver.findElement(By.id("officeSiteName")).sendKeys("LeafTaps");

		// Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();

		// Close the browser window
		driver.close();

	}

}
