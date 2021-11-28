package CommonCode;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;

public class BaseClass implements ITestListener {
	
//In this file we are gonna put all the functions such as openning the browser, closing the browser, take screenshot and etc. 
	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((BaseClass)result.getInstance()).driver;
		try {
			shots("passed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((BaseClass)result.getInstance()).driver;
		try {
			shots("failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public WebDriver driver;

	
  @BeforeTest (alwaysRun = true)
  @Parameters({"brow","url"})
  public void browser(String brow, String url) throws InterruptedException {
	  
	  if(brow.equalsIgnoreCase("chrome"))
	  {	  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\arian\\eclipse-workspace\\SeleniumProject2\\Drivers\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get(url);
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
	  }
	  else if(brow.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\arian\\eclipse-workspace\\SeleniumProject2\\Drivers\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get(url);
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
	  }
	  else
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\arian\\eclipse-workspace\\SeleniumProject2\\Drivers\\msedgedriver.exe");
		  driver = new EdgeDriver();
		  driver.get(url);
		  driver.manage().window().maximize();
		  Thread.sleep(4000);
	  }
  }

  @AfterTest (alwaysRun = true)
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
	  
  }
  
  public void shots(String status) throws IOException {
	  Date dt = new Date();
	  String strdate=dt.toString().replace(" ", "_").replace(":", "_");
	  File cap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(cap, new File ("C:\\Users\\arian\\eclipse-workspace\\SeleniumProject2\\pictures\\"+status+"\\"+strdate+".png"));
	 }


}
