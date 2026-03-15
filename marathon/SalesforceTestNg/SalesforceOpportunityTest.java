package marathon.SalesforceTestNg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesforceOpportunityTest extends BaseClass {

	@BeforeClass
	public void setFileName() {
		fileName = "OpportunitiesData";
	}

	@Test(dataProvider = "getOpportunitiesData", enabled = true, priority = 1)
	public void Create(String name, String amount) {

		// Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		String opportunityName = "Salesforce Automation by " + name;
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys(opportunityName);

		// Enter Amount
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(amount);

		// Choose the close date as Today.
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Today']"))).click();

		// Select 'Stage' as 'Need Analysis'.
		driver.findElement(By.xpath("//button[@aria-label='Stage']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='Needs Analysis']")))
				.click();

		// Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		String opportunityNameFromToast = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]//a")))
				.getText();

		// Verify the Alert message (Complete this field) displayed for Name
		Assert.assertEquals(opportunityName, opportunityNameFromToast, opportunityName + " creation failed");

	}

	@Test(dataProvider = "getOpportunitiesData", enabled = true, priority=2)
	public void Edit(String name, String amount) throws InterruptedException {

		// Search for the Opportunity 'Salesforce Automation by Your Name'.
		String opportunityName = "Salesforce Automation by " + name;
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		// Click on the Dropdown icon and select 'Edit'
		WebElement element = driver
				.findElement(By.xpath("//span[@data-cell-type='lstListViewRowLevelAction']//button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cell-type='lstListViewRowLevelAction']//button"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Edit']"))).click();

		Thread.sleep(1000);
		// Choose the close date as Tomorrow's date.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='CloseDate']"))).click();

		List<WebElement> nextDay = driver
				.findElements(By.xpath("//td[contains(@class,'slds-is-selected')]//following-sibling::td"));
		By nextDayPath;
		if (!nextDay.isEmpty())// same row next day
			nextDayPath = By.xpath("//td[contains(@class,'slds-is-selected')]//following-sibling::td");
		else// eg today = saturday, next day is next row
			nextDayPath = By.xpath("//tr[td[contains(@class,'slds-is-selected')]]//following-sibling::tr//td");
		wait.until(ExpectedConditions.elementToBeClickable(nextDayPath)).click();

		// Select 'Stage' as 'Perception Analysis'.
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Stage']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='Perception Analysis']")))
				.click();

		// Select 'Delivery/Installation Status' as 'In Progress'
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@aria-label='Delivery/Installation Status']"))).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//lightning-base-combobox-item[@data-value='In progress']"))).click();

		// Enter Description as 'SalesForce'.
		driver.findElement(By.xpath("//textarea")).sendKeys("SalesForce");

		// Click on Save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		Thread.sleep(1000);
		String stageText = driver.findElement(By.xpath("//sfa-output-stage-name//span"))
				.getText();

		System.out.println("stage name:"+stageText);
		// Verify the Stage as 'Perception Analysis'.
		Assert.assertEquals(stageText, "Perception Analysis", opportunityName + " updation failed");

	}

	@Test(dataProvider = "getOpportunitiesData", enabled = true, priority=3)
	public void Delete(String name, String amount) throws InterruptedException {

		// Search for the Opportunity 'Salesforce Automation by Your Name'.
		String opportunityName = "Salesforce Automation by " + name;
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);

		// Click on the Dropdown icon and select 'Delete'
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-cell-type='lstListViewRowLevelAction']//button")));
		WebElement menueElement = driver.findElement(By.xpath("//span[@data-cell-type='lstListViewRowLevelAction']//button"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", menueElement);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Delete']"))).click();

		// confirm delete
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		String opportunityNameFromToast = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'toastMessage')]")))
				.getText();

		// Verify whether the Opportunity is deleted using the Opportunity Name.
		Assert.assertTrue(opportunityNameFromToast.contains(opportunityName), opportunityName + " deletion failed");

	}

}
