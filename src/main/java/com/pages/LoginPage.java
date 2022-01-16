package main.java.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private final WebDriver driver;
	private final By usernameTextbox = By.id("CovenantUserRegister_UserName");
	private final By passwordTextbox = By.id("CovenantUserRegister_Password");
	private final By loginButton = By.className("btn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enteruserName() {
		return driver.findElement(usernameTextbox);
	}

	public WebElement enteruserPassword() {
		return driver.findElement(passwordTextbox);
	}

	public WebElement clickLoginButton() {
		return driver.findElement(loginButton);
	}
}
