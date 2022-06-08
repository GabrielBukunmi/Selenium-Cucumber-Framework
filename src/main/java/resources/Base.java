package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.apache.commons.io.FileUtils;

public class Base {
//let's use this class for codes that needs to be run all the time in the test cases
	// e.g invoking chrome driver
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		// chrome
		prop = new Properties();
		//System.getProperty("user.dir") gives the current project path
		FileInputStream filename = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(filename);
		// to load from Jenkins, make the property a system property
		// maven command is mvn test -Dbrowser=chrome. this will be passed in jenkins
		//String browserName = System.getProperty("browser");

		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			if(browserName.contains("headless")) {
			option.addArguments("headless");
			//headless means it will run without opening the chrome browser
			}

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver(option);
			driver.manage().window().maximize();
		} else if (browserName.equals("firefox")) {
			// firefox code
		}

		else if (browserName.equals("edge")) {
			// edge code
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\odunlamib\\Desktop\\Selenium_Data\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();
			driver.manage().window().maximize();

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

		return driver;
	}

	public String getScreenshotpath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty(("user.dir") + "\\reports\\" + testCaseName + ".png");
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		// so we can use the destination elsewhere
	}
}
