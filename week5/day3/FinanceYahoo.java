package week5.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

		// Locate all crypto name cells directly
		By cryptoNamesLocator = By.xpath(
		    "//header[h2[text()='Crypto']]/following-sibling::div//table//tbody//tr/td[2]"
		);

		List<WebElement> cryptoNames = driver.findElements(cryptoNamesLocator);

		System.out.println("Crypto Names:");

		for (WebElement name : cryptoNames) {
		    System.out.println(name.getText());
		}
		
		driver.quit();

	}

}
