package SeleniumWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.Landingpage;
import resources.Base;

public class homePage extends Base {
	//extending is a type of inheritance
	//extend the class allows all the methods in the class called Base
	
public Logger log=LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("url is opened");
	
	}
	
@Test
public void basePageNavigation() throws IOException, InterruptedException {
	//driver is being returned by initializeDriver() method
	
	Landingpage lp = new Landingpage(driver);
	//ld.closepopup().click();
	Assert.assertEquals(lp.register().getText(), "REGISTER YOUR STORE");
	log.info("REGISTER YOUR STORE TEXT IS PRESENT IN PAGE");
	Thread.sleep(2000);
}



@AfterTest
public void closeBrowser() {
	driver.close();
}
}

