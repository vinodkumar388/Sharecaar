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

import Sharecaar_Utilities.Sharecaar_ReadConfig;

public class Sharecaar_BaseClass {
	public static WebDriver driver;
	 public static Logger log;
		
		Sharecaar_ReadConfig rc=new Sharecaar_ReadConfig();
		public String URL=rc.getApplicationURL();
		public String Email=rc.getEmail();
		public String Password=rc.getPassword();
		@BeforeClass
		public void OpenApplication()
		{
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
