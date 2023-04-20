package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WritingInExcelTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Amazon");
		int rowno = sheet.getLastRowNum();
     // System.out.println(rowno);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
		List<WebElement> searchdata = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']/ancestor::a[contains(@class,'a-link-normal s-underline-text')]"));
		//System.out.println(searchdata.size());
		
		int i=rowno + 1;
		for (WebElement we : searchdata) {
			
				Row row=sheet.createRow(i);
				row.createCell(0).setCellValue(we.getText());
			//	System.out.println(we.getText());
				String link=we.getAttribute("href").substring(21);
				//System.out.println(link);
				WebElement price = driver.findElement(By.xpath("//a[@href='"+link+"']/span[@class='a-price']"));
				//System.out.println(price.getText());
				row.createCell(1).setCellValue(price.getText());
				i++;
				
			}
		
		FileOutputStream os = new FileOutputStream("./src/test/resources/ExcelSheetData.xlsx");
		book.write(os);
	}

}
