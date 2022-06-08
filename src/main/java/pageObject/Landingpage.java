package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {

	public WebDriver driver;
	// driver in this case is a variable created in the class
	//it's a good practice that variables of a class should be only
	//private to that class. only the methods of a class should be exposed

	private By register = By.cssSelector("[text='REGISTER YOUR STORE']");
	
	private By signin= By.xpath("//button[@text='Login']");
	public Landingpage(WebDriver driver) {
		// create a constructor in landing page class for reuse in other classes
		this.driver = driver;
	}

	public WebElement register() {
		return driver.findElement(register);
	}

	public Loginpage signin() {
		driver.findElement(signin).click();
		 Loginpage lg = new Loginpage(driver);
		 return lg;
	}
	

}
