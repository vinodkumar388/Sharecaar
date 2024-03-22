package Sharecaar_TestCases;

import org.testng.annotations.Test;

import Sharecaar_PageObjects.Sharecaar_Login;
import Sharecaar_PageObjects.Sharecaar_OfferRide;

public class Sharecaar_OfferRide_Test extends Sharecaar_BaseClass {
	@Test
	public void Sharecaar_OfferRide_Test() throws InterruptedException {
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
		Sharecaar_OfferRide so=new Sharecaar_OfferRide(driver);
		so.OfferRide();
		log.info("OfferRide button clicked");
		Thread.sleep(3000);
		so.StartLocation();
		log.info("Start location entered");
		Thread.sleep(3000);
		so.ToLocation();
		log.info("To location entered");
		Thread.sleep(3000);
		so.Pickup();
		log.info("Pick location entered");
		Thread.sleep(3000);
		so.Date();
		log.info("Date is entered");
		Thread.sleep(3000);
		so.Time();
		log.info("Time is entered");
		Thread.sleep(3000);
		so.Returndate();
		log.info("Return Date is entered");
		Thread.sleep(3000);
		so.RetutnTime();
		log.info("Return time is entered");
		Thread.sleep(3000);
		so.Savebutton();
		log.info("save button is clicked");
		Thread.sleep(8000);
		
	}

}
