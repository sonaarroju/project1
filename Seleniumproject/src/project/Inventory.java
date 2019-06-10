package project;

import java.awt.Menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory {
	
	public Menu menu=null;
	public Inventory(WebDriver driver)
	{
	menu= PageFactory.initElements(driver, Menu.class);
	}
		
	
	@FindBy(id="category")
	WebElement category;
	@FindBy(id="stock")
	WebElement stock;
	
	public void category()
	{
		category.click();
	}
	public void stock()
	{
		stock.click();
}


}
