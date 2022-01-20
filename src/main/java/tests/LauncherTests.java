package main.java.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.com.base.DriverInstance;
import main.java.com.pages.LauncherPage;
import main.java.com.pages.LoginPage;

public class LauncherTests extends DriverInstance {
	@BeforeClass
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteruserName().sendKeys("rashmi");
		loginPage.enteruserPassword().sendKeys("rashmi123");
		loginPage.clickLoginButton().click();
	}
	LauncherPage launcherPage;
	
	@Test
	public void GenerateLauncher() throws InterruptedException {
		launcherPage= new LauncherPage(driver);
		launcherPage.launchersMenu().click();
		launcherPage.binaryLink().click();
		launcherPage.generateLauncherButton().click();
		launcherPage.deleteFiles();
		launcherPage.download().click();
		launcherPage.isfiledownloaded();
	}
	

	

}
