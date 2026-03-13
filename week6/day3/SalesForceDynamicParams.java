package week6.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesForceDynamicParams extends ProjectSpecificMethods {

	@BeforeClass
	public void setFileName()
	{
		fileName = "LegalEntityNames";
	}
	
	@Test(dataProvider ="getLegalEntityNames")
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

	}
	
	
	
	
}
