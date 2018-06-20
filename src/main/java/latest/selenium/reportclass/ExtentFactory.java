package latest.selenium.reportclass;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	static ExtentReports report;
	
	public static ExtentReports getReport(){
		File f=new File("report");
		File fs=new File(f,"\\check.html");
		return report=new ExtentReports(fs.getAbsolutePath(), false);
		
	}

}
