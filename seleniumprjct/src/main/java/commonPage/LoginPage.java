package commonPage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPage {
	PageFactory page=new PageFactory();
	
	@BeforeTest
	public void prereq() {
		System.out.println("running ...");
	}
	
	@Parameters({"browser"})
	@Test(priority = 1)
	public void launchBrowser(String browser) throws InterruptedException {
		String respository=new File(System.getProperty("user.dir")).getAbsolutePath();
		System.out.println("your inside repository "+respository+"");
		WebDriver driver;
		if (browser.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();	
			 driver.get("https://www.google.com");
			
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.ie.driver", respository+"\\browsers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://www.google.com");
			Thread.sleep(5);
			driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).click();
			driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("selenium");
			Thread.sleep(5);
			driver.findElement(By.xpath("//*[@class='gNO89b']")).click();
			Thread.sleep(5);
			System.out.println("sucful");
			driver.close();
			
		}else if(browser.equalsIgnoreCase("iexplorer")){
			System.setProperty("webdriver.chrome.driver", "");
			driver=new InternetExplorerDriver();
			
		}else {
			System.out.println("user choosen browser "+browser+" not found/available");
		}
		
	
	}

}
