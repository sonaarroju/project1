package project;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

//import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class Testcase1 {
	private static Logger log=Logger.getLogger(Testcase1.class);
	public static void main(String[] args) throws Exception {
		DOMConfigurator.configure("log4j.xml");
		System.setProperty("webdriver.chrome.driver", "browser\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://webwaves.in/ecommerce/seller/");
		log.info("succ page opened");
		driver.manage().window().maximize();
		
		SellerLogin page1=PageFactory.initElements(driver, SellerLogin.class);
		page1.Slogin("kalpanaQA@gmail.com", "12345");
		log.info("successfully logged in");
		productmngmt page2=PageFactory.initElements(driver, productmngmt.class);
		page2.product();
		log.info("successfully product management logged");
		page2.inventory();
		Category page3=PageFactory.initElements(driver, Category.class);
		page3.selectcat();
		log.info("successfully category logged");
		Stock page4=PageFactory.initElements(driver,Stock.class);
		page4.stockdropdown();
		log.info("successfully stockdropdown logged");
		
	}

}
