package marathon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProductSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter "Bags for boys" in the search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
		
		Thread.sleep(500);

		//Select the searched suggestion or result for "bags for boys"
		driver.findElement(By.xpath("//div[@role='button' and @aria-label='bags for boys']")).click();

		//Capture and print the total number of search results displayed
		String breadcrumbText = driver.findElement(By.xpath("//div[contains(@class,'s-breadcrumb-header-text')]//h2"))
				.getText();

		int startIndex = breadcrumbText.indexOf("over") + "over".length();
		int endIndex = breadcrumbText.indexOf("results") - 1;

		String totalResults = breadcrumbText.substring(startIndex, endIndex).trim();
		System.out.println("Total Results:" + totalResults);
		
        //Select the first two brands from the left-side filter menu
		// 1. Click the first brand
		List<WebElement> brands = driver
				.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-list-item']"));
		brands.get(0).click();

		// 2. Wait for the page/sidebar to refresh
		Thread.sleep(1000);

		// 3. RE-FIND the list before clicking the second one
		brands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//span[@class='a-list-item']"));
		brands.get(1).click();

		Thread.sleep(1000);
		
		//Apply sorting by selecting "New Arrivals"
		// click the visible dropdown button to open the list
		driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).click();

		// Click 'Newest Arrivals' from the menu that appears
		driver.findElement(By.xpath("//a[contains(text(), 'Newest Arrivals')]")).click();
		
		/* Select sortSelect = new
		Select(driver.findElement(By.id("s-result-sort-select")));
		sortSelect.selectByVisibleText("Newest Arrivals");
		Thread.sleep(500);*/
		
		//Capture and print the first product details (name and discounted price)
		String productName = driver.findElement(By.xpath("//div[@data-cy='title-recipe']//h2[@aria-label]//span"))
				.getText();
		String sellingPrice = driver.findElement(By.xpath("//span[@class='a-price']//span[@class='a-offscreen']"))
				.getDomProperty("textContent");
		String discountedPrice = driver
				.findElement(By.xpath("//span[@class='a-price a-text-price']//span[@class='a-offscreen']"))
				.getDomProperty("textContent");

		System.out.println("***********Product details:***********");
		System.out.println("Product Name:" + productName);
		System.out.println("Selling Price:" + sellingPrice);
		System.out.println("Discounted Price:" + discountedPrice);

		//Capture and print the page title
		System.out.println("Title:" + driver.getTitle());

		driver.close();

	}

}
