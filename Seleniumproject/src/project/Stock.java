package project;

import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Stock {
	public Menu menu=null;
	public Stock(WebDriver driver)
	{
	menu= PageFactory.initElements(driver, Menu.class);
	}
	@FindBy(id="stock")
	WebElement stock;
	public void stockdropdown() throws IOException
	{
		stock.click();
		FileInputStream fis=new FileInputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		XSSFWorkbook wbo=new XSSFWorkbook(fis);
		XSSFSheet sht=wbo.getSheet("Stock");
		List<WebElement>drop2=stock.findElements(By.tagName("option"));
		Row r;
		for(int i=2;i<drop2.size();i++)
		{
			r=sht.getRow(i);
			r.createCell(1).setCellValue(drop2.get(i).getText());
			String expected=r.getCell(0).getStringCellValue();
			String actual=drop2.get(i).getText();
			r.createCell(1).setCellValue(actual);
			if(expected.equals(actual))
			{
				r.createCell(2).setCellValue("pass");
				
			}
			else {
				r.createCell(2).setCellValue("fail");
				
			}
			
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		wbo.write(fos);
		wbo.close();
		
	}


}
