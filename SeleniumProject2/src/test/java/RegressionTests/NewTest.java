package RegressionTests;

import org.testng.annotations.Test;

import CommonCode.BaseClass;
import pages.fbhome;

import java.io.IOException;

public class NewTest extends BaseClass {
	
// in here we don't need before test and after test
	
	
  @Test
  public void f() throws IOException {
	  
	  fbhome ob = new fbhome(driver);
	  ob.emailid("abcdefg@gmail.com");
	  ob.password("123456");
	  //shots();
	  
  }




}
