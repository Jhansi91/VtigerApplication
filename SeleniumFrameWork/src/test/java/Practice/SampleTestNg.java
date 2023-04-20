package Practice;

import org.testng.annotations.Test;

public class SampleTestNg {
	//@Test(priority=1)
	@Test(invocationCount=3)
	public void createContact()
	{
		//int[] arr= {1,2,3};
		//System.out.println(arr[5]);
		System.out.println("contact created");
	}
	//@Test(priority=2)
	//@Test(dependsOnMethods = "createContact")
	@Test
	public void modifyContact()
	{
		System.out.println("modified contact");
	}
	//@Test(priority=3)
	//@Test(dependsOnMethods = "createContact")
	@Test
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
}
