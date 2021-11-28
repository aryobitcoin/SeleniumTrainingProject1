package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class fbhome {
	
	public static WebDriver driver;

	@FindBy (id="email") WebElement email;  
	@FindBy (id="pass") WebElement pass; 
	@FindBy (xpath="//*[@name='login']") WebElement login; 
	@FindBy (xpath="//a[@data-testid=\"open-registration-form-button\"]") WebElement signup;
	@FindBy	(xpath="//img[@id=\"u_e_9_66\"]") WebElement closesignup;
	
	public fbhome(WebDriver driver)
	{
		fbhome.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void emailid(String emailtext)
	{
		email.clear();
		email.sendKeys(emailtext);
	}
	
	public void password(String passtext)
	{
		pass.sendKeys(passtext);
	}
	
	public void loginclick()
	{
		login.click();
	}
	
	public void signupclick()
	{
		signup.click();
	}
	
	public void closesignup()
	{
		closesignup.click();
	}
	
	//to find all the links in the fbhome page
	public void findlinks()
	{
		//since we want to find more than one Element then we use findElements
		List<WebElement> lis = driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + lis.size());
		
		for (int i=0; i < lis.size(); i++)
		{
			System.out.println(lis.get(i).getAttribute("href"));
		}
	}
}




