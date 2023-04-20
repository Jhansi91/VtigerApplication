package GenericUtility;

import java.util.Random;

public class Java_Utility {
	
	/** 
	 * this method is used to avaoid duplicates
	 * @return
	 * @author jhansi
	 */
	public int getRandomNum()
	{
		Random ran=new Random();
		int ran_num = ran.nextInt(1000);
		return ran_num;
	}

}
