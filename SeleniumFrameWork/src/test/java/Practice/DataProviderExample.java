package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	@Test(dataProvider="dataProvider")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest);
	}
	
	@DataProvider
	public Object[][] dataProvider()
	{
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="pune";
		objarr[0][1]="hyderabad";
		
		objarr[1][0]="Andhra";
		objarr[1][1]="Banglore";
		
		objarr[2][0]="pune";
		objarr[2][1]="Mumbai";
		
		return objarr;
	}

}
