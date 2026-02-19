package week3.day4;

public class LoginPage extends BasePage {

	@Override
	public void performCommonTasks() {
		System.out.println("Calling BasePage performCommonTasks method from LoginPage performCommonTasks method");
		super.performCommonTasks();
		System.out.println("performCommonTasks method called from LoginPage");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("**********BasePage class method call**********");
		BasePage basePageObj = new BasePage();
		basePageObj.clickElement();
		basePageObj.enterText();
		basePageObj.findElement();
		basePageObj.performCommonTasks();
		
		System.out.println("**********Child class method call**********");
		LoginPage loginPageObj = new LoginPage();
		loginPageObj.performCommonTasks();

	}

}
