package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage 
{
	public WebDriver driver;
	public loginpage(WebDriver ldriver)
	{
		driver = ldriver;
		PageFactory.initElements(ldriver,this );
	}
	@FindBy(xpath = ("//input[@id='Email']"))
	WebElement email;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement pwd;
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement login;
	
	public void setusername(String username)
	{
		email.clear();
		email.sendKeys(username);
		
	}
	public void setpassword(String password) 
	{
		pwd.clear();
		pwd.sendKeys(password);
	}
	public void loginbtn()
	{
	login.click();
	}
	public String getpagetitle()
	{
		return driver.getTitle();
		
	}
	
	
}