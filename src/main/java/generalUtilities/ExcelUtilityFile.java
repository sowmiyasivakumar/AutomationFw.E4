package generalUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class contains reusable methods of excel file
 * 
 */

public class ExcelUtilityFile 
{
	/**
	 * this method will read the test data from excel file
	 * @param stringname
	 * @param rowno
	 * @param cellno
	 * @return String
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String stringname,int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Backup\\Documents\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String value = book.getSheet(stringname).getRow(rowno).getCell(cellno).getStringCellValue();
		return value;
	}

}
