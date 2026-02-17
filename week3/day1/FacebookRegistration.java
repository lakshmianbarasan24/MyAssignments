package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://en-gb.facebook.com/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Click on the Create new account button.
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Enter the First name.
		driver.findElement(By.name("firstname")).sendKeys("Lakshmi");
		
		//Enter the surname name.
		driver.findElement(By.name("lastname")).sendKeys("Anbarasan");

		//Enter the mobile number or email address.
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input"))
				.sendKeys("lakshmi.anbarasan@gmail.com");

		//Enter password
		driver.findElement(By.id("password_step_input")).sendKeys("password@123");

		// Select birthday day dropdown by index
		WebElement birthdayDayDropdown = driver.findElement(By.name("birthday_day"));
		Select birthdayDayDropdownOptions = new Select(birthdayDayDropdown);
		birthdayDayDropdownOptions.selectByIndex(0);

		// Select birthday month dropdown by text
		WebElement birthdayMonthDropdown = driver.findElement(By.name("birthday_month"));
		Select birthdayMonthDropdownOptions = new Select(birthdayMonthDropdown);
		birthdayMonthDropdownOptions.selectByVisibleText("Jan");

		// Select birthday day dropdown by value
		WebElement birthdayYearDropdown = driver.findElement(By.name("birthday_year"));
		Select birthdayYearDropdownOptions = new Select(birthdayYearDropdown);
		birthdayYearDropdownOptions.selectByValue("1994");
		
		//Select the radio button in Gender.
		driver.findElement(By.xpath("//input[@id='sex' and@ value='1']")).click();

	}

}
