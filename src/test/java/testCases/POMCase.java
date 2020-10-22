package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustDetailsPage;
import pageObject.GooglePage;
import pageObject.HomePage;

public class POMCase {

	public WebDriver driver;
	public GooglePage gp;
	public HomePage hp;
	public CustDetailsPage cdp;
	
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(250, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void google() throws InterruptedException
	{
		driver.get("https://www.google.com/");
		gp = new GooglePage(driver);
		gp.enterText();
		gp.displayEntries();
		gp.clickLink();
	}
	
	@Test(priority=2,dependsOnMethods= {"google"})
	public void homePage() throws InterruptedException
	{
		 hp = new HomePage(driver);
		 hp.type_VNumber();
		 hp.select_VMake();
		 hp.select_VModel();
		 hp.select_Vversion();
		 hp.select_Vyear();
		 hp.select_Vcntrct();
		 hp.select_Vlast();
		 hp.displayPriceandSelect7th();
	}
	
	@Test(priority=3,dependsOnMethods= {"homePage"})
	public void custDetailsPage() throws InterruptedException
	{
		cdp = new CustDetailsPage(driver);
		cdp.typeName();
		cdp.typeMobile();
		cdp.typeEmail();
		cdp.typeAddress();
		cdp.typePinCode();
	    cdp.clickNext();
	    cdp.typeNomineeName();
		cdp.clickNext();
		cdp.typeChasisNumber();
		cdp.typeEngineNumber();
		cdp.clickNext();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();	
	}
	
	}


