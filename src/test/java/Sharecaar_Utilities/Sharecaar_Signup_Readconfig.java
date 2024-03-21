package Sharecaar_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Sharecaar_Signup_Readconfig {
	Properties pro;
	public Sharecaar_Signup_Readconfig()
	{
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Sharecaar_Signup.properties");
		try
		{
			FileInputStream fis=new FileInputStream(f);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("URL");
		return url;
	}
	public String getFirstname() {
		String firstname=pro.getProperty("Firstname");
		return firstname;
	}
	public String getLastname() {
		String lastname=pro.getProperty("Lastname");
		return lastname;
	}
	public String getEmali() {
		String email=pro.getProperty("Email");
		return email;
	}
	public String getcontact() {
		String contact=pro.getProperty("Contact");
		return contact;
	}
	public String getPassword() {
		String password=pro.getProperty("Password");
		return password;
	}
	public String getConfirmPassword() {
		String confirmpassword=pro.getProperty("ConfirmPassword");
		return confirmpassword;
	}

}
