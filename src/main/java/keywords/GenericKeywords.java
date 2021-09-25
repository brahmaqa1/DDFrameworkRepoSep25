package keywords;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords {
	public WebDriver driver;
	public Properties prop;
	public Properties envProp;

	public void openBrowser(String browser) {
		System.out.println("Opening The Browser:"+ browser);		

		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\SeleniumSoftwares\\All Selenium Jar Files\\chromedriver_win32V93\\chromedriver.exe");
			//			WebDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\SeleniumSoftwares\\All Selenium Jar Files\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			// ok 
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "");
			driver = new ChromeDriver();
		}

		//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); // Deprectaed
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); // new 		
		driver.manage().window().maximize();
	}

	public void navigate(String urlKey) {
		//Read props file , url 
		//		urlKey= prop.getPropert(urlKey);// cannot read prop, declare public Properties props; in current class
		//		urlKey= prop.getProperty(urlKey);
		urlKey= envProp.getProperty(urlKey);
		System.out.println("Navigating to  url:"+ urlKey);
		driver.get(urlKey);

	}

	public void click(String locatorKey) {
//		locatorKey = readPropertyValue(locatorKey);
		System.out.println("Clicking on "+locatorKey);
		//		driver.findElement(By.id(locatorKey)).click();
		getElement(locatorKey).click();
	}

	public void type(String locatorKey,String data) {
		//locatorKey= props.getProperty(locatorKey);// why to call every time--- make it resuable--Optimise
		//locatorKey = readPropertyValue(locatorKey);
		System.out.println("Typing in "+locatorKey+": "+ data);
		//locatorKey = readPropertyValue(locatorKey);
		//		driver.findElement(By.id(locatorKey)).sendKeys(data);// why to write every time driver.findElement(By.id(locatorKey))
		// make it resuable 
		/*
		 * if(!isElementInteractable(locatorKey)) { System.out.println("Element:"
		 * +locatorKey +" is not  interactble"); }
		 */
		getElement(locatorKey).sendKeys(data);
	}

	public WebElement getElement(String locatorKey)
	{
		String locatorVal=null;
		//check Ele is present
		if(!isElementPresent(locatorKey))
		{
			System.out.println("Ele is not present :"+locatorKey);
		}

		// Check Ele is visible
		if(!isElementVisible(locatorKey))
		{
			System.out.println("Ele is not visible :"+locatorKey);
		}

		//		WebElement ele=  driver.findElement(By.id(locatorKey));// if we use xpath, CSS
		
		// optimised in one line
//		WebElement ele = null;
//		locatorVal = readPropertyValue(locatorKey);
//		if(locatorKey.endsWith("_id"))
//		{
//			ele=  driver.findElement(By.id(locatorVal));
//		}
//		else if(locatorKey.endsWith("_xpath"))
//		{
//			ele=  driver.findElement(By.xpath(locatorVal));
//		}
//		else if(locatorKey.endsWith("_css"))
//		{
//			ele=  driver.findElement(By.cssSelector(locatorVal));
//		}
//		else if(locatorKey.endsWith("_name"))
//		{
//			ele=  driver.findElement(By.name(locatorVal));
//		}
		WebElement ele = driver.findElement(getLocator(locatorKey));
		
		//		System.out.println("Returns Ele");
		return ele;		
	}

	public boolean isElementPresent(String locatorKey)
	{
		String locatorValue=null;
		System.out.println("Checking the presence of :"+locatorKey);
		//		WebDriverWait wait =  new WebDriverWait(driver, 20);// deprecate
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));// new 
		// if ele is not present . false
		try
		{
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));// if we use xpath,css
			locatorValue= readPropertyValue(locatorKey);
			
			// optimise
//			if(locatorKey.endsWith("_id"))
//			{				
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_xpath"))
//			{				
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_css"))
//			{				
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_name"))
//			{				
//				wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locatorValue)));;
//			}
//			else
//			{
//				error_Msg_LocatorName(locatorKey);
//			}
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));//
			
		}
		catch (Exception e) {
			return false;
		}
		return true;		
	}

	public boolean isElementVisible(String locatorKey)
	{
		String locatorValue=null;
		System.out.println("Checking the visibility of :"+locatorKey);
		//		WebDriverWait wait =  new WebDriverWait(driver, 20);// deprecate
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));// new 
		// if ele is not visible . false
		try
		{
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorKey)));// if we use xpath, css..etc
			//An expectation for checking that an element is present on the DOM of a page and visible. Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
//			locatorValue= prop.getProperty(locatorKey); // always reaed based on env ,
			locatorValue= envProp.getProperty(locatorKey);
			//or
			locatorValue = readPropertyValue(locatorKey);
			//optimise
//			if(locatorKey.endsWith("_id"))
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_xpath"))
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_css"))
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));;
//			}
//			else if(locatorKey.endsWith("_name"))
//			{
//				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));;
//			}
//			else
//			{
//				error_Msg_LocatorName(locatorKey);
//			}
			//or 
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));
		}
		catch (Exception e) {
			return false;
		}
		return true;		
	}


	public boolean isElementInteractable(String locator)
	{
		System.out.println("Checking the Element is Interactable of :"+locator);
		//		WebDriverWait wait =  new WebDriverWait(driver, 20);// deprecate
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(20));// new 
		// if ele is not visible . false
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			//An expectation for checking an element is visible and enabled such that you can click it.

		}
		catch (Exception e) {
			return false;
		}
		return true;		
	}

	public String readPropertyValue(String locatorKey)
	{
		String val= envProp.getProperty(locatorKey);
		// if key is not found, handle ?????
		System.out.println("Read locatorKey:"+locatorKey + ", Value="+val);
		return val;		
	}
	
	public By getLocator(String locatorKey)
	{
		By by =null;
		String locatorVal = readPropertyValue(locatorKey);
		if(locatorKey.endsWith("_id"))
		{
//			ele=  driver.findElement(By.id(locatorVal));
			 by= By.id(locatorVal);
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by= By.xpath(locatorVal);
		}
		else if(locatorKey.endsWith("_css"))
		{
			by= By.cssSelector(locatorVal);
		}
		else if(locatorKey.endsWith("_name"))
		{
			by= By.name(locatorVal);
		}
		else
		{
			error_Msg_LocatorName(locatorKey);
		}
		return by;
	}
	
	public void error_Msg_LocatorName(String locatorKey)
	{
		System.out.println("Plz check locator key name='"+locatorKey + "'.It is not following Automation standards.i.e always prefer ends _name, _id,_xpath, _css..etc.");
	}

	
}
