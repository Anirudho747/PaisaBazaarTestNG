package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CustDetailsPage;
import pageObject.GooglePage;
import pageObject.HomePage;
import utilityFiles.Cnfgrtn;
import utilityFiles.ExcelClass;

public class POMDP {

	public WebDriver driver;
	public GooglePage gp;
	public HomePage hp;
	public CustDetailsPage cdp;
	public Cnfgrtn cnfgr = new Cnfgrtn();
	
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
	
	@Test
	public void google() throws InterruptedException
	{
		driver.get(cnfgr.getURL());
		gp = new GooglePage(driver);
		gp.enterText();
		gp.displayEntries();
		gp.clickLink();
	}
	
	@Test
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
	
	
	@DataProvider(name="custDetails")
	public Object[][] dataEntry() throws IOException
	{
		path = "./src/test/resources/ExcelFiles/PaisaBazaarCust.xlsx";
		
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("New");
		Cell cell = null;
		
		int rc = sheet.getLastRowNum()-sheet.getFirstRowNum();
		int cc = sheet.getRow(0).getLastCellNum()-sheet.getRow(0).getFirstCellNum();
		
		String newA[][] = new String[rc][cc];
		
		
		for(int i=1;i<=rc;i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				cell = sheet.getRow(i).getCell(j);
				cell.setCellType(CellType.STRING);
				String data = cell.getStringCellValue();
				System.out.println(data);
				newA[i-1][j] = data;
			}
		}
		
		return newA;
	}
	
	@Test
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
