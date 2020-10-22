package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustDetailsPage {

public WebDriver driver;
	
	@FindBy(xpath="//h1//following::input[@name='name']")
	WebElement Name;
	
	@FindBy(xpath="//h1//following::input[@name='mobileNo']")
	WebElement MobileNo;
	
	@FindBy(xpath="//h1//following::input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//h1//following::textarea[@name='address1']")
	WebElement Address;
	
	@FindBy(xpath="//h1//following::input[@name='pincode']")
	WebElement PinCode;
	
	@FindBy(xpath="//h1//following::button[@name='next']")
	WebElement Next;
	
	@FindBy(xpath="//h1//following::input[@name='nomineeName']")
	WebElement NomineeName;
	
	@FindBy(xpath="//input[@id='EngineNumber']")
	WebElement EngineNumber;
	
	@FindBy(xpath="//input[@id='ChasisNumber']")
	WebElement ChasisNumber;
	
	public CustDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeName()
	{
		Name.clear();
		Name.sendKeys("Katie Bell");
	}
	
	public void typeMobile()
	{
		MobileNo.clear();
		MobileNo.sendKeys("9005851800");
	}
	
	public void typeEmail()
	{
		Email.clear();
		Email.sendKeys("Krisp@Krisp.com");
	}
	
	public void typeAddress()
	{
		Address.clear();
		Address.sendKeys("10,Downing Street");
	}
	
	public void typePinCode()
	{
		PinCode.clear();
		PinCode.sendKeys("600092");
	}
	
	public void clickNext()
	{
        Next.click();
	}
	
	public void typeNomineeName() throws InterruptedException
	{
		NomineeName.clear();
		NomineeName.sendKeys("Graham Bell");
		Thread.sleep(4300);
	}
	
	public void typeEngineNumber()
	{
		EngineNumber.clear();
		EngineNumber.sendKeys("135790");
	}
	
	public void typeChasisNumber()
	{
		ChasisNumber.clear();
		ChasisNumber.sendKeys("246800");
	}


}
