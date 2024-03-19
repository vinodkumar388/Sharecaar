package Sharecaar_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Sharecaar_PageObjects.Sharecaar_Login;
import Sharecaar_Utilities.Xlutils;

public class Sharecaar_Login_DataDrivenTest extends Sharecaar_BaseClass{
	@Test(dataProvider="loginexcel1")
	
	public void SharecaarLoginDataDrivenTest(String email, String Pass, String data) throws InterruptedException, IOException {
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\loginexcel1.xlsx";
		Sharecaar_Login sl=new Sharecaar_Login(driver);
		sl.Email(email);
		log.info("email is entered");
		Thread.sleep(3000);
		sl.Password(Pass);
		log.info("password is entered");
		Thread.sleep(3000);
		sl.login();
		log.info("login button is clicked");
		Thread.sleep(3000);
String exp_result="Profile - Sharecaar";
		
		String Act_Result=driver.getTitle();
		
		if(Act_Result.equals(exp_result)) {
			Assert.assertTrue(true);
			for(int i=1;i<=3;i++) 
			   {
				   for(int j=2;j<=2;j++)
				   {
					   Xlutils.setCellData(path, "Sheet1", i, j,"pass");
					   Xlutils.fillGreenColor(path, "Sheet1", i, j);
				   }
			   }
			log.info("Testcase is Passed");
		}
		else {
			log.info("testcase is failed");
			captureScreen(driver,"Sharecaarlogin");
			
			//Assert.assertTrue(false);
			
			for(int i=1;i<=3;i++) 
			   {
				   for(int j=2;j<=2;j++)
				   {
					   Xlutils.setCellData(path, "Sheet1", i, j,"fail");
					   Xlutils.fillRedColor(path, "Sheet1", i, j);
				   }
			   }
			driver.navigate().refresh();
			Assert.assertTrue(false);
			
			
		}
	}
	@DataProvider(name="loginexcel1")
	String [][] getData() throws IOException{
		
		
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\loginexcel1.xlsx";
		int rownum=Xlutils.getRowcount(path, "Sheet1");
		int colcount=Xlutils.getCellcount(path, "Sheet1",1);
		
		String logindata[][]=new String [rownum][colcount];
		 
		for(int i=1;i<=rownum;i++) {//it is represent the rows
			
			for(int j=0;j<colcount;j++) {//it is represent the columns
				logindata[i-1][j]=Xlutils.getCelldata(path, "Sheet1", i, j);///1 0
				
			}
			
		}
		return logindata;
	}
		
	}


