package jUnitTestingPackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

public class AnnotationTesting {
	
	
	
	@BeforeMethod
	public void before() {
		System.out.println("Executing Before Test. Browser opening and maximizing");
	}
	
	
	@Test
	public void tes1() {
		System.out.println("Executing Test1");
	}
	
	
	@Test
	public void tes2() {
		System.out.println("Executing Test2");
	}
	
	
	@AfterMethod
	public void afterClass() {
		System.out.println("Executing After Test. Browser closing/quitting");
	}
	

}
