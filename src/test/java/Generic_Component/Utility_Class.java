package Generic_Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utility_Class {
	public String Reading_Properties(String SKey) throws IOException 
	{
		FileInputStream fis= new FileInputStream("July.Properties");
		Properties prop= new Properties();
		
		prop.load(fis);
		
		return prop.getProperty(SKey);
	}

}
