package week5.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsBigBasket {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.bigbasket.com/");

		List<WebElement> categoryBtns = driver
				.findElements(By.xpath("//button[.//span[text()='Shop by'] and .//span[text()='Category']]"));
		WebElement displayedCategoryBtn = null;
		for (WebElement e : categoryBtns) {
			if (e.isDisplayed()) {
				displayedCategoryBtn = e;
				e.click();
				break;
			}
		}
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		explicitWait.until(ExpectedConditions.attributeToBe(displayedCategoryBtn, "aria-expanded", "true"));
		//Thread.sleep(1000);
		Actions actions = new Actions(driver);

		// Mouse over "Foodgrains, Oil & Masala".
		WebElement foodgrainsMenuElement = driver
				.findElement(By.xpath("//li[a[text()='Foodgrains, Oil & Masala' and @role='none']]"));
		actions.scrollToElement(foodgrainsMenuElement).moveToElement(foodgrainsMenuElement).perform();

		// Mouse over "Rice & Rice Products".
		WebElement riceMenuElement = driver.findElement(By.xpath("//li[a[text()='Rice & Rice Products']]"));
		actions.moveToElement(riceMenuElement).perform();

		// Click on "Boiled & Steam Rice".
		WebElement riceElement = driver.findElement(By.xpath("//li[a[text()='Boiled & Steam Rice']]"));
		riceElement.click();
		

		// Filter the results by selecting the brand "bb Royal".
		WebElement filter = driver.findElement(By.id("i-bbRoyal"));
		actions.scrollToElement(filter).perform();
		filter.click();

		// Click on "Tamil Ponni Boiled Rice".
		WebElement element = explicitWait.until(ExpectedConditions.refreshed(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[.//h3[text()='Tamil Ponni Boiled Rice']]"))));
		element.click();

		// switch to product window
		Set<String> openedWindowIDs = driver.getWindowHandles();
		List<String> openedWindowIDsList = new ArrayList<>(openedWindowIDs);
		driver.switchTo().window(openedWindowIDsList.get(1));

		// Select the 5 Kg bag.
		element = explicitWait.until(ExpectedConditions.refreshed(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='w-full']//div[.//span[text()='5 kg']]"))));
		element.click();

		// Check and note the price of the rice.
		String price = driver
				.findElement(
						By.xpath("//div[@class='w-full']//div[.//span[text()='5 kg']]//span[starts-with(text(),'₹')]"))
				.getText();
		String bagPrice = driver.findElement(By.xpath("//td[starts-with(text(),'Price:')]")).getText().replace("Price:",
				"");
		if (bagPrice.trim().equals(price.trim()))
			System.out.println("Price Verified");

		// Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		
		// Verify the success message that confirms the item was added to your cart.
		element = explicitWait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Toast')]//p")));

		String message = element.getText();
		if (message.contains("successfully"))
			System.out.println("Items added");
		else
			System.out.println("Items not added");
		System.out.println("Toast  Message: " + message);

		driver.quit();

	}
}
