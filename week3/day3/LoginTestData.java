package week3.day3;

public class LoginTestData extends TestData {
	public void enterUsername() {
		System.out.println("enterUsername method");
	}

	public void enterPassword() {
		System.out.println("enterPassword method");
	}

	public static void main(String[] args) {

		System.out.println("**************TestData methods:**************");
		TestData testDataObj = new TestData();
		testDataObj.enterCredentials();
		testDataObj.navigateToHomePage();

		System.out.println("**************LoginTestData methods:**************");
		LoginTestData loginTestDataObj = new LoginTestData();
		// Parent class methods
		loginTestDataObj.enterCredentials();
		loginTestDataObj.navigateToHomePage();
		// class methods
		loginTestDataObj.enterUsername();
		loginTestDataObj.enterPassword();		
	}
}
