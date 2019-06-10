package project;

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
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkscount {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "browser\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://webwaves.in/ecommerce/index");
		driver.manage().window().maximize();
				
		List<WebElement> links1 = driver.findElements(By.tagName("a"));
        FileInputStream fis=new FileInputStream("‪C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");
		
		XSSFWorkbook wbo=new XSSFWorkbook(fis);		
		XSSFSheet sht=wbo.getSheet("links");
		Row r;
		int count=0;
		for(int i=0;i<links1.size();i++)
		{
			r=sht.getRow(i);
			if(links1.get(i).isDisplayed())
			{
				count=count+1;
				r.createCell(0).setCellValue(links1.get(i).getText());
				System.out.println(links1.get(i).getText());
				try {
				links1.get(i).click();
				r.createCell(1).setCellValue(driver.getCurrentUrl());
				driver.navigate().back();
				links1=driver.findElements(By.tagName("a"));
				}
				catch(Exception e) {
					links1.get(i+1).click();
				}
			}
		}
		FileOutputStream fso=new FileOutputStream("C:\\Users\\Arroju\\Desktop\\Dropdowns Expected.xlsx");	
		Thread.sleep(5000);	
		wbo.write(fso);	
		wbo.close();	


	}

}
