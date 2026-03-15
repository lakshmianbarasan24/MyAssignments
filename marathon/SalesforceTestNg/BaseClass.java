package marathon.SalesforceTestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {

	WebDriver driver;
	String fileName;
	WebDriverWait wait;

	@BeforeMethod
	@Parameters({ "url", "username", "password" })
	public void preConditions(String url, String username, String password) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\SeleniumProfile");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login to https://login.salesforce.com
		driver.get(url);

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// Click View All and click Sales from App Launcher
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='App Launcher']"))).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @role='combobox']"))).sendKeys("Sales");
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Sales']"))).click();

		// Click on the "Opportunity" tab.
		WebElement opportunities = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Opportunities']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", opportunities);

	}

	@AfterMethod
	public void postConditions() {
		driver.quit();
	}

	@DataProvider(name = "getOpportunitiesData")
	public String[][] getData() throws IOException {
		return ExcelUtility.getExcelData(fileName);
	}

}
