package latest.selenium.commonutils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scroll {
	
	public static void scrollingTo(WebDriver driver,String scrollTo)
	{	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		if(scrollTo.toLowerCase().equals("up")){
			jse.executeScript("window.scrollBy(0,-1500);");
		}
		else if(scrollTo.toLowerCase().equals("down")){
			jse.executeScript("window.scrollBy(0,1500);");
		}	
	}
	
	public static void scrollToExactElement(WebDriver driver,WebElement element){
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
		jse.executeScript("window.scrollBy(0,-150);");
	}
}
