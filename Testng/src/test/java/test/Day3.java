package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	@Test (timeOut = 4000)

	public void WebLoginCarLoan() {
		
		System.out.println("weblogincar");

	}

	@Test (enabled = false)

	public void MobLoginCarLoan() {
		
		System.out.println("mobilelogincar");

	}
	
	@Parameters({"URL", "API"})
	@Test

	public void MobsigninCarLoan(String username,String password) {
		
		System.out.println("mobile signin");
		System.out.println(username);
		System.out.println(password);

	}
	
	@Test (dataProvider = "getData")

	public void MobsignoutCarLoan(String username, String password) {
		
		System.out.println("mobile signout");
		
		System.out.println(username);
		
		System.out.println(password);

	}
	

	@Test

	public void APICarLoan() {
		
		System.out.println("APIlogincar");

	}
	
	@DataProvider 
	
	public Object[][] getData() {
		
		Object[][] data = new Object[3][2];
		data [0][0] = "firstsetusername";
		data [0][1] = "firstpassword";
		data[1][0] = "secondsetusername";
		data[1][1] = "secondpassword";
		data[2][0] = "thirdsetusername";
		data[2][1] = "thirdpassword";
		return data;	
	}

}
