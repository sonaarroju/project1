package project;

import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Category {
	public Menu menu=null;
	public Category(WebDriver driver)
	{
	menu= PageFactory.initElements(driver, Menu.class);
	}
	@FindBy(id="category")
	WebElement category;
	public void selectcat() throws Exception
	{
		category.click();
		FileInputStream fi=new FileInputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		Thread.sleep(5000);
		XSSFWorkbook wbo=new XSSFWorkbook(fi);
		XSSFSheet sht=wbo.getSheet("Select Category");
		List<WebElement>drop1=category.findElements(By.tagName("option"));
		Row r;
		for(int i=2;i<drop1.size();i++)
		{
			r=sht.getRow(i);
			r.createCell(1).setCellValue(drop1.get(i).getText());
			String expected=r.getCell(0).getStringCellValue();
			String actual=drop1.get(i).getText();
			r.createCell(1).setCellValue(actual);
			if(expected.equals(actual))
			{
				r.createCell(2).setCellValue("pass");
				
			}
			else
			{
				r.createCell(2).setCellValue("fail");
			}
		}
		Thread.sleep(300);
		FileOutputStream fso=new FileOutputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		Thread.sleep(5000);
		wbo.write(fso);
		wbo.close();
		
		
	}
	
		
	}



