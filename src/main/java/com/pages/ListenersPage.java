package main.java.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListenersPage {
	private final WebDriver driver;
	public ListenersPage(WebDriver driver) {
		this.driver = driver;		
	}
	private final By listenersMenu = By.id("nav-listeners");
	private final By createButton = By.xpath("//*[@href='/listener/create']");
	private final By name = By.id("Name");
	private final By bindAddress = By.id("BindAddress");
	private final By bindPort = By.id("BindPort");
	private final By connectionPort = By.id("ConnectPort");
	private final By connectionAdress = By.id("ConnectAddresses_0_");
	private final By ssldropdown=By.id("UseSSL");
	private final By httpProfile=By.id("ProfileId");
	private final By submitButton=By.xpath("//*[@id='http']/form/button[@type='submit']");
	private final By rows=By.xpath("//*[@id='listeners']/*/table/tbody/tr");
	
	  public WebElement waitForElement(By locator) {
		  new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
          return driver.findElement(locator);
	    }
	public WebElement listnersMenu() {
		return waitForElement(listenersMenu);
		
	}
	public WebElement createButton() {
		return waitForElement(createButton);
		
	}
	public WebElement nameTextBox() {
		return waitForElement(name);
	}
	public WebElement bindAddressTextBox() {
		return driver.findElement(bindAddress);
	}
	public WebElement bindPortTextBox() {
		return driver.findElement(bindPort);
	}
	public WebElement connectionPortTextBox() {
		return driver.findElement(connectionPort);
	}
	public WebElement connectionAdressTextBox() {
		return driver.findElement(connectionAdress);
	}
	public void selectUseSSl(String text) {
		Select options = new Select(driver.findElement(ssldropdown));
		options.selectByValue(text);
	}
	public void selectHttpProfile(String text) {
		Select options = new Select(driver.findElement(httpProfile));
		options.selectByVisibleText(text);
	}
	public WebElement submitButton() {
		return driver.findElement(submitButton);
		
	}
	public int rowsCount() {
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(rows));

		return driver.findElements(rows).size();
		
	}
}
