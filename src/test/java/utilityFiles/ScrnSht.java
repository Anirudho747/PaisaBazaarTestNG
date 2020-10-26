package utilityFiles;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScrnSht {
	
	

	public void takePic(WebDriver driver)
	{
		String dest = "./src/test/resources/ScrnShots/picon"+getTime()+".png";
		TakesScreenshot tss= (TakesScreenshot)driver; 
		File Src = tss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Src, new File(dest));
		} catch (IOException e) {
			
			e.getMessage();
			e.getCause();
			System.out.println("scrnSht");
		}
	}
	
	public String getTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curr = new Date();
		return(sdf.format(curr));
	}
}
