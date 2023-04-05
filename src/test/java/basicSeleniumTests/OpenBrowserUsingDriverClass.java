package basicSeleniumTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.BaseClass;

public class OpenBrowserUsingDriverClass {
	
	
	@Before
	public void beforeMethod() {
		
		BaseClass.getDriver();
		
	}
	
	
	@Test
	public void test1() {
				
		String titlePage = BaseClass.getDriver().getTitle();
		System.out.println(titlePage);
		System.out.println(BaseClass.getProperty("userName"));
		System.out.println(BaseClass.getProperty("passWord"));
		
	}
	
	
	@After
	public void afterMethod() {
		
		BaseClass.closeDriver();
		
	}
	
	
	

}
