package test;

import org.testng.annotations.Test;

public class Day4 {
	
	@Test (groups = {"smoke"}) 

	public void WebLoginHomeLoan() {
		
		System.out.println("webloginhome");

	}

	@Test (dependsOnMethods = {"WebLoginHomeLoan", "LoginAPIHomeLoan"})

	public void MobLoginHomeLoan() {
		
		System.out.println("mobileloginhome");

	}

	@Test

	public void LoginAPIHomeLoan() {
		
		System.out.println("APIloginhome");

	}

}
