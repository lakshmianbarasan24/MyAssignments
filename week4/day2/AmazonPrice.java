package week4.day2;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonPrice {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter "Bags for boys" in the search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phones", Keys.ENTER);

		Thread.sleep(500);

		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		for (WebElement price : prices)
			System.out.println(price.getText());
		// prices.sort(null);
		/*prices.sort((p1, p2) -> {
			double d1 = Double.parseDouble(p1.getText().replaceAll("[^0-9.]", ""));
			double d2 = Double.parseDouble(p2.getText().replaceAll("[^0-9.]", ""));
			return Double.compare(d1, d2);
		});*/

		prices.sort(Comparator.comparing(p1 -> Double.parseDouble(p1.getText().replaceAll("[^0-9.]", ""))));

		System.out.println(prices.get(0).getText());
	}
}
