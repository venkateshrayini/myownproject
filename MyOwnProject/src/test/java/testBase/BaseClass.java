package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public static WebDriver driver;
	
	public ResourceBundle rb;
	
	public Logger logger;
	
	@BeforeClass(groups = { "Master", "Sanity", "Regression" })
	@Parameters("browser")
	public void setup(String br) {
		
		logger = LogManager.getLogger(this.getClass()); //This is log4j
		
		rb=ResourceBundle.getBundle("config");
		
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable notification");*/
		
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}
		
		//WebDriverManager.chromedriver().setup(); - No need to use in the latest version of Selenium
		driver= new ChromeDriver();
		//driver.manage().deleteAllCookies();
		driver.get(rb.getString("appURL"));//taken the property file from config.properties = https://demo.nopcommerce.com/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" })
	public void teardown() {
		driver.close();
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
}
