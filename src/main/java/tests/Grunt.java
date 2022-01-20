package main.java.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import main.java.com.base.DriverInstance;
import main.java.com.pages.GruntPage;

public class Grunt extends DriverInstance {

	@Test
	public void validateGruntConnection() {
		GruntPage gruntPage=new GruntPage(driver);
		gruntPage.copyFile() ;
		assertTrue(gruntPage.rowsCount()>=1);	
	}

}