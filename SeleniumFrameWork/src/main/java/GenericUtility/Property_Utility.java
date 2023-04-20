package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility {
	
	/**
	 * this method is used to launch the applicatio
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author jhansi
	 */
	public String getKeyValue(String Key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtiger_property_file.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}

}
