package main.java.com.pages;

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
	public  void copyFile() {
		String localPath  = "src/main/resources/drivers/chromedriver.exe";
		String sftpPath = "src/main/resources/launcher";
		String sftpHost = "DESKTOP-QLKFNLE";
		String sftpUser = "DELL";
		String sftpPort = "22";
		String sftpPassword = "rashmi123";
		Session session=null;
		ChannelSftp sftpChannel=null;
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
}
