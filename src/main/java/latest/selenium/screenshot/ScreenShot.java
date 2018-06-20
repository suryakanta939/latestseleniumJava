package latest.selenium.screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenShot {
	
	public static String takeScreenShot(WebDriver driver,String fileName) throws IOException{
		File f=new File("screenshot");
		File fs=new File(f,"//"+fileName+".png");
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		File dst=new File(fs.getAbsolutePath());
		FileUtils.copyFile(src, dst);
		String path=fs.getAbsolutePath();
		return path;
	}

}
