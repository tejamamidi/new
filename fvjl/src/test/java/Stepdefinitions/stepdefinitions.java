package Stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utils.Addcustomers;
import utils.loginpage;
import utils.productspage;

public class stepdefinitions {
	public loginpage lp;
	public Addcustomers ad;
	public productspage pd;
	public Properties configprop;
	public Logger logger;

		WebDriver driver;
		@Before
		public void setupbrowser() throws IOException
		{
			logger =  Logger.getLogger("fvjl");
			PropertyConfigurator.configure("log4j.properties");
		configprop = new Properties();
		FileInputStream config = new FileInputStream("config.properties");
		configprop.load(config);
		String br= configprop.getProperty("browser");
		String url = configprop.getProperty("url");
		if(br.equals("chrome"))
			
		{
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			
		}
		driver.get(url);
		}
		@After
		public void takescreenshot(Scenario scenario) throws IOException, InterruptedException
		{
		    if(scenario.isFailed())
		    {	
		    	TakesScreenshot ts = (TakesScreenshot)driver;
		    	byte[]src = ts.getScreenshotAs(OutputType.BYTES);
		        scenario.attach(src, "image/png", scenario.getName());
		        
		    }
		   
		}

		

		
		@Given("I open browser")
		public void i_open_browser() {
			
			lp = new loginpage(driver);
			lp.getpagetitle();
		    Assert.assertEquals("Your store. Login", lp.getpagetitle()); 
		    logger.info("***lauching browser is successful*****");
		}


		

		@When("^i enter send keys \"([^\"]*)\" And \"([^\"]*)\"$")
		public void i_enter_send_keys_And(String arg1, String arg2) throws Throwable {
		    lp.setusername(arg1);
		    lp.setpassword(arg2);
		    logger.info("***Successfully enter the username and passwords*****"); 
		}

		@When("^i click login$")
		public void i_click_login() throws Throwable {
		   lp.loginbtn();
		   logger.info("***Successfully click the login button*****");
		}

		@Then("^see the dashboardpage$")
		public void see_the_dashboardpage() throws Throwable {
		   Assert.assertEquals("Dashboard / nopCommerce administration", lp.getpagetitle());
		   logger.info("***See the dashboard of nopcommerce*****");
		}

		@When("^i click customers link And i click customers option \"([^\"]*)\"$")
		public void i_click_customers_link_And_i_click_customers_option(String arg1) throws Throwable 
		
		{
			ad = new Addcustomers(driver); 
			ad.customersmenu(arg1);
			logger.info("***Successfully click the customers menu and customers option *****");
		}
		

		@When("^i click Add new button$")
		public void i_click_Add_new_button() throws Throwable {
			
			//ad.Addbutton();
			//logger.info("***click the ADD new button*****");
		}
		@When("^i set customer info$")
		public void i_set_customer_info(DataTable table) throws Throwable {
			for(Map<String, String> deal : table.asMaps(String.class,String.class))
			{
			     ad.Addbutton();
				 ad.setemail(deal.get("Email"));
				 ad.setfirstname(deal.get("firstname"));
				 ad.setgender(deal.get("gender"));
				 ad.setdob(deal.get("Date of birth"));
				 ad.setlastname(deal.get("lastname"));
				  ad.setpassword(deal.get("Password"));
				  ad.setcompanyname(deal.get("companyname"));
				  ad.setcustomerroles(deal.get("customer roles"));
				  ad.setvendors(deal.get("vendor"));
				  ad.save();
				  logger.info("***successfully enter the required details*****");
			}
		  
		}

		
		@When("^i enter all details And click save button$")
		public void i_enter_all_details_And_click_save_button() throws Throwable { 
		  //ad.save(); 
		  //logger.info("***click the save button *****");
		}

		@When("^i enter the sendkeys email \"([^\"]*)\"$")
		public void i_enter_the_sendkeys_email(String arg1) throws Throwable {
		    ad.Searchbyemail(arg1);
		    logger.info("***search option by email *****");
		    
		}
		@When("i click the productpage and {string} option")
		public void i_click_the_productpage_and_option(String string) 
		{
		   pd = new productspage(driver);
		   pd.productspage(string);
		}
		@Then("i see the products page")
		public void i_see_the_products_page() {
			Assert.assertEquals("Products / nopCommerce administration", lp.getpagetitle());
		    
		}
		
		@When("i click the edit option")
		public void i_click_the_edit_option() throws InterruptedException {
			
		    pd.edit();
		}
		
		@When("i click multimedia table and add the picture")
		public void i_click_multimedia_table_and_add_the_picture() throws InterruptedException 
		{
		   pd.uploadbutton();
		}


}
