package step_def;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {
	WebDriver driver;
	
	@Given("^user is already on login Page$")
	public void user_is_already_on_login_Page(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahsan\\Documents\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("http://www.freecrm.com");
		 driver.manage().window().maximize();
		
	    
	}

	@When("^title of login page is Free CRM$")
	public void title_of_login_page_is_Free_CRM(){
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", title);
		
	    
	}
//		Regular experession
//		1. \"(.*)\"
//		2. \"([^\"]*)\"
	@Then("^user enters \"(.*)\" and \"(.*)\"$")
	public void user_enters_username_and_password(String username, String password){
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[1]")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='loginForm']/div/input[2]")).sendKeys(password);
	    
	}

	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button(){
//		driver.findElement(By.xpath(".//*[@id='loginForm']/div/div/input")).click();
	    
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page(){
		String title = driver.getTitle();
		System.out.println("Home Page title ::"+title);
		Assert.assertEquals("CRMPRO", title);
	}
	
	@Then("user meves to new contact page")
	public void user_meves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/a"))).build().perform();
		driver.findElement(By.xpath(".//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")).click();
	
	 
	}
	
	@Then ("^user enters contact details \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_contacts_details(String firstname,String lastname,String position){
		
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='first_name']")));
		
		
		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='surname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@maxlength='150']")).sendKeys(position);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		
	}
	
	
	@Then("^close the browser$")
	public void close_the_browser(){
		driver.quit();
		
	}
	

}
