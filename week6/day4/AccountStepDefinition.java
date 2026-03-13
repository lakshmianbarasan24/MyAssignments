package week6.day4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountStepDefinition {

	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User logs into Salesforce using url {string}")
	public void user_logs_into_salesforce(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//Login to https://login.salesforce.com
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys("lakshmi.anbarasan24@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Reset@123");
		driver.findElement(By.id("Login")).click();
	}
	@Given("User navigates to Sales page from App Launcher")
	public void user_navigates_to_sales_page_from_app_launcher() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();
		
		driver.findElement(By.xpath("//input[@type='search' and @role='combobox']")).sendKeys("Sales");
		driver.findElement(By.xpath("//p[normalize-space()='Sales']")).click();
	    
	}
	@Given("User clicks on Accounts tab")
	public void user_clicks_on_accounts_tab() {
		WebElement accounts = wait.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Accounts']")));

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", accounts);
	}
	@Given("User clicks on New button")
	public void user_clicks_on_new_button() {
		driver.findElement(By.xpath("//li[.//div[@title='New']]")).click();
	}
	@Given("User creates a new Salesforce account with name {string}")
	public void user_creates_a_new_salesforce_account_with_name(String accountName) {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(accountName);
		driver.findElement(By.xpath("//button[@aria-label='Ownership']")).click();
		driver.findElement(By.xpath("//span[@title='Public']")).click();
		
		//Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	@Then("Account {string} should be created successfully")
	public void account_should_be_created_successfully(String accountName) {
		String accountNameFromToast = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]//a")))
				.getText();
		//Verify the Alert message (Complete this field) displayed for Name
		if (accountNameFromToast.equals(accountName))
			System.out.println("Verification passed");
		else
			System.out.println("Verification failed");
	    driver.quit();
	}
	
}
