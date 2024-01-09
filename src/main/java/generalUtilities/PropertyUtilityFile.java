package generalUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * this class consist of reusable methods related to property file
 * @author Sowmiya
 */

public class PropertyUtilityFile 
{
	/**
	 * this method will read the common data from property file
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");		
        Properties pro = new Properties();
        pro.load(fis);
        String value = pro.getProperty(key);
        return value;
	
	}


}
