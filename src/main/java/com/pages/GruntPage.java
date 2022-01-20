package main.java.com.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class GruntPage {
	private final WebDriver driver;
	public GruntPage(WebDriver driver) {
		this.driver = driver;
	}
	private final By rows=By.xpath("//*[@id='listeners']/*/table/tbody/tr");
	
	public static  void copyFile() throws IOException {
		BasePage basePage=new BasePage();
		Session session=null;
		ChannelSftp sftpChannel=null;
		String localPath = basePage.readPropertyData("localPath");
		String sftpPath = basePage.readPropertyData("sftpPath");
		String sftpHost = basePage.readPropertyData("sftpHost");
		String sftpUser = basePage.readPropertyData("sftpUser");
		String sftpPort = basePage.readPropertyData("sftpPort");
		String sftpPassword = basePage.readPropertyData("sftpPassword");
		try{		
			JSch jsch = new JSch();
			session = jsch.getSession(sftpUser, sftpHost, Integer.valueOf(sftpPort));
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(sftpPassword);
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect(100000);
			Channel channel = session.openChannel("sftp");
			sftpChannel = (ChannelSftp) channel;
			sftpChannel.connect(60000);
			sftpChannel.put(localPath, sftpPath);
			runProgram() ;
		} catch (SftpException | JSchException e) {
			e.printStackTrace();
		}
		finally
		{
			sftpChannel.exit();
			session.disconnect();
		}
	}
	public int rowsCount() {
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(rows));

		return driver.findElements(rows).size();
		
	}
	
	private static void runProgram() {
		Runtime rt= Runtime.getRuntime();
		try {		
			BasePage basePage=new BasePage();
			String filename = "src\\main\\resources\\GruntHTTP.exe";
			String workingDirectory = System.getProperty("user.dir");
			String absoluteFilePath = "";
			absoluteFilePath = workingDirectory + File.separator + filename;
			System.out.println("Final filepath : " + absoluteFilePath);
			rt.exec(absoluteFilePath);
			
		} catch (Exception e) {
			System.out.println("test");
		}
	}
}
