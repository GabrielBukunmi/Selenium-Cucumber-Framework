package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	public WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//initia
		
	}

	@FindBy(name="userName")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css=".btn.default.mb-5")
	WebElement submit;
	
	public WebElement username() {
		return email;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement submit() {
		return submit;
	}
}
