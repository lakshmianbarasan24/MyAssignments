package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertFrameClassroomAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().frame("iframeResult");
		
		//Click the "Try It" button inside the frame
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		
		//Click OK/Cancel in the alert that appears
		alert.accept();
		
		//Confirm the action is performed correctly by verifying the text displayed
		String message = driver.findElement(By.id("demo")).getText();
		if (message.contains("OK"))
			System.out.println("Verification success - OK clicked");
		else
			System.out.println("Verification failed");
		
		driver.close();

	}

}
