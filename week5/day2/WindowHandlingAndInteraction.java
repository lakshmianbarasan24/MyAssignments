package week5.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingAndInteraction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Initialize the WebDriver (ChromeDriver)
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(opt);

		// Load the URL http://leaftaps.com/opentaps/
		driver.get("http://leaftaps.com/opentaps/");

		// Maximize the browser window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter a username and password
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// Click the "Login" button
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on the "CRM/SFA" link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click on the "Contacts" button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on the "Merge Contacts" button
		driver.findElement(By.linkText("Merge Contacts")).click();

		// Click on the widget of the "From Contact".
		driver.findElement(By.xpath("//td[span[text()='From Contact']]/following-sibling::td//a")).click();

		// switch to new window
		Set<String> windowsSet = driver.getWindowHandles();
		List<String> windowList = new ArrayList<>(windowsSet);

		driver.switchTo().window(windowList.get(1));
		// Click on the first resulting contact.
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//td[1]//a)[1]")).click();

		driver.switchTo().window(windowList.get(0));
		// Click on the widget of the "To Contact".
		driver.findElement(By.xpath("//td[span[text()='To Contact']]/following-sibling::td//a")).click();

		// switch to new window
		windowsSet = driver.getWindowHandles();
		windowList = new ArrayList<>(windowsSet);

		driver.switchTo().window(windowList.get(1));
		// Click on the second resulting contact.
		driver.findElement(By.xpath("(//div[@class='x-grid3-body']//table//td[1]//a)[2]")).click();

		driver.switchTo().window(windowList.get(0));
		// Click on the Merge button.
		driver.findElement(By.linkText("Merge")).click();

		// Accept the alert.
		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Verify the title of the page.
		String title = driver.getTitle();
		if (title.contains("View Contact"))
			System.out.println("Verification success - " + title);
		else
			System.out.println("Verification failed");

	}

}
