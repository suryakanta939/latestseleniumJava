package latest.selenium.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import latest.selenium.commonutils.SelectFunctions;

public class DatapickerPage {
	
	WebDriver driver;
	ExtentTest test;
	
	public DatapickerPage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Datepicker']")
	WebElement datapicker;
	
	@FindBy(xpath="//a[text()='Animations']")
	WebElement animations;
	
	@FindBy(xpath="//input[@id='datepicker2']")
	WebElement date;
	
	@FindBy(xpath="//select[@id='anim']")
	WebElement animationSelect;
	
	String selectDate1="//div[div[div[span[text()='";
	String selectDtae2="']]]]//a[@class='ui-state-default' and text()='";
	String selectDate3="']";
			
	
	public void chooseDate() throws InterruptedException{
		datapicker.click();
		test.log(LogStatus.INFO, "clciked on the datapicker");
		animations.click();
		test.log(LogStatus.INFO, "clciked on the animations");
		date.click();
		test.log(LogStatus.INFO, "clicked on the date");
		selectDate("August", "15");
		test.log(LogStatus.INFO, "selected the date");
		SelectFunctions.selectingByText(animationSelect, "Fade in");
		test.log(LogStatus.INFO, "selected the fade in");
		
	}
	
	public void selectDate(String month,String date) throws InterruptedException{
		
		while(true){
			
			try{
				driver.findElement(By.xpath(selectDate1+month+selectDtae2+date+selectDate3)).click();
				break;
			}
			catch(Throwable t){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				Thread.sleep(2000);
				
			}
			
		}
		
		
	}
	

}
