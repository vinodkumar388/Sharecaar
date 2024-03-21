package Sharecaar_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sharecaar_Signup {
	public static WebDriver driver;
	public Sharecaar_Signup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(id="firstName")
	WebElement txtfirstname;
	@FindBy(id="lastName")
	WebElement txtlastname;
	@FindBy(id="email")
	WebElement txtemail;
	@FindBy(id="contactNo")
	WebElement txtcontact;
	@FindBy(id="password")
	WebElement txtpassword;
	@FindBy(id="c_password")
	WebElement txtconfirm;
	@FindBy(xpath="//iframe[@title='reCAPTCHA']")
	WebElement frame;
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement clkcaptcha;
	@FindBy(id="btnSignUpSubmit")
	WebElement clksignup;
	public void Firstname(String Firstname) {
		txtfirstname.sendKeys(Firstname);;
	}
	public void Lastname(String Lastname) {
		txtlastname.sendKeys(Lastname);
	}
	public void Email(String Email) {
		txtemail.sendKeys(Email);
	}
	public void Contact(String Contact) {
		txtcontact.sendKeys(Contact);
	}
	public void Password(String Password) {
		txtpassword.sendKeys(Password);
	}
	public void ConfirmPassword(String ConfirmPassword) {
		txtconfirm.sendKeys(ConfirmPassword);
	}
	public void enterFrames() {
		driver.switchTo().frame(0);
	}
	public void captcha() {
		clkcaptcha.click();
		driver.switchTo().defaultContent();
	}
	public void button() {
		clksignup.click();
	}
	
	

}
