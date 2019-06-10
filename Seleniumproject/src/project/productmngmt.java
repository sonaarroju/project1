package project;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productmngmt {
	
	public Menu menu=null;
	public productmngmt(WebDriver driver)
	{
	menu= PageFactory.initElements(driver, Menu.class);
	}
	@FindBy(xpath = "(//i[@class='fa fa-chevron-circle-right drop-icon'])[2]")
	//*[@id="product_menu_id"]/a/i[2]
	 WebElement pm;
	//@FindBy(xpath = "//a[contains(.,'Inventory Control')]")
	@FindBy(xpath ="//*['@Inventory_control']")
	WebElement ic;
	
	public void product()
	{
		pm.click();
	}

	public void inventory()
	{
		ic.click();
	}

}
