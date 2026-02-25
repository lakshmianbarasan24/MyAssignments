package marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBusSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		// Maximize the browser window.
		driver.manage().window().maximize();

		// Navigate to(https://www.redbus.in/)
		driver.get("https://www.redbus.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Select the From source city.
		WebElement source = driver.findElement(By.xpath("//input[@id='srcinput']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", source);

		driver.findElement(By.xpath("//div[contains(@class,'searchSuggestionWrapper')]//div[text()='Koyambedu']"))
				.click();

		driver.findElement(By.xpath("//div[contains(@class,'searchSuggestionWrapper')]//div[text()='Bangalore']"))
				.click();

		// Select the To destination city.
		WebElement date = driver.findElement(By.xpath("//span[text()='Date of Journey']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", date);
		Thread.sleep(1000);

		// Select tomorrow’s travel date.
		
		//li[contains(@class,'date')]//span[text()='26']
		driver.findElement(By.xpath("//div[contains(@class,'calendarDate') and @data-datetype='AVAILABLE']//span")).click();

		// Click on the Search Buses button.
		driver.findElement(By.xpath("//button[text()='Search buses']")).click();
		Thread.sleep(1000);

		// Capture and print the total number of buses displayed.
		String count = driver
				.findElement(By.xpath("//div[contains(@class,'textContainer')]//span[contains(@class,'subtitle')]"))
				.getText();
		System.out.println("**************Count before filter:" + count);

		// Apply the AC Bus filter.
		driver.findElement(By.xpath("//div[contains(@class,'mainContainer')]//div[contains(text(),'AC')]")).click();
		Thread.sleep(1000);
		count = driver
				.findElement(By.xpath("//div[contains(@class,'textContainer')]//span[contains(@class,'subtitle')]"))
				.getText();
		System.out.println("**************Count after AC filter:" + count);

		// Apply the High Rated bus filter under Bus Features.
		driver.findElement(
				By.xpath("//div[contains(@class,'mainContainer')]//div[contains(text(),'High Rated Buses')]")).click();
		Thread.sleep(1000);
		count = driver
				.findElement(By.xpath("//div[contains(@class,'textContainer')]//span[contains(@class,'subtitle')]"))
				.getText();
		System.out.println("**************Count after High Rated filter:" + count);

		// Capture all the bus prices displayed on the page.
		List<WebElement> priceElements = driver.findElements(By.xpath("//p[contains(@class,'finalFare')]"));
		List<Integer> prices = new ArrayList<>();

		// Identify and print the lowest bus price.
		for (WebElement e : priceElements) {
			int price = Integer.parseInt(e.getText().replaceAll("[^0-9]", ""));
			prices.add(price);
		}
		
		prices.sort(null);
		
		System.out.println("**************Lowest price:" + prices.get(0));

		// Print the title of the page.
		System.out.println("**************Title:" + driver.getTitle());
		driver.close();

	}

}
