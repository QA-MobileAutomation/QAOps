package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day1 {

	@Test (groups = {"smoke"})

	public void Demo() {

		System.out.println("hello  !");
	}
	
	@BeforeSuite
	
	public void ritesh() {
		
		System.out.println("in");
	}
	
	@BeforeMethod
	
	public void ws() {
		
		System.out.println("hello how are you");
	}
	
	@AfterMethod
	
	public void qa() {
		
		System.out.println("i am good as always !");
	}

	@Test

	public void Demo1() {

		System.out.println("good day !");
	}
	
	@BeforeTest  
	
	public void Demo13() {
		
		System.out.println("class !");
	}
	
	@AfterTest
	
	public void Demo121() {
		
		System.out.println("finish !");
	}
}
