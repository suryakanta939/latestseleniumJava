package latest.selenium.baseutils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeBrowser {
	
	 static WebDriver driver;
	 
	 public static  WebDriver openBrowser(String browser){
		 
		 if(browser.equalsIgnoreCase("firefox")){
			 
			 File f=new File("drivers");
			 File fs=new File(f,"geckodriver.exe");
			 
			 System.setProperty("webdriver.gecko.driver", fs.getAbsolutePath());
			 driver=new FirefoxDriver();
		 }
		 else if(browser.equalsIgnoreCase("chrome")){
			 File f=new File("drivers");
			 File fs=new File(f,"chromedriver.exe");
			 
			 System.setProperty("webdriver.chrome.driver", fs.getAbsolutePath());
			 driver=new ChromeDriver();
		 }
		return driver;
		 
	 }

}
