package sel2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBr {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void setup(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Software\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", "C:/Software/drivers/chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "C:/Software/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Browser is not correct");
		}
	}
	
	@Test
	public void petStoreTC1() throws InterruptedException {
		driver.get("https://petstore.octoperf.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Enter")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Sign In")).click();
		Thread.sleep(3000);
		//driver.findElement(By.name("username")).sendKeys("j2ee");
		driver.findElement(By.cssSelector("[id*=ripe]")).sendKeys("j2ee");
	//	driver.findElement(By.xpath("//input[contains(@id,'ripes')]")).sendKeys("j2ee");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("j2ee");
		Thread.sleep(3000);
		driver.findElement(By.name("signon")).click();
		driver.quit();
	}

}
