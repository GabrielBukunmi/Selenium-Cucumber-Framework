package SeleniumWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import pageObject.Loginpage;
import resources.Base;

public class Login extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
 public WebDriver driver;
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver=initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void login(String username, String password) {
		driver.get(prop.getProperty("url"));
		Landingpage ld= new Landingpage(driver);
		Loginpage lg=ld.signin();
			
	
		lg.username().sendKeys(username);
		lg.password().sendKeys(password);
		lg.submit().click();
		log.info("login is successful");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different test types should run
		//column stands for the values in the row
		
		Object[][] data = new Object[2][2];
		data[0][0]= "mosope";//1st row, 1st column
		data[0][1]="@Brown123";
		
		data[1][0]="ibk2022";
		data[1][1]="ibk";
		return data;
	}
	
}
