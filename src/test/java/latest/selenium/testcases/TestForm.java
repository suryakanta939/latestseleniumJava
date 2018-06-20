package latest.selenium.testcases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import latest.selenium.baseutils.InvokeBrowser;
import latest.selenium.commonutils.ActionFunctions;
import latest.selenium.commonutils.Scroll;
import latest.selenium.pageclasses.Registration;
import latest.selenium.propertyclass.ProeprtyData;
import latest.selenium.reportclass.ExtentFactory;
import latest.selenium.screenshot.ScreenShot;

public class TestForm {
	WebDriver driver;
	String baseUrl;
	ExtentTest test;
	ExtentReports report;
	Registration reg;
	
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
		 reg=new Registration(driver, test);
		 test.log(LogStatus.INFO, "open the browser "+browser);
		 driver.get(baseUrl);
		 test.log(LogStatus.INFO, "entered the url");
		 driver.manage().window().maximize();
		
	}
	
  @Test(dataProvider="readData")
  public void fillingRegistration(String fn,String ln,String countryaname,String phone,String user,String mail){
	 if(fn==null || ln==null ||countryaname==null||phone==null||user==null||mail==null){
		 
	 }else{
		 reg.fillingUpForm(fn, ln, countryaname, phone, user, mail);
	 }
	  
		 
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
		  String filepath=ScreenShot.takeScreenShot(driver,result.getName());
		  test.log(LogStatus.FAIL,"test case got fail",test.addScreenCapture(filepath));
		
	  }
	 
  }
  
  @AfterClass
  public void teardownClass(){
	  driver.close();
	  test.log(LogStatus.INFO, "closed the browser");
	  test.assignAuthor("suriya kishoore");
	  report.endTest(test);
	  report.flush();
  }
  
  @DataProvider
  public Object[][] readData() throws EncryptedDocumentException, InvalidFormatException, IOException{
	  DataFormatter formatter=new DataFormatter();
	 FileInputStream fis=new FileInputStream("C:\\Users\\surya\\Desktop\\name.xlsx");
	 Workbook wb=WorkbookFactory.create(fis);
	 Sheet sh=wb.getSheet("data");
	 int row=sh.getLastRowNum();
	 System.out.println("the total no of row is "+row);
	 Object obj[][]= new Object[row+1][6];
	 for(int i=1;i<row+1;i++){
		 Row rw=sh.getRow(i);
		 
			 for(int j=0;j<6;j++){
				 String data=formatter.formatCellValue(rw.getCell(j));
				 if(data==null){
					 System.out.println(data);
					 continue;
				 }else{
					 obj[i][j]=data;
				 }
				
			 }
		 }	 
	 
	return obj;
	  
  }
  
}
