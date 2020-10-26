package pageObject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityFiles.Cnfgrtn;

public class GooglePage {

	public WebDriver driver;
	public Cnfgrtn cnfgr = new Cnfgrtn();

	@FindBy(name="q")
	WebElement SrchBox;
	
	@FindBy(xpath="//div[@class='sbtc']//child::div[@class='sbl1']")
	List<WebElement> googleList;
	
	@FindBy(xpath="//input[@name='q']//following::a[@href='https://www.policybazaar.com/motor-insurance/two-wheeler-insurance/tvs-scooty-pep-plus/']")
	WebElement web_link;
	
	public GooglePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterText()
	{
		SrchBox.clear();
		SrchBox.sendKeys(cnfgr.getSrchString());
	}
	
	public void displayEntries() throws InterruptedException
	{
        Thread.sleep(2500);
		
	//	List<WebElement> googleList = driver.findElements(By.xpath("//div[@class='sbtc']//child::div[@class='sbl1']"));
				
		for(WebElement we:googleList)
		{
			System.out.println(we.getText());
		}
	}
	
	public void clickLink()
	{
		SrchBox.sendKeys(Keys.ENTER);
		web_link.click();
	}


}
