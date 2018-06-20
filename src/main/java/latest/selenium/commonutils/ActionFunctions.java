package latest.selenium.commonutils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionFunctions {
	
	public static void mouseHoverOnElement(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	public static void moveToCordinate(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		int xCord=element.getLocation().getX();
		int yCord=element.getLocation().getY();
		act.moveByOffset(xCord, yCord).build().perform();
	}
	
	public static void mouseHoverOnCordinate(WebDriver driver,WebElement element){
		Actions act=new Actions(driver);
		int xCord=element.getLocation().getX();
		int yCord=element.getLocation().getY();
		act.moveToElement(element, xCord, yCord).build().perform();
	}
	
	public static void openLinkInNewTab(WebDriver driver,WebElement element) throws InterruptedException{
		Actions act=new Actions(driver);
		act.moveToElement(element).contextClick().perform();
		act.sendKeys(Keys.CONTROL).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		
	}
	
}
