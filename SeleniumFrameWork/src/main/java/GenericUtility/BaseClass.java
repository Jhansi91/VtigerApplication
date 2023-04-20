package GenericUtility;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.BeforeTest;
	//import org.testng.annotations.Parameters;
import POM.HomePage;
import POM.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass {
		
		public static WebDriver sdriver;
		public WebDriver driver;
		
		@BeforeSuite(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void BS()
		{
			System.out.println("DataBase Connection");
		}
		@BeforeTest(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void BT()
		{
			System.out.println("Parallel Execution");
		}
		//@Parameters("browser")
		@BeforeClass(groups={"smoketesting","regressiontesting","sanitytesting"})
		//public void BC(String BROWSER) throws Throwable
		public void BC() throws Throwable
 		{
			Property_Utility plib=new Property_Utility();
			String BROWSER = plib.getKeyValue("browser");
			
			
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			else
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
			System.out.println("launching browser");
			sdriver=driver;
		}
		//@Parameters({"url","un","pwd"})
		@BeforeMethod(groups={"smoketesting","regressiontesting","sanitytesting"})
		//public void BM(String URL,String USERNAME,String PASSWORD) throws Throwable
		public void BM() throws Throwable
		{
			driver.manage().window().maximize();
			Property_Utility plib=new Property_Utility();
			String URL = plib.getKeyValue("url");
		    String   USERNAME = plib.getKeyValue("username");
			String PASSWORD = plib.getKeyValue("password");
	        driver.get(URL);
			LoginPage loginpage=new LoginPage(driver);
			loginpage.LoginToApp(USERNAME, PASSWORD);
			System.out.println("Login to Application");
		}
		@AfterMethod(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void AM()
		{
			HomePage homepage=new HomePage(driver);
			homepage.signoutLink(driver);
			System.out.println("Logout Application");
		}
		@AfterClass(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void AC()
		{
			driver.quit();
			System.out.println("Browser closed");
		}
		@AfterTest(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void AT() 
		{
			System.out.println("Parallel Execution Done");
		}
		@AfterSuite(groups={"smoketesting","regressiontesting","sanitytesting"})
		public void AS()
		{
			System.out.println("DataBase Connection close");
		}
		
		
		
	}

