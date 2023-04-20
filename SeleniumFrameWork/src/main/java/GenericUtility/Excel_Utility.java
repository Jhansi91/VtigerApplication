package GenericUtility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	/**
	 * this method is used to fetch the string data from excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author jhansi
	 */
	public String getExcelData(String sheetname,int rownum,int cellnum) throws Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		Row row= sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
	}
	
	
	/**
	 * this method is used to fetch any kind of data from excel
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 * @author jhansi
	 */
	public String getExcelDataFormatter(String sheetname,int rownum,int cellnum) throws  Throwable
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		DataFormatter format = new DataFormatter();
		String data = format.formatCellValue(book.getSheet(sheetname).getRow(rownum).getCell(cellnum));
		return data;
		
	}
	
	public Object[][] readMultipleData(String sheetname) throws Throwable
	
	{
		FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book=WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetname);
		int lastrow=sheet.getLastRowNum()+1;
		int lastcell=sheet.getRow(0).getLastCellNum();

		String[][] obj=new String[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		return obj;
		
	}

}
