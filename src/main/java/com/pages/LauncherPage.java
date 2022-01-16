package main.java.com.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LauncherPage {
	private final WebDriver driver;
	public LauncherPage(WebDriver driver) {
		this.driver = driver;
	}
	private final By launchersMenu = By.id("nav-launchers");
	private final By binaryLink = By.xpath("//*[@href='/launcher/create/5']");
	private final By download = By.id("download");
	private final By generateLauncher = By.id("generate");
	private final By downloadBtn=By.id("download");

	public WebElement waitForElement(By locator) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		//retryingFindClick(locator);
		return driver.findElement(locator);
	}
	
	public WebElement Download() {
		return waitForElement(download);
	}
	public WebElement launchersMenu() {
		return waitForElement(launchersMenu);
	}
	public WebElement binaryLink() {
		return waitForElement(binaryLink);
	}
	public WebElement generateLauncherButton() {
		return waitForElement(generateLauncher);
	}
	public WebElement download() {
		return waitForElement(downloadBtn);
	}
	public void deleteFiles() {
		File file = new File("./src/main/resources/launcher","GruntHTTP.exe");
		file.delete();
	}
	public void isfiledownloaded() {
		File dir = new File("./src/main/resources/launcher");	
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		        wait.pollingEvery(Duration.ofSeconds(2));
		        wait.withTimeout(Duration.ofSeconds(30));
		        wait.until(x -> {
		            File[] filesInDir = dir.listFiles();
		            for (File fileInDir : filesInDir) {
		                if (fileInDir.getName().startsWith("GruntHTTP")) {
		                    return true;
		                }
		            }
		            return false;
		        });
	}
}
