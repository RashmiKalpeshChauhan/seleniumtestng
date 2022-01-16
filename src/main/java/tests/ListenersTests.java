package main.java.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import main.java.com.base.DriverInstance;
import main.java.com.pages.ListenersPage;
import main.java.com.pages.LoginPage;



public class ListenersTests extends DriverInstance{
	ListenersPage listnersPage;
	
	@BeforeClass
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enteruserName().sendKeys("rashmi");
		loginPage.enteruserPassword().sendKeys("rashmi123");
		loginPage.clickLoginButton().click();
	}
	
	 @Test()
	public void createListners() {
		listnersPage=new ListenersPage(driver);
		listnersPage.listnersMenu().click();
		listnersPage.createButton().click();
		listnersPage.nameTextBox().clear();
		listnersPage.nameTextBox().sendKeys("Listners1");
		listnersPage.bindAddressTextBox().clear();
		listnersPage.bindAddressTextBox().sendKeys("0.0.0.0");
		listnersPage.bindPortTextBox().clear();
		listnersPage.bindPortTextBox().sendKeys("80");
		listnersPage.connectionAdressTextBox().clear();
		listnersPage.connectionAdressTextBox().sendKeys("192.168.1.193");
		listnersPage.selectUseSSl("False");
		listnersPage.selectHttpProfile("CustomHttpProfile");
		listnersPage.submitButton().click();
		assertTrue(listnersPage.rowsCount()>=1);		
	}

}
