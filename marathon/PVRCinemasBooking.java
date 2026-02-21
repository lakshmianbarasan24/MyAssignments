package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PVRCinemasBooking {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.pvrcinemas.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Select location as Chennai if not auto-detected
		List<WebElement> citySearch = driver
				.findElements(By.xpath("//div[@class='cities-names']//h6[text()='Chennai']"));

		if (citySearch.size() > 0)
			citySearch.get(0).click();

		// Click on Cinema under Quick Book
		driver.findElement(By.xpath("//div[@class='date-show']//span[text()='Cinema']")).click();

		// Select a theatre
		driver.findElement(By.id("cinema")).click();
		driver.findElement(By.xpath("//li[@role='option'][span[text()='INOX National,Virugambakkam Chennai']]"))
				.click();

		// Select date as Tomorrow
		driver.findElement(By.xpath("//li[@role='option'][span[starts-with(text(),'Tomorrow')]]")).click();

		// Select a movie
		driver.findElement(By.xpath("//li[@role='option'][span[text()='WITH LOVE']]")).click();

		// Select show time
		driver.findElement(By.xpath("//li[@role='option'][.//span[text()='03:30 PM']]")).click();

		// Click on Book button
		driver.findElement(By.xpath("//button[@type='submit'][span[text()='Book']]")).click();

		// Accept Terms and Conditions
		driver.findElement(By.xpath("//button[text()='Accept']")).click();

		// Select any one available seat
		driver.findElement(By.id("SL.SILVER|D:16")).click();

		// Click on Proceed button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		// Capture and print Seat info from Booking Summary
		String ticketValue = driver.findElement(By.xpath("//div[@class='seat-info']//div[@class='ticket-value']/p"))
				.getText();

		String seatNumber = driver.findElement(By.xpath("//div[@class='seat-info']//div[@class='seat-number']/p"))
				.getText();

		String grandTotal = driver.findElement(By.xpath("//h6[text()='Grand Total']/following-sibling::h6/span"))
				.getText();

		System.out.println("Booking Summary:");
		System.out.println("Seat Info:" + ticketValue + " " + seatNumber);
		System.out.println("Grand Total:" + grandTotal);

		// Click on Continue button
		driver.findElement(By.xpath("//button[text()='Continue']")).click();

		// Close the popup if displayed
		driver.findElement(By.xpath("(//i[contains(@class,'pi-times')])[last()]")).click();
		
		//Using Actions
		/*WebElement element = driver.findElement(By.xpath("//i[contains(@class,'pi-times')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();*/
		
		//JS click
		/*WebElement closeIcon = driver.findElement(By.xpath("//i[contains(@class,'pi-times')]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeIcon);//overlay issue*/

		// Capture and print current page title
		String title = driver.getTitle();
		System.out.println("Title:" + title);

		// Close the browser
		driver.close();

	}

}
