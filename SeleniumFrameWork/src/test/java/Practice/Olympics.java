package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.Excel_Utility;


public class Olympics {
	public static void main(String[] args) throws Throwable {


		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Excel_Utility ex=new Excel_Utility();
		String countryname=ex.getExcelData("Olympics", 0, 0);
		//String countryname = "India";


		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.id("onetrust-pc-btn-handler")).click();
		driver.findElement(By.className("ot-pc-refuse-all-handler")).click();
		WebElement country = driver.findElement(By.xpath("//span[text()='"+countryname+"']/.."));
		String coun = country.getAttribute("data-row-id");
		String rownum = coun.substring(18);





		//System.out.println("attribute value "+country.getAttribute("data-row-id"));
		WebElement gold=driver.findElement(By.xpath("//div[@data-medal-id='gold-medals-row-"+rownum+"']"));
		System.out.println("gold "+ gold.getText()); 

		WebElement silver=driver.findElement(By.xpath("//div[@data-medal-id='silver-medals-row-"+rownum+"']"));
		System.out.println("silver "+silver.getText());
		WebElement bronze =driver.findElement(By.xpath("//div[@data-medal-id='bronze-medals-row-"+rownum+"']"));
		System.out.println("bronze "+bronze.getText()); 
		WebElement total =driver.findElement(By.xpath("//div[@data-medal-id='total-medals-row-"+rownum+"']"));
		System.out.println("total "+total.getText());
		driver.close();



	}

}
