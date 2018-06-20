package latest.selenium.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import latest.selenium.commonutils.HandelWindow;

public class FrameAndWindow {
	WebDriver driver;
	ExtentTest test;
	
	public FrameAndWindow(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[@href='http://demoqa.com/frames-and-windows/']")
	WebElement frameandwindow;
	
	@FindBy(xpath="//a[contains(text(),'New Browser Tab')]")
	WebElement newBrowserTab;
	
	@FindBy(xpath="//a[@id='ui-id-2']")
	WebElement separateNewWindow;
	
	@FindBy(xpath="//a[@href='http://toolsqa.com/registration']")
	WebElement separateWIndowLink;

	
	public void handelWIndowInNewTab() throws InterruptedException{
		frameandwindow.click();
		test.log(LogStatus.INFO, "clicked on the frame and winodw ");
		newBrowserTab.click();
		test.log(LogStatus.INFO, "clicked on the new browser tab");
		HandelWindow.handelWInddoByNo(driver, 2);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Registration']")).click();
		test.log(LogStatus.INFO, "clciked on th eregistration page");
		driver.findElement(By.xpath("//input[@id='name_3_firstname']")).sendKeys("hello");
		driver.close();
		HandelWindow.handelWInddoByNo(driver, 1);
		test.log(LogStatus.INFO, "handeling the parent window");
		separateNewWindow.click();
		test.log(LogStatus.INFO, "cliked on the separate new window");
		separateWIndowLink.click();
		test.log(LogStatus.INFO, "separate new winod link is clicked");
		HandelWindow.handelWInddoByNo(driver, 2);
		Thread.sleep(3000);
		String message=driver.findElement(By.xpath("//h1[text()='Oops! That page can’t be found.']")).getText();
		System.out.println(message);
		test.log(LogStatus.INFO, "getting the text from  anaother page");
		Thread.sleep(2000);
		driver.close();
		HandelWindow.handelWInddoByNo(driver, 1);
		test.log(LogStatus.INFO, "again came back to the parent window");
		
		driver.findElement(By.xpath("//a[@id='ui-id-3']")).click();
		test.log(LogStatus.INFO, "clciked on the fareme set");
		Thread.sleep(2000);
		
	}
}
