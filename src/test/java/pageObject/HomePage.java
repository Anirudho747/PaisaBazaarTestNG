package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilityFiles.Cnfgrtn;


public class HomePage {

	public WebDriver driver;
	public Cnfgrtn cnfgr = new Cnfgrtn();

	@FindBy(xpath="//input[@placeholder='Enter Your Bike Number (eg. DL1SB1234)']")
	WebElement Vehicle_nmbr;
	
	@FindBy(xpath="//span[@class='tvs']")
	WebElement Vehicle_make;
	
	@FindBy(xpath="//b[text()='SCOOTY']")
	WebElement Vehicle_model;
	
	@FindBy(xpath="//b[text()='PEP PLUS (90 CC)']")
	WebElement Vehicle_version;
	
	@FindBy(xpath="//b[text()='2017']")
	WebElement Vehicle_year;
	
	@FindBy(xpath="//li[text()='Expired Within 90 Days']")
	WebElement Vehicle_cntrct;
	
	@FindBy(css="#alertShow > div > div.PopUpsection > ul > li:nth-child(3)")
	WebElement Vehicle_last;
	
	@FindBy(xpath="//span[contains(text(),'₹')]")
	List<WebElement> priceList;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void type_VNumber()
	{
		Vehicle_nmbr.clear();
	//	Vehicle_nmbr.sendKeys("TN22HB4858");
		Vehicle_nmbr.sendKeys(cnfgr.getVehicleNumber());
		Vehicle_nmbr.sendKeys(Keys.ENTER);
	}
	
	public void select_VMake()
	{
		Vehicle_make.click();
	}
	
	public void select_VModel()
	{
        Vehicle_model.click();
	}
	
	public void select_Vversion()
	{
		Vehicle_version.click();
	}
	
	public void select_Vyear()
	{
		Vehicle_year.click();
	}
	
	public void select_Vcntrct() throws InterruptedException
	{
		Thread.sleep(2500);
        Vehicle_cntrct.click();
	}
	
	public void select_Vlast()
	{
		Vehicle_last.click();
	}
	
	public void displayPriceandSelect7th() throws InterruptedException
	{
        Thread.sleep(2500);
				
		for(WebElement we:priceList)
		{
			System.out.println("Amount of each subscription is, Rs "+we.getText());
		}
		
		Thread.sleep(2500);
		priceList.get(7).click();
		
	}


}
