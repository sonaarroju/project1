package project;

import java.awt.Menu;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class User {
	private static Logger log=Logger.getLogger(Testcase1.class);
	FirefoxDriver driver;
	FileInputStream fso;
	FileOutputStream fos;
	XSSFWorkbook wbo;
	XSSFSheet wso;
	
	public Menu menu=null;
	public User(WebDriver driver){
		menu=PageFactory.initElements(driver, Menu.class);
	}
	@BeforeTest
	public void open(){
		DOMConfigurator.configure("log4j.xml");
		 driver=new FirefoxDriver();
		 
		 driver.get("http://webwaves.in/ecommerce/index");
		 log.info("successfully page opened");
		 
	}
	@Test(priority=1)
	public void data1()throws IOException{
		DOMConfigurator.configure("log4j.xml");
		fso=new FileInputStream("C:\\Users\\admin\\Desktop\\Dropdowns Expected.xlsx");
		wbo=new XSSFWorkbook(fso);
		wso=wbo.getSheet("userpage");
		Row r;
		List<WebElement>links=driver.findElements(By.tagName("a"));
		r=wso.getRow(1);
		r.createCell(0).setCellValue(links.size());
		log.info("successfully linkscount is displayed");
		// get visible links and hidden links 
		int count=0;
		for (int i=0;i<links.size();i++){
			if(links.get(i).isDisplayed())
			{
				count++;
				}
		}
		r.createCell(1).setCellValue(count);
		r.createCell(2).setCellValue(links.size()-count);
		log.info("successfully visible links and hidden links are displayed");
		fos=new FileOutputStream("C:\\Users\\admin\\Desktop\\Dropdowns Expected.xlsx");
		wbo.write(fos);
			
	}
	 
	public void data2() throws IOException{
		DOMConfigurator.configure("log4j.xml");
		fso=new FileInputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		wbo=new XSSFWorkbook(fso);
		wso=wbo.getSheet("userpage");
		Row r;
		List<WebElement>links=driver.findElements(By.tagName("a"));
		r=wso.getRow(1);
		for (int i=0;i<links.size();i++){
			String iname=links.get(i).getText();
			links.get(i).click();
			String url=driver.getCurrentUrl();
			
           r.createCell(1).setCellValue(iname);
           r.createCell(2).setCellValue(url);
           log.info("successfully urlnames are displayed");
		}	
		
		fos=new FileOutputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
	wbo.write(fos);
	
	}

	

}
