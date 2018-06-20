package latest.selenium.pageclasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import latest.selenium.commonutils.SelectFunctions;

public class Registration {

	WebDriver driver;
	ExtentTest test;
	
	public Registration(WebDriver driver,ExtentTest test){
		
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver,this);
				
	}

	@FindBy(xpath="//a[text()='Registration']")   
	WebElement registration;
	
	@FindBy(id="name_3_firstname")
	WebElement firstName;
	
	@FindBy(id="name_3_lastname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@type='radio']")
	List<WebElement> maritalStatu;
	
	@FindBy(xpath="//input[@type='checkbox']")
	List<WebElement> hobby;

	@FindBy(xpath="//select[@id='dropdown_7']")
	WebElement country;
	
	@FindBy(xpath="//select[@id='mm_date_8']")
	WebElement month;
	
	@FindBy(xpath="//select[@id='dd_date_8']")
	WebElement date;
	
	@FindBy(xpath="//select[@id='yy_date_8']")
	WebElement year;
	
	@FindBy(id="phone_9")
	WebElement phoneNo;
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="email_1")
	WebElement email;
	
	@FindBy(id="profile_pic_10")
	WebElement chooseFile;
	
	@FindBy(id="description")
	WebElement about;
	
	@FindBy(id="password_2")
	WebElement password;
	
	@FindBy(id="confirm_password_password_2")
	WebElement confirmPassword;
	
	@FindBy(name="pie_submit")
	WebElement submit;
	
	public void choosingTheMartalStatus(){
		for(int i=0;i<maritalStatu.size();i++){
			maritalStatu.get(i).click();
			test.log(LogStatus.INFO, "choosing the marital status");
		}
	}
	
	public void choosingThehobby(){
		for(int i=0;i<hobby.size();i++){
			hobby.get(i).click();
			test.log(LogStatus.INFO, "choosing the hooby");
		}
	}
	
	public void choosindDateOfBirth(){
		SelectFunctions.selectingByIndex(month, 9);
		SelectFunctions.selectingByText(date, "19");
		SelectFunctions.selectingByValue(year, "1991");
		test.log(LogStatus.INFO, "choosing the date of birth");
	}
	
	public void fillingUpForm(String fn,String ln,String countryaname,String phone,String user,String mail){
		firstName.sendKeys(fn);
		test.log(LogStatus.INFO, "filling up the first name as "+fn);
		lastName.sendKeys(ln);
		test.log(LogStatus.INFO, "filling up the first name as "+ln);
		choosingTheMartalStatus();
		choosingThehobby();
		SelectFunctions.selectingByText(country, "India");
		choosindDateOfBirth();
		phoneNo.sendKeys(phone);
		test.log(LogStatus.INFO, "selecting the phone no as "+phone);
		userName.sendKeys(user);
		test.log(LogStatus.INFO, "entering the username as "+user);
		email.sendKeys(mail);
		test.log(LogStatus.INFO, "entering the mail as "+mail);
		chooseFile.sendKeys("C:\\Users\\surya\\Desktop\\panda.jpg");
		test.log(LogStatus.INFO, "uploaded the profile pic");
		about.sendKeys("hello how you doing");
		test.log(LogStatus.INFO, "added th eprifile pic");
		password.sendKeys("reset123");
		test.log(LogStatus.INFO, "entered the password");
		confirmPassword.sendKeys("reset12");
		test.log(LogStatus.INFO, "entered the conform password");
		submit.click();
		test.log(LogStatus.INFO, "clciked on th esubmit button");
	}
	
	
	
}
