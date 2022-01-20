package main.java.tests;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import main.java.com.base.DriverInstance;
import main.java.com.pages.GruntPage;

public class Grunt extends DriverInstance {

	@Test
	public void gruntConCheck () throws IOException {
	GruntPage gruntPage= new GruntPage(driver);
	GruntPage.copyFile();
	assertTrue(gruntPage.rowsCount()>=1);		
	}

}