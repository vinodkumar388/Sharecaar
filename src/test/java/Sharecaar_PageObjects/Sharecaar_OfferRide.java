package Sharecaar_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sharecaar_OfferRide {
	public static WebDriver driver;
	public Sharecaar_OfferRide(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='nav-link header-btn']")
	WebElement clkofferRide;
	@FindBy(id="from_location")
	WebElement txtstartlocation;
	@FindBy(id="to_location")
	WebElement txtTolocation;
	@FindBy(id="pickup_point_2")
	WebElement txtPickuppoint;
	@FindBy(id="onward_date")
	WebElement txtonwarddate;
	@FindBy(id="onward_time")
	WebElement txtonwardtime;
	@FindBy(id="next_btn")
	WebElement clkbutton;
	@FindBy(id="return_date")
	WebElement txtreturn;
	@FindBy(id="return_time")
	WebElement txtreturntime;
	
	public void OfferRide() {
		clkofferRide.click();	
		}
	public void StartLocation() {
		txtstartlocation.sendKeys("Hyderabad");
	}
	public void ToLocation() {
		txtTolocation.sendKeys("Bengaluru");
	}
	public void Pickup() {
		txtPickuppoint.sendKeys("MGBS");
	}
	public void Date() {
		txtonwarddate.sendKeys("27-03-2024");
	}
	public void Time() {
		txtonwardtime.sendKeys("11:05");
	}
	public void Savebutton() {
		clkbutton.click();
	}
	public void Returndate() {
		txtreturn.sendKeys("30-03-2024");
	}
	public void RetutnTime() {
		txtreturntime.sendKeys("10:10");
	}

}
