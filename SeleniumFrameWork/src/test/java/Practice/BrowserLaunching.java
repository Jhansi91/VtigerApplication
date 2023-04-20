package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;

public class BrowserLaunching {
	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFileData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		driver.get(url);
		String uname = pro.getProperty("username");
		String pwd = pro.getProperty("password");
		driver.findElement(By.name("username")).sendKeys(uname);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		
	}

}
