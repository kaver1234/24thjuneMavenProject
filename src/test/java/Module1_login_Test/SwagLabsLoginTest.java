package Module1_login_Test;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtiliyClass;
import Module1_login.SwagLabsHomePage;
import Module1_login.SwagLabsLoginPage;
import Module1_login.SwagLabsMenuPage;

public class SwagLabsLoginTest extends BaseClass {
	
	SwagLabsLoginPage login;
	SwagLabsHomePage  home;
	SwagLabsMenuPage menu;
    int TCID;
	
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		  
	    intializeBrowaswser();
		login= new SwagLabsLoginPage(driver);
		home=new SwagLabsHomePage(driver);
		menu =new  SwagLabsMenuPage(driver);
	 
	}
	
	@BeforeMethod
	public void Loginpage() throws InterruptedException, EncryptedDocumentException, IOException {
		
		login.inpSwagLabsLoginPageUN(UtiliyClass.getDataFromPropFile("UN"));
		
		Thread.sleep(2000);
		login.inpSwagLabsLoginPagePWD(UtiliyClass.getDataFromPropFile("password"));
		
		Thread.sleep(2000);
		login.clickSwagLabsLoginPageLogin();
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void verifyTitle() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID=101;
		String acttxt=home.verifySwagLabsHomePagetitle();
		String expectTitle= UtiliyClass.getID(0,2);
		
		Assert.assertEquals(acttxt, expectTitle," Title is not eqauls..");
		
		}
	@AfterMethod
	public void LogoutApp(ITestResult result) throws InterruptedException, IOException {
		
           if(result.getStatus()==ITestResult.FAILURE)
           {
        	   //code ss
        	  UtiliyClass.captureScreenshot(driver, TCID); 
           }
		
		
		home.clickSwagLabsHomePageMenu();
		
		Thread.sleep(2000);
		
		menu.clickSwagLabsMenuPageLogout();
		
		Thread.sleep(2000);
		
		
		
		
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		
		
		
		driver.close();
		
	}	

}
