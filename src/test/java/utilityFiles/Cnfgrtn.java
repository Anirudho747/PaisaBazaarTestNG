package utilityFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Cnfgrtn {
	
	public Properties prop = null; 
	String path = "./src/test/resources/Configuration/Cnfgrtn.properties";

	public Cnfgrtn() {
		
		try
		{
		FileInputStream fis = new FileInputStream(path);
		prop = new Properties();
		prop.load(fis);
		}catch(Exception e)
		{
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println("Cnfgrtn Class");
		}
		
	}
	
	public String getURL()
	{
		return(prop.getProperty("url"));
	}
	
	public String getSrchString()
	{	
		return(prop.getProperty("srchstring"));
	}
	
	public String getVehicleNumber()
	{	
		return(prop.getProperty("vehiclenumber"));
	}

}
