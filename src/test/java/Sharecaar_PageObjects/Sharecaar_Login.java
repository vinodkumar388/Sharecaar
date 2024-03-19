package Sharecaar_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sharecaar_Login {
	public static WebDriver driver;
	public Sharecaar_Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="email")
	WebElement email;
	@FindBy(name="password")
	WebElement password;
	@FindBy(id="sbtLogin")
	WebElement clklogin;
	public void Email(String Email) {
		 email.sendKeys(Email);
	}
	public void Password(String Password) {
		 password.sendKeys(Password);
	}
	public void login() {
		clklogin.click();
	}

}
