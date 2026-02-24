package week4.day2;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraList {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.myntra.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//In the search box, type as "bags" and press enter
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags", Keys.ENTER);

		//To the left of the screen under "Gender" click on "Men"
		driver.findElement(By.xpath("//ul[@class='gender-list']//label[text()='Men']")).click();

		Thread.sleep(1000);

		//Under "Category" click "Laptop bags"
		driver.findElement(By.xpath("//ul[@class='categories-list']//label[text()='Laptop Bag']")).click();

		Thread.sleep(1000);

		//Print the count of the items found
		String count = driver.findElement(By.xpath("//span[@class='title-count']")).getText().replaceAll("[^0-9]", "");

		System.out.println("*******************Total Products: " + count);

		//Get the list of brand of the products displayed in the page and print the list.
		System.out.println("*******************Brand Names:*******************");
		List<WebElement> brandNames = driver
				.findElements(By.xpath("//ul[@class='results-base']//h3[@class='product-brand']"));
		Set<WebElement> uniqueBrandNames = new HashSet<>(brandNames);
		for (WebElement brandName : uniqueBrandNames)
			System.out.println(brandName.getText());

		//Get the list of names of the bags and print it
		System.out.println("*******************Product Names:*******************");
		List<WebElement> productNames = driver
				.findElements(By.xpath("//ul[@class='results-base']//h4[@class='product-product']"));
		for (WebElement productName : productNames)
			System.out.println(productName.getText());
		
		driver.close();

	}

}
