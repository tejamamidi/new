package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Addcustomers {
	WebDriver driver;
	
public  Addcustomers(WebDriver ldriver)
{
driver = ldriver;
PageFactory.initElements(ldriver, this);
}
@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]/i[1]")
WebElement customersmenu;
@FindBy(xpath = "//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]")
WebElement customers;
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]")
WebElement Addbutton;
@FindBy(xpath = "//input[@id='Email']")
WebElement email;
@FindBy(xpath = "//input[@id='Password']")
WebElement password;
@FindBy(xpath = "//input[@id='FirstName']")
WebElement Firstname;
@FindBy(xpath = "//input[@id='LastName']")
WebElement lastname ;
@FindBy(id = "Gender_Male")
WebElement GenderMALE;		
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]")
WebElement GenderFemale  ;
@FindBy(xpath = "Gender_Female")
WebElement dob ;

@FindBy(xpath = "//input[@id='Company']")
WebElement  companyname;
@FindBy(xpath = "//input[@id='IsTaxExempt']")
WebElement taxattempt ;
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]")
WebElement customerroles ;
@FindBy(xpath = "//select[@id='VendorId']")
WebElement vendor ;
@FindBy(xpath = "//input[@id='Active']")
WebElement Activebutton ;
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]")
WebElement save;
@FindBy(xpath = "//input[@id='SearchEmail']")
WebElement emaill;
@FindBy(xpath = "//button[@id='search-customers']")
WebElement search;
@FindBy(xpath = "//table[@id='customers-grid']")
WebElement table;
@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
List<WebElement>tablerow;
@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
List<WebElement>tablecol;
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
WebElement searchbutton;
public void customersmenu(String menu)
{
	
	Actions ac = new Actions(driver);
			{
		ac.moveToElement(customersmenu).click().build().perform();
		if(menu.equals("customers"))
		{
		ac.moveToElement(customers).click().build().perform();
			}}
}
public void Addbutton()
{
	Addbutton.click();
}



public void setemail(String em)
{
	email.sendKeys(em);
}
public void setpassword(String pwd )
{
	password .sendKeys(pwd);
}
public void setfirstname(String fname)
{
Firstname.sendKeys(fname);	
}
public void setlastname(String Lastname)
{
lastname.sendKeys(Lastname);
}
public void setgender(String gender)
{
if(gender.equals("Male"))
{
	GenderMALE.click();
}else if(gender.equals("Female"))
{
	GenderFemale.click();
}
}
public void setdob(String bdd)
{
	JavascriptExecutor js = ((JavascriptExecutor)driver);
    js.executeScript("document.getElementById('DateOfBirth').value = '"+bdd+"'");
}
public void setcompanyname(String com)
{
	companyname.sendKeys("durga");	
}
public void settaxattempt()
{
	taxattempt.click();
}
public void setcustomerroles(String roles)
{
	customerroles.click();
	WebElement item;
	
	if(roles.equals("Administrators"))
	{
		
		 item = driver.findElement(By.xpath("//li[contains(text(),'Administrators')]"));
		 //item.click();
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", item);

	}else if(roles.equals("Guests"))
	{
	item = driver.findElement(By.xpath("//li[contains(text(),'Guests')]"));
	//item.click();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", item);
	}
	
	
}
public void setvendors(String role)
{
	Select as =new Select(vendor);
	as.selectByVisibleText(role);
}
public void Activebutton()
{
	Activebutton.click();
}
public void save()
{
	save.click();
}
 public int rows()
 {
	return tablerow.size();
 }
 public int cols()
 {
	return tablecol.size();
 }
 public void Searchbyemail(String mail)
 {
	 emaill.sendKeys(mail);
 }
 public void clicksearch()
 {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", search);
 }
 public void searchbuton()
 {
	 searchbutton.click();
 }
 
public boolean searchcustomer (String maille)
 {
	 boolean flag = false;
	 for(int i= 1;i<=rows();i++)
	 {
		 WebElement maile = table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr/td[2]"));
		 {
			 System.out.println(maile);
		 }
		if(maille.equals(maile))
		{
			flag = true;		
		}
	 }
	return flag;
	 
 }
}	


