package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsSnapdeal {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.snapdeal.com/");

		// Go to "Men's Fashion".
		Actions act = new Actions(driver);
		WebElement tab = driver.findElement(By.xpath("//div[text()=\"Men's Fashion\"]"));
		act.moveToElement(tab).perform();

		// Go to "Sports Shoes".
		driver.findElement(
				By.xpath("//div[text()=\"Men's Fashion\"]/following-sibling::div//div[text()='Sports Shoes']")).click();

		// Get the count of sports shoes.
		String count = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText()
				.replaceAll("\\D", "");
		System.out.println(count);

		// Click on "Training Shoes".
		driver.findElement(By.xpath("//a[div[text()='Training Shoes']]")).click();

		driver.findElement(By.xpath("//div[contains(@class,'sort-drop')]")).click();

		// Sort the products by "Low to High".
		driver.findElement(By.xpath("//ul[contains(@class,'sort-value')]//li[normalize-space()='Price Low To High']"))
				.click();

		// Select any price range ex:(500-700).
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("440");
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("1000");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();

		// Filter by any colour.
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(20));

		By colorFilterLocator = By
				.xpath("//div[@data-filtername='Color_s']//label[a[normalize-space()='White & Blue']]");
		// WebElement colorFilter = driver.findElement(colorFilterLocator);
		// explicitWait.until(ExpectedConditions.stalenessOf(colorFilter));
		// WebElement colorFilter = driver.findElement(colorFilterLocator);
		WebElement colorFilter = explicitWait
				.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(colorFilterLocator)));
		act.scrollToElement(colorFilter).perform();
		colorFilter.click();

		 Thread.sleep(1000);
		// Verify all the applied filters.
		 List<WebElement> filters = driver .findElements(By.xpath(
		 "//div[@class='filters-top-selected']//div[@class='navFiltersPill']"));
		 

		for (WebElement filter : filters) {
			String filterText = filter.getText();
			System.out.println(filterText);
			if (filterText.contains("Color") && filterText.contains("White & Blue"))
				System.out.println("Color verified");
			else if (filterText.contains("Price:") && filterText.contains("440") && filterText.contains("1000"))
				System.out.println("Price verified");
			else
				System.out.println("Validation failed");

		}

		// Mouse hover on the first resulting "Training Shoes".
		WebElement shoe = driver.findElement(By
				.xpath("//div[contains(@class,'product-tuple-listing')]//div[contains(@class,'product-tuple-image')]"));
		act.moveToElement(shoe).perform();

		// Click the "Quick View" button.
		driver.findElement(By.xpath("//div[contains(@class,'quick-view-bar')]")).click();

		// Print the cost and the discount percentage.
		String marketPrice = driver
				.findElement(By.xpath(
						"//div[contains(@class,'quickProductDescPanel')]//div[contains(@class,'product-desc-price')]"))
				.getDomProperty("textContent");

		String discountPrice = driver
				.findElement(By.xpath(
						"//div[contains(@class,'quickProductDescPanel')]//div[contains(@class,'product-price')]"))
				.getDomProperty("textContent");

		System.out.println(marketPrice.trim());
		System.out.println(discountPrice.trim());

		// Take a snapshot of the shoes.
		WebElement shoeImage = driver.findElement(By.xpath("//div[@class='comp-quickview']//img[@itemprop='image']"));
		File source = shoeImage.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/shoe-image.png");
		FileUtils.copyFile(source, dest);

		// close modal
		driver.findElement(By.xpath("//div[contains(@class,'comp-qv')]//div[contains(@class,'close')]")).click();

		// close browser
		driver.quit();
	}

}
