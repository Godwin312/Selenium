package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("C:\\QA\\Testing\\wetransfer_build-xml_2022-12-03_2020\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		System.out.println(prop.getProperty("browser"));
		String browser = prop.getProperty("browser");
		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\QA\\SeleniumJars\\geckodriver.exe");
	        driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\QA\\SeleniumJars\\chromedriver.exe");
	        driver = new ChromeDriver();
		}
		
		PageFactory.initElements(driver, this);
		}
	
	public void openLoginPage() {
		driver.get("https://secure.royalbank.com/statics/login-service-ui/index#/full/signin?_gl=1*5x7r2h*_ga*MzUwMDIxODc0LjE2NzgwNzEyNTI.*_ga_89NPCTDXQR*MTY3ODA3MTI1MS4xLjAuMTY3ODA3MTI1MS42MC4wLjA.&_ga=2.39373991.544815884.1678071252-350021874.1678071252&LANGUAGE=ENGLISH");
		
	
	
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(a);
		  driver.findElement(By.xpath("//span[@id='signinNext']")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("password")).sendKeys(b);
		  driver.findElement(By.id("signinNext")).click();
		  Thread.sleep(3000);
	}
	
	public void loginWhClient() throws InterruptedException {
		  Thread.sleep(1500);
		  driver.findElement(By.xpath("//span[@id='signinNext']")).click();
		
	}
	
	
	public String readPasswordErr() {
		  String actualErr = driver.findElement(By.id("rbc-error0")).getText();
		  System.out.println(actualErr);
		  return actualErr;
	}
	
	public String readClientErr() {
		  String actualErr = driver.findElement(By.id("rbc-error0")).getText();
		  System.out.println(actualErr);
		  return actualErr;
	}
	
	public String readClientPasswordErr() {
		  String actualErr = driver.findElement(By.xpath("//h6[@class='alertHeading']")).getText();
		  System.out.println(actualErr);
		  return actualErr;
	}
	
	public String titlePage() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle;
		
	}

}
