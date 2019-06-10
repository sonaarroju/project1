package project;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellerLogin {
	
	public Menu menu=null;
	public SellerLogin(WebDriver driver)
	{
	menu= PageFactory.initElements(driver, Menu.class);
	}
	@FindBy(name="username")
	public static WebElement username;
	
	@FindBy(name="password")
	public static WebElement password;
	
	@FindBy(xpath = "//button[@type='submit'][contains(.,'Login')]")
	public static WebElement login;
	
public void Slogin(String u, String p)
{
	username.clear();
	username.sendKeys(u);
	password.clear();
	password.sendKeys(p);
	login.click();
	
}



}
