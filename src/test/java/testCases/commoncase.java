package testCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustDetailsPage;
import pageObject.GooglePage;
import pageObject.HomePage;

public class commoncase {
	
	public WebDriver driver;
	public GooglePage gp;
	public HomePage hp;
	public CustDetailsPage cdp;
	

	@Test
	public void allCases() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).clear();
		driver.findElement(By.name("q")).sendKeys("policy bazaar for insurance renewal for scooty pep");
		
	    Thread.sleep(2500);
		
		List<WebElement> googleList = driver.findElements(By.xpath("//div[@class='sbtc']//child::div[@class='sbl1']"));
				
		for(WebElement we:googleList)
		{
			System.out.println(we.getText());
		}
	
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@name='q']//following::a[@href='https://www.policybazaar.com/motor-insurance/two-wheeler-insurance/tvs-scooty-pep-plus/']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Bike Number (eg. DL1SB1234)']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Bike Number (eg. DL1SB1234)']")).sendKeys("TN22HB4858");
		driver.findElement(By.xpath("//input[@placeholder='Enter Your Bike Number (eg. DL1SB1234)']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='tvs']")).click();
		driver.findElement(By.xpath("//b[text()='SCOOTY']")).click();
		driver.findElement(By.xpath("//b[text()='PEP PLUS (90 CC)']")).click();
		driver.findElement(By.xpath("//b[text()='2017']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[text()='Expired Within 90 Days']")).click();
		driver.findElement(By.cssSelector("#alertShow > div > div.PopUpsection > ul > li:nth-child(3)")).click();
	
		List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(text(),'₹')]"));
		
		for(WebElement we:priceList)
		{
			System.out.println("Amount of each subscription is, Rs "+we.getText());
		}
		Thread.sleep(2500);
		priceList.get(7).click();
		
		driver.findElement(By.xpath("//h1//following::input[@name='name']")).clear();
		driver.findElement(By.xpath("//h1//following::input[@name='name']")).sendKeys("Katie Bell");
		
		driver.findElement(By.xpath("//h1//following::input[@name='mobileNo']")).clear();
		driver.findElement(By.xpath("//h1//following::input[@name='mobileNo']")).sendKeys("9005754733");
		
		driver.findElement(By.xpath("//h1//following::input[@name='email']")).clear();
		driver.findElement(By.xpath("//h1//following::input[@name='email']")).sendKeys("xeta@neta.com");
		
		driver.findElement(By.xpath("//h1//following::textarea[@name='address1']")).clear();
		driver.findElement(By.xpath("//h1//following::textarea[@name='address1']")).sendKeys("10,Downing Street");
		
		driver.findElement(By.xpath("//h1//following::input[@name='pincode']")).clear();
		driver.findElement(By.xpath("//h1//following::input[@name='pincode']")).sendKeys("600090");
		
		driver.findElement(By.xpath("//h1//following::button[@name='next']")).click();
		
		driver.findElement(By.xpath("//h1//following::input[@name='nomineeName']")).clear();
		driver.findElement(By.xpath("//h1//following::input[@name='nomineeName']")).sendKeys("Graham Bell");
		
		Thread.sleep(4300);
		
/*		driver.findElement(By.xpath("//h1//following::div[@class='Select-placeholder'][2]")).click();
		driver.findElement(By.xpath("//h1//following::div[@class='Select-placeholder'][2]")).sendKeys(Keys.ARROW_DOWN);
		
		driver.findElement(By.xpath("//h1//following::*[@class='Select-placeholder'][2]")).sendKeys("Father");
		
		Select rltnshp = new Select(driver.findElement(By.xpath("//h1//following::*[@class='Select-placeholder'][2]")));
		rltnshp.selectByValue("Father");
		
		Select Age = new Select(driver.findElement(By.xpath("//h1//following::*[@class='Select-placeholder'][3]")));
		rltnshp.selectByValue("88");
*/		
		driver.findElement(By.xpath("//h1//following::button[@name='next']")).click();
		
		driver.findElement(By.xpath("//input[@id='EngineNumber']")).clear();
		driver.findElement(By.xpath("//input[@id='EngineNumber']")).sendKeys("135790");
		
		driver.findElement(By.xpath("//input[@id='ChasisNumber']")).clear();
		driver.findElement(By.xpath("//input[@id='ChasisNumber']")).sendKeys("246802");
		
		driver.findElement(By.xpath("//h1//following::button[@name='next']")).click();
		
	}


}
