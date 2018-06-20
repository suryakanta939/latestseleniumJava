package latest.selenium.commonutils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class HandelWindow {
	
	public static void handelWInddoByNo(WebDriver driver,int windowNo){
		
		Set<String> windowIds=driver.getWindowHandles();
		 Iterator<String> itr=windowIds.iterator();
		System.out.println("The no of page is now is "+windowIds.size());
		 for(int i=0;i<windowIds.size();i++){
			 String id=itr.next();
			 if(i==windowNo-1){
				 driver.switchTo().window(id);
			 }	 
		 }	
	}
	
	public static void handelWIndowByTitle(WebDriver driver,String Title){
		String parentId=driver.getWindowHandle();
		Set<String> windowIds=driver.getWindowHandles();
		
		for(String id:windowIds){
			if(!id.equals(parentId)){
				driver.switchTo().window(id);
				String windowTitle=driver.getTitle();
				if(windowTitle.equals(Title)){
					driver.switchTo().window(id);
				}
			}
		}
		
	}
	

}
