package latest.selenium.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import latest.selenium.baseutils.InvokeBrowser;
import latest.selenium.pageclasses.DatapickerPage;
import latest.selenium.pageclasses.Registration;
import latest.selenium.propertyclass.ProeprtyData;
import latest.selenium.reportclass.ExtentFactory;
import latest.selenium.screenshot.ScreenShot;

public class TestDataPicker {
	WebDriver driver;
	String baseUrl;
	ExtentTest test;
	ExtentReports report;
	DatapickerPage dp;

	@BeforeClass
	public void setUpClass() throws IOException{
		File f=new File("drivers");
		File fs=new File(f,"chromedriver.exe");
		System.out.println(fs.getAbsolutePath());
		baseUrl=ProeprtyData.readPropertyFile("basedata","url2");
		System.out.println("url "+baseUrl);
		String browser=ProeprtyData.readPropertyFile("basedata", "browser");
		System.out.println("browser "+browser);
		report=ExtentFactory.getReport();
		test=report.startTest("cheking the registration form");
		driver=InvokeBrowser.openBrowser(browser);
		dp=new DatapickerPage(driver, test);
		test.log(LogStatus.INFO, "open the browser "+browser);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "entered the url");
		driver.manage().window().maximize();

	}
	@Test
	public void testDataPicker() throws InterruptedException{
		dp.chooseDate();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException{

		if(result.getStatus()==result.SUCCESS){
			System.out.println("test case got pass");
			test.log(LogStatus.PASS, "test case got pass");
		}else if(result.getStatus()==result.SKIP){
			System.out.println("test case got skipped");
			test.log(LogStatus.SKIP, "test case got skip");
		}else if(result.getStatus()==result.FAILURE){
			String filepath=ScreenShot.takeScreenShot(driver, result.getName());
			test.log(LogStatus.FAIL,"test case got fail",test.addScreenCapture(filepath));

		}
		Thread.sleep(1000);
		driver.navigate().refresh();
	}

	@AfterClass
	public void teardownClass(){
		driver.close();
		test.log(LogStatus.INFO, "closed the browser");
		test.assignAuthor("suriya kishoore");
		report.endTest(test);
		report.flush();
	}
}
