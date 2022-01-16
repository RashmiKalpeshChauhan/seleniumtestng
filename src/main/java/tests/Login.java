package main.java.tests;

import org.testng.annotations.Test;

import main.java.com.base.DriverInstance;
import main.java.com.pages.LoginPage;



public class Login extends DriverInstance {
	@Test(groups={"Login.login"})
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteruserName().sendKeys("rashmi");
		loginPage.enteruserPassword().sendKeys("rashmi123");
		loginPage.clickLoginButton().click();
	}
	
}
