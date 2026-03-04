package week5.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FinanceYahoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// Load the url
		driver.get("https://finance.yahoo.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.linkText("Markets")).click();

		// click on “Crypto” tab
		driver.findElement(By.linkText("Crypto")).click();

		// Locate the table in the dom page
		int totalRows = driver
				.findElements(By.xpath("//header[h2[text()='Crypto']]/following-sibling::div//table//tbody//tr"))
				.size();
		System.out.println("Crypto Names:");
		// Use loop to iterate the cryptocurrency names
		for (int r = 1; r <= totalRows; r++) {
			// Locate the cryptocurrency names in the table using specific row and column
			String name = driver
					.findElement(By.xpath(
							"//header[h2[text()='Crypto']]/following-sibling::div//table//tbody//tr[" + r + "]//td[2]"))
					.getText();
			// Print the cryptocurrency names
			System.out.println(name);
		}

		driver.quit();

	}

}
