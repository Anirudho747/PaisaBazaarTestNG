package utilityFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelClass {

	public String prepath="./src/test/resources/ExcelFiles/";
	public String fName;
	public FileInputStream fis;
	public FileOutputStream fos;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	
	public int getRowCount(String file,String sName) throws IOException
	{
		fName = file;
		fis = new FileInputStream(fName);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sName);
		
		int rc = sheet.getLastRowNum()-sheet.getFirstRowNum();
		return rc;
	}
	
	public int getCellCount(String file,String sName,int rnum) throws IOException
	{
		fName = file;
		fis = new FileInputStream(fName);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sName);
		int cc = sheet.getRow(rnum).getLastCellNum()-sheet.getRow(rnum).getFirstCellNum();
		return cc;
	}	
	
	@DataProvider(name="getCellData")
	public Object[][] getCellData() throws IOException
	{
		fName = "./src/test/resources/ExcelFiles/PaisaBazaarCust.xlsx";
		fis = new FileInputStream(fName);
		wb = new XSSFWorkbook(fis);
		String sName = "New";
		sheet = wb.getSheet("New");
		
		String newA[][] = new String[getRowCount(fName,sName)][getCellCount(fName,sName,0)];
		
		for(int i=1;i<=getRowCount(fName,sName);i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				cell = sheet.getRow(i).getCell(j);
				cell.setCellType(CellType.STRING);
				String data = cell.getStringCellValue();
				//System.out.println(data);
				newA[i-1][j] = data;
			}
		}
		
		return newA;
	
	}

}
