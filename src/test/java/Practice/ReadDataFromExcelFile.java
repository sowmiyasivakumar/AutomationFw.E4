package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException
	{
		FileInputStream fis = new FileInputStream("D:\\Backup\\Documents\\TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(4);
		Cell cell = row.getCell(3);
		String data = cell.getStringCellValue();
		System.out.println(data);
		book.close();		
		
		

	}

}
