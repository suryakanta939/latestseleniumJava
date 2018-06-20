package latest.selenium.propertyclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProeprtyData {
	
	public static String readPropertyFile(String fileName,String Key) throws IOException{
		
		File f=new File("propertyfiles");
		File fs=new File(f,fileName+".properties");
		System.out.println("the path of the property file is "+fs.getAbsolutePath());
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		Properties pro=new Properties();
		pro.load(fis);
		String data=pro.getProperty(Key);
		return data;
		
	}

}
