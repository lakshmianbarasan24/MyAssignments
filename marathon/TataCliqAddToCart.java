package marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TataCliqAddToCart {

	/*
	 * 1. Load the url as https://www.tatacliq.com/ 2. MouseHover on 'Brands' 3.
	 * MouseHover on 'Watches & Accessories' 4. Choose the first option from the
	 * 'Featured brands'. 5. Select sortby: New Arrivals 6. choose men from
	 * catagories filter. 7. print all price of watches 8. click on the first
	 * resulting watch. 9. compare two price are similar 10. click Add to cart and
	 * get count from the cart icon. 11. Click on the cart 12. Take a snap of the
	 * resulting page. 13. Close All the opened windows one by one.
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");

		// 2. MouseHover on 'Brands'
		Actions actions = new Actions(driver);
		WebElement brandMenu = driver.findElement(By.xpath("//div[@role='button' and text()='Brands']"));
		actions.moveToElement(brandMenu).perform();

		// 3. MouseHover on 'Watches & Accessories'
		WebElement watchesSubMenu = driver
				.findElement(By.xpath("//div[@role='button' and text()='Watches & Accessories']"));
		actions.moveToElement(watchesSubMenu).perform();

		// 4. Choose the first option from the 'Featured brands'
		WebElement watchesFeaturedMenu = driver.findElement(
				By.xpath("//div[contains(@class,'brandsHeader') and text()='Featured brands']/following-sibling::div"));
		actions.moveToElement(watchesFeaturedMenu).perform();
		watchesFeaturedMenu.click();

		// 5. Select sortby: New Arrivals
		Select selectOptions = new Select(driver.findElement(By.tagName("select")));
		selectOptions.selectByVisibleText("New Arrivals");

		// 6. choose men from catagories filter.
		// div[@id='accordion-panel-Category']//div[@role='radio' and
		// starts-with(normalize-space(),Men)]
		driver.findElement(By.xpath("//div[@id='accordion-panel-Category']//div[@role='radio']")).click();

		// 7. print all price of watches
		Thread.sleep(2000);
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']"));
		String firstWatchPrice = prices.get(0).getText();
		for (WebElement price : prices)
			System.out.println(price.getText());

		// 8. click on the first watch
		driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']")).click();

		// switch to product window
		Set<String> openedWindowIDs = driver.getWindowHandles();
		List<String> openedWindowIDsList = new ArrayList<>(openedWindowIDs);
		driver.switchTo().window(openedWindowIDsList.get(1));

		// 9. compare two price are similar
		String cartWatchPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3"))
				.getText().replace("MRP:", "").trim();
		System.out.println("Cart Watch Price: " + cartWatchPrice);
		System.out.println("First Watch Price: " + firstWatchPrice);
		if (cartWatchPrice.equals(firstWatchPrice))
			System.out.println("Prices match");
		else
			System.out.println("Prices don't match");

		// 10. click Add to cart and get count of icon
		driver.findElement(By.xpath("//div[@class='Button__base' and span[text()='ADD TO BAG']]")).click();
		// span[@class='DesktopHeader__cartCount']
		String cartCount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Cart Count: " + cartCount);

		// 11. Click on the cart
		driver.findElement(By.xpath("//div[span[@class='DesktopHeader__cartCount']]")).click();

		Thread.sleep(1000);
		// 12.Take a snap of the resulting page
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/tata-cliq-watch.png");
		FileUtils.copyFile(source, dest);

		// 13.Close All the opened windows one by one.
		for (String windowID : openedWindowIDsList) {
			driver.switchTo().window(windowID);
			driver.close();
		}
		// driver.quit();

	}

}
