package Sharecaar_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Sharecaar_PageObjects.Sharecaar_Login;

public class Sharecaar_LoginTest extends Sharecaar_BaseClass {
	@Test
	public void Sharecaar_logintest() throws InterruptedException, IOException {
		Sharecaar_Login sl=new Sharecaar_Login(driver);
		sl.Email(Email);
		log.info("email is entered");
		Thread.sleep(3000);
		sl.Password(Password);
		log.info("password is entered");
		Thread.sleep(3000);
		sl.login();
		log.info("login button is clicked");
		Thread.sleep(3000);
		
String exp_result="Profile - Sharecaar";
		
		String Act_Result=driver.getTitle();
		
		if(Act_Result.equals(exp_result)) {
			Assert.assertTrue(true);
			log.info("Testcase is Passed");
		}
		else {
			
			captureScreen(driver,"login");
			log.info("Screenshot is taken");
			Assert.assertTrue(false);
			
		}
	}

}
