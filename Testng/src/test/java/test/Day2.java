package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Day2 {
	
	@Test (groups = {"smoke"})
	
	public void Demo3() {
		
		System.out.println("good morning !");
	}
	
	@AfterSuite
	
	public void ritesh123() {
		
		System.out.println("treqw");
	}

}
