package week5.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ActionsAmazon {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);

		// Get the price of the first product.
		String price = driver.findElement(By.xpath("//div[@role='listitem']//span[@class='a-price-whole']")).getText();

		// Print the number of customer ratings for the first displayed product.
		String ratings = driver
				.findElement(By.xpath("//div[@role='listitem']//i[@data-cy='reviews-ratings-slot']//span"))
				.getDomProperty("textContent");

		System.out.println("Price:" + price);
		System.out.println("Ratings:" + ratings);

		// Click the first text link of the first image.
		driver.findElement(By.xpath("//div[@role='listitem']//div[@class='a-row']/following-sibling::a")).click();

		// switch to product window
		Set<String> openedWindowIDs = driver.getWindowHandles();
		List<String> openedWindowIDsList = new ArrayList<>(openedWindowIDs);
		driver.switchTo().window(openedWindowIDsList.get(1));

		// Take a screenshot of the product displayed.
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/amazon-product.png");
		FileUtils.copyFile(source, dest);

		// Click the 'Add to Cart' button.
		List<WebElement> addToCartBtn = driver.findElements(By.id("add-to-cart-button"));
		for (WebElement e : addToCartBtn) {
			if (e.isDisplayed()) {
				e.click();
				break;
			}
		}

		// Get the cart subtotal and verify if it is correct
		String cartSubTotal = driver.findElement(By.xpath("//div[@id='sw-subtotal']//span[@class='a-price-whole']"))
				.getText();
		System.out.println("Cart SubTotal:" + cartSubTotal);

		if (cartSubTotal.equals(price))
			System.out.println("Cart SubTotal matches Product price");
		else
			System.out.println("Cart SubTotal not matches Product price");

		driver.quit();

	}

}
