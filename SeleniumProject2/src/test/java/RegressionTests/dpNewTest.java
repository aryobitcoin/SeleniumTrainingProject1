package RegressionTests;

import org.testng.annotations.Test;

import CommonCode.BaseClass;
import pages.fbhome;

import org.testng.annotations.DataProvider;

//This class is made to practice data providers
//using data providers we don't need to hardcode email and pass

public class dpNewTest extends BaseClass {
	
	
  @Test(dataProvider = "dp")
  public void f(String email, String pass) throws InterruptedException {
	  
	  fbhome ob = new fbhome(driver);
	  ob.emailid(email);
	  ob.password(pass);
	  ob.signupclick();
	  //ob.loginclick();
	  Thread.sleep(5000);
	  ob.closesignup();
	  //driver.navigate().back();
	  
	  
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "abc@yahoo.com", "a12345" },
      new Object[] { "def@gmail.com", "b12345" },
    };
  }
}
