package utils;




import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class productspage {
	public WebDriver driver;

	
	public productspage(WebDriver ldriver)
	{
		driver = ldriver;
				PageFactory.initElements(ldriver,this);
	}	
	

@FindBy(xpath = "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]/p[1]")
WebElement catalog;
@FindBy(xpath = "//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/p[1]")
WebElement product;
@FindBy(xpath = "//tbody/tr[1]/td[8]/a[1]")
WebElement edit;
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[5]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
WebElement uploadbutton;	
@FindBy(xpath = "//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[5]/div[1]/div[1]")	
WebElement multimedia;
@FindBy(xpath = "//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/label[1]")
WebElement scroll;
	public void productspage(String menu)
	
	{
	Actions ac = new Actions(driver);
	{
	ac.moveToElement(catalog).click().build().perform();
	if(menu.equals(" Products"))
	{
	
		ac.moveToElement(product).click().build().perform();
	}
	}
	}
	public void edit() throws InterruptedException
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView();",edit);
				
		Thread.sleep(5000);	
		js.executeScript("arguments[0].click()", edit);
		
	}
	

		public void uploadbutton() throws InterruptedException
		{
			Actions ac = new Actions(driver);
			{
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
				js.executeScript("arguments[0].scrollIntoView();",multimedia);
				Thread.sleep(5000);
				ac.moveToElement(multimedia).click().build().perform();
		
			js.executeScript("arguments[0].scrollIntoView();",uploadbutton);
			Thread.sleep(5000);
			ac.moveToElement(uploadbutton).click().build().perform();
						
			
		}
	}                                                         
}



