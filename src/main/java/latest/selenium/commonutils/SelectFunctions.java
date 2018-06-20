package latest.selenium.commonutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFunctions {
	
	public static void  selectingByIndex(WebElement element,int index){
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	public static void selectingByValue(WebElement element,String value){
		Select sel=new Select(element);
		sel.selectByValue(value);
		
	}
	
	public static void selectingByText(WebElement element,String text){
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	

}
