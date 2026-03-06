package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNowRequest {

	/*
	 * Instance URL: Instance URL https://dev266363.service-now.com/
	 * 
	 * • Username: Admin • Password: CSO=y7Fc7m@c
	 * 
	 * 
	 * 
	 * 1. Launch ServiceNow application 2. Login with valid credentials username as
	 * admin and password 3. Click-All Enter Service catalog in filter navigator and
	 * press enter or Click the ServiceCatalog 4. Click on mobiles 5. Select Apple
	 * iphone13pro 6. Choose yes option in lost or broken iPhone 7. Enter
	 * phonenumber as 99 in original phonenumber field 8. Select Unlimited from the
	 * dropdown in Monthly data allowance 9. Update color field to SierraBlue and
	 * storage field to 512GB 10. Click on Order now option 11. Verify order is
	 * placed and copy the request number 12.Take a Snapshot of order placed page
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Launch ServiceNow application
		driver.get("https://dev266363.service-now.com/");

		// 2. Login with valid credentials username as admin and password
		driver.findElement(By.id("user_name")).sendKeys("Admin");
		driver.findElement(By.id("user_password")).sendKeys("CSO=y7Fc7m@c");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();

		// 3. Click-All Enter Service catalog in filter navigator and
		// press enter or Click the ServiceCatalog
		// Initialize the Shadow class with the driver
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		// Find an element inside the Shadow DOM
		shadow.findElementByXPath("//div[@role='menu']//div[text()='All']").click();
		// shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service
		// catalog", Keys.ENTER);
		shadow.findElementByXPath("//a[contains(@aria-label,'Service Catalog')]").click();

		// 4. Click on mobiles
		WebElement iframeElement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframeElement);
		shadow.findElementByXPath("//a[h2[normalize-space()='Mobiles']]").click();

		// 5. Select Apple iphone13pro
		// iframeElement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		// driver.switchTo().frame(iframeElement);
		shadow.findElementByXPath("//a[normalize-space()='Apple iPhone 13 pro']").click();

		// 6. Choose yes option in lost or broken iPhone
		shadow.findElementByXPath("//div[legend[span[text()='Is this a replacement for a lost or broken iPhone?']]]/following-sibling::div//label[text()='Yes']").click();

		// 7. Enter phonenumber as 99 in original phonenumber field
		shadow.findElementByXPath(
				"//div[label[span[text()='What was the original phone number?']]]/following-sibling::div//input[not(@type='HIDDEN')]").sendKeys("99");
		
		// 8. Select Unlimited from the dropdown in Monthly data allowance
		Select ddlOptions = new Select(shadow.findElementByXPath("//select"));
		ddlOptions.selectByValue("unlimited");

		// 9. Update color field to SierraBlue and storage field to 512GB
		shadow.findElementByXPath("//div[legend[span[text()='Choose the colour']]]/following-sibling::div//label[text()='Sierra Blue']").click();
		shadow.findElementByXPath("//div[legend[span[text()='Choose the storage']]]/following-sibling::div//label[contains(text(),'512')]").click();

		// 10. Click on Order now option
		shadow.findElementByXPath("//button[@data-original-title='Order Now']").click();

		// 11. Verify order is placed and copy the request number
		String refNum = shadow.findElementByXPath("//a[@id='requesturl']").getText();
		if(!refNum.isBlank())
			System.out.println("order is placed");
		else
			System.out.println("order is not placed");
		
		// 12. Take a Snapshot of order placed page
		TakesScreenshot screen = (TakesScreenshot)driver;
		File scr=screen.getScreenshotAs(OutputType.FILE);
		File desc = new File("./screenshots/service-now.png");
		FileUtils.copyFile(scr, desc);
		
		driver.quit();

	}

}
