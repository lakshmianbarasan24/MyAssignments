package week3.day3;

public class Elements extends Button {

	public static void main(String[] args) {

		System.out.println("**************TextField methods:**************");
		TextField textFieldObj = new TextField();
		// click and setText method inherited from WebElement class ( parent)
		textFieldObj.click();
		textFieldObj.setText("TextField");
		//Class method
		textFieldObj.getText();
		
		System.out.println("**************Button methods:**************");
		Button buttonObj = new Button();
		// click and setText method inherited from WebElement class ( parent)
		buttonObj.click();
		buttonObj.setText("Button");
		//Class method
		buttonObj.submit();

		System.out.println("**************CheckBoxButton methods:**************");
		CheckBoxButton checkBoxButtonObj = new CheckBoxButton();
		// click and setText method inherited from WebElement class (grand parent)
		checkBoxButtonObj.click();
		checkBoxButtonObj.setText("CheckBoxButton");
		// class method
		checkBoxButtonObj.clickCheckButton();
		// submit method inherited from Button class (parent)
		checkBoxButtonObj.submit();

		System.out.println("**************RadioButton methods:**************");
		RadioButton radioButtonObj = new RadioButton();
		// submit method inherited from Button class (parent)
		radioButtonObj.click();
		radioButtonObj.setText("RadioButton");
		// class method
		radioButtonObj.selectRadioButton();
		// submit method inherited from Button class (parent)
		radioButtonObj.submit();
		
		System.out.println("**************Elements methods:**************");
		Elements elementObj = new Elements();
		// click and setText method inherited from WebElement class (grand parent)
		elementObj.click();
		elementObj.setText("Elements");
		// submit method inherited from Button class (parent)
		elementObj.submit();

	}

}
