package Sharecaar_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Sharecaar_PageObjects.Sharecaar_Signup;

public class Sharecaar_SignupTest extends Sharecaar_Signup_BaseClass{
	@Test
	public void Sharecaar_SignupTest() throws InterruptedException, IOException {
		Sharecaar_Signup ss=new Sharecaar_Signup(driver);
		ss.Firstname(Firstname);
		log.info("firstname is entered");
		Thread.sleep(3000);
		ss.Lastname(Lastname);
		log.info("lastname is entered");
		Thread.sleep(3000);
		ss.Email(Email);
		log.info("Email is entered");
		Thread.sleep(3000);
		ss.Contact(Contact);
		log.info("contact no is entered");
		Thread.sleep(3000);
		ss.Password(Password);
		log.info("password is entered");
		Thread.sleep(3000);
		ss.ConfirmPassword(ConfirmPassword);
		log.info("confirm password is entered");
		Thread.sleep(3000);
		ss.enterFrames();
		log.info("enter to the frame");
		Thread.sleep(3000);
		ss.captcha();
		log.info("captcha is clicked");
		Thread.sleep(3000);
		ss.button();
		log.info("signup button is clicked");
		
String exp_result="Login - Sharecaar";
		
		String Act_Result=driver.getTitle();
		
		if(Act_Result.equals(exp_result)) {
			Assert.assertTrue(true);
			log.info("Testcase is Passed");
		}
		else {
			
			captureScreen(driver,"Signup");
			log.info("Screenshot is taken");
			Assert.assertTrue(false);
			
		}
	}

}
