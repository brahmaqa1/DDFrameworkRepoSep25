package tmp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingPropetiesFile {

	public static void main(String[] args) {
		Properties props = new Properties();
		//D:\SeleniumWorkspace2021\DataDrivenFramework\src\test\resources\project.properties
		String path= System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
				
		try {
			FileInputStream fis = new FileInputStream(path);
			props.load(fis);
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("Get prop name:"+props.getProperty("url"));	
		//Get prop name:https://portfolio.rediff.com/portfolio-login
		System.out.println("Get prop name:"+props.getProperty("username"));	
		//Get prop name:useremail
	}

}
