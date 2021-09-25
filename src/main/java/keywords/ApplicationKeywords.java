package keywords;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords{
//	public Properties prop;
	public ApplicationKeywords()
	{
//		Properties props = new Properties();
		prop = new Properties();
		//D:\SeleniumWorkspace2021\DataDrivenFramework\src\test\resources\project.properties
//		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\env.properties";
				
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			// Read Env name
			String env= prop.getProperty("env")+ ".properties";
			//load respe props file
			path = System.getProperty("user.dir")+"\\src\\test\\resources\\" + env;
			envProp =  new Properties();
			 fis = new FileInputStream(path);
			 System.out.println("Reading Properties File:"+path);
			envProp.load(fis);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void login()
	{
		
	}		
	
	public void selectDateFromCalendar()
	{
		
	}
	
	public void verifyStockAdded()
	{
		
	}

}
