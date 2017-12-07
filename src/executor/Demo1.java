package executor;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import exception.TitleNotMatchException;
import pom.CustomerPOM;
import pom.LoginPOM;

public class Demo1 extends BaseTest {
	@Test(priority=2)
	public void test1()
	{
		log.info("opening....");
		Reporter.log("opening....",true);
		
		try {
			LoginPOM pom = new LoginPOM(driver);
			pom.setUnTB("admin");
			pom.setPwTB("admin1");
			pom.clickLogin();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new TitleNotMatchException();
		}
			
		}
		
	@Test(dependsOnMethods="test1")
	public void test2()
	{
		log.info("opening...second");
		Reporter.log("opeing second.....",true);
		LoginPOM pom = new LoginPOM(driver);
		pom.setUnTB("admin");
		pom.setPwTB("admin1");
		pom.clickLogin();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CustomerPOM cpom= new CustomerPOM(driver);
		cpom.verifyTitle(driver);	
	}

}
