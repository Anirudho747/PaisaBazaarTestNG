package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustDetailsPage;
import pageObject.GooglePage;
import pageObject.HomePage;
import utilityFiles.ExcelClass;

public class POMDP2 {

	public WebDriver driver;
	public GooglePage gp;
	public HomePage hp;
	public CustDetailsPage cdp;
	String path= null;
	
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
	
	@Test (dataProvider = "getCellData",dataProviderClass = ExcelClass.class,priority=3)
    public void custdetailsPage (String val,String val2,String val3,String val4,String val5,String val6,String val7,String val8) {
        System.out.println("Passed Parameter Is : " + val);
        System.out.println("Passed Parameter Is : " + val2);
        System.out.println("Passed Parameter Is : " + val3);
        System.out.println("Passed Parameter Is : " + val4);
        System.out.println("Passed Parameter Is : " + val5);
        System.out.println("Passed Parameter Is : " + val6);
        System.out.println("Passed Parameter Is : " + val7);
        System.out.println("Passed Parameter Is : " + val8);
    }

}
