package RegressionTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import CommonCode.BaseClass;
import pages.fbhome;

public class propertiesNewTest extends BaseClass {
  
	@Test (groups = {"Functional"})
  public void f() throws IOException {
	  
	  Properties prop = new Properties();
	  FileInputStream fin=new FileInputStream("C:\\Users\\arian\\eclipse-workspace\\SeleniumProject2\\parametersdata.properties");    
	  prop.load(fin);
	  
	  String email = prop.getProperty("Email");
	  String password = prop.getProperty("Password");
	  
	  fbhome ob = new fbhome(driver);
	  ob.emailid(email);
	  ob.password(password);
	  
	  ob.findlinks();
	  

	  
	  
  }
}
