package Sharecaar_TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Sharecaar_Utilities.Sharecaar_Signup_Readconfig;

public class Sharecaar_Signup_BaseClass {
	public static WebDriver driver;
	 public static Logger log;
	 
	 Sharecaar_Signup_Readconfig sr=new  Sharecaar_Signup_Readconfig();
	 public String URL=sr.getApplicationURL();
	 public String Firstname=sr.getFirstname();
	 public String Lastname=sr.getLastname();
	 public String Email=sr.getEmali();
	 public String Contact=sr.getcontact();
	 public String Password=sr.getPassword();
	 public String ConfirmPassword=sr.getConfirmPassword();
	 
	 @BeforeClass
		public void OpenApplication()
		{
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			log=Logger.getLogger(this.getClass());
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\log4j.properties");
			driver.get(URL);
			driver.manage().window().maximize();
			
		}
		@AfterClass
		public void CloseApplication()
		{
			driver.close();
		}
		public void captureScreen(WebDriver driver,String name) throws IOException {
			
			//initialize
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File target=new File("./Screenshot/"+name+".png");
			FileUtils.copyFile(src, target);
			log.info("screenshot is taken");
		}


}
