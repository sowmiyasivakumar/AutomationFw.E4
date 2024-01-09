package generalUtilities;

import java.util.Date;

/**
 *  this class consist of reusable methods related to java file
 * @author Sowmiya
 * 
 */

public class JavaUtilityFile
{
	/**
	 * this method will return the current date and time
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":", "_");
		return currentDate ;
		}
	

}
