package main.java.com.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class DriverInstance {
	public WebDriver driver;
	public DriverInstance() {
		driver=null;
	}
	@BeforeClass
	public void intiateDriver() {
		driver=this.getChromeDriver();
		driver.get("https://127.0.0.1:7443/covenantuser/login");
	}
	
	private WebDriver getChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		ChromeDriverService service=new ChromeDriverService.Builder().usingDriverExecutable(new File("./src/main/resources/drivers/chromedriver.exe"))
				.usingAnyFreePort()
				.build();		
		File destinationDir = new File("./src/main/resources/launcher");
		 Map<String, Object> prefs = new HashMap<>();
		// prefs.put("download.default_directory", destinationDir.getAbsolutePath());
		 prefs.put("download.default_directory", "C:\\Users\\DELL\\NewWorkspace\\convenant\\src\\main\\resources\\launcher");
		 prefs.put("download.prompt_for_download", false);
		 prefs.put("profile.default_content_settings.popups", 0);
		 //prefs.put("download.extensions_to_open", "exe");
		 prefs.put("safebrowsing.enabled", "false");		
		 options.setExperimentalOption("prefs", prefs);
		 
		    ChromeDriver driver=new ChromeDriver(service,options);	
		    
		return driver;
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}
}
