package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Portalpage {

	public WebDriver driver;
	
	private By storeName = By.cssSelector("[class='sc-iemWCZ.hKymwP']");
	public Portalpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement store() {
		return driver.findElement(storeName);
	}
}
