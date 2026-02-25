package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DecathlonSearch {

	/*
	 * 1.Launch the browser and navigate to https://www.decathlon.in/ 2. Verify the
	 * Decathlon homepage is displayed 3. Click on the Search box 4. Enter the
	 * product name “Shoes” 5. Press Enter or select a suggestion from the dropdown
	 * 6. Click on the Sport filter dropdown 7. Select Running from the Sport
	 * dropdown 8. Click on the Gender filter dropdown 9. Select Men 10. Click on
	 * the Sort By dropdown and choose 'Highest Discount' 11. From the filtered
	 * results, click on the first available product 12. Click on the Add to Cart
	 * button 13. Verify that the product is successfully added to the cart
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		// Maximize the browser window.
		driver.manage().window().maximize();

		// Navigate to(https://www.decathlon.in/)
		driver.get("https://www.decathlon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[normalize-space()='Search for']")).click();
		// Enter the product name “Shoes”
		driver.findElement(By.xpath("//span[normalize-space()='Search for']/preceding::input")).sendKeys("Shoes",
				Keys.ENTER);

		//Select Running from the Sport filter
		driver.findElement(By.xpath("//div[span[text()='Sport']]//li[span[contains(text(),'Running')]]")).click();
		Thread.sleep(1000);
		
		//Select Men from the Gender filter
		driver.findElement(By.xpath("//div[span[text()='Gender']]//li[span[contains(text(),'Men')]]")).click();
		Thread.sleep(1000);

		//Select Highest Discount Sort
		driver.findElement(By.xpath("//span[.//span[text()='Sort by']]/following-sibling::p")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[a[text()='Highest Discount']]")).click();
		Thread.sleep(1000);

		//click on the first available product
		driver.findElement(By.xpath("//li[@class='ais-InfiniteHits-item']//button[normalize-space()='ADD TO CART']"))
				.click();
		Thread.sleep(1000);

		//Click on the Add to Cart button
		driver.findElement(By.xpath("//div[@class='mb-3' and not(.//p[text()='Discontinued'])]")).click();
		driver.findElement(By.xpath("//div[contains(@class,'fSCYon')]//button[normalize-space()='ADD TO CART']"))
				.click();
		Thread.sleep(1000);
		
		//Verify that the product is successfully added to the cart
		List<WebElement> cartElements = driver.findElements(By.xpath(
				"//a[@href='/checkout/cart']//div[contains(@class,'relative')]//div[contains(@class,'absolute') and normalize-space()!='']"));
		if (cartElements.isEmpty())
			System.out.println("Item not added to the cart");
		else
			System.out.println(cartElements.get(0).getDomProperty("textContent") + " Item added successfully to the cart");

		driver.close();

	}

}
