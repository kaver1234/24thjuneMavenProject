package Module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsLoginPage {
	
	 //step1: declaration
	
	 @FindBy(xpath="//input[@id='user-name']") private WebElement UN;
	 
	 @FindBy(xpath="//input[@id='password']") private WebElement PWD;
	 
	 @FindBy(xpath="//input[@id='login-button']") private WebElement Login;
	 
	//step2: initialization
	 
	 public SwagLabsLoginPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //step3: usage
	 
	 public void inpSwagLabsLoginPageUN(String username) {
		 
		 UN.sendKeys(username);
		
	}
	 
	 public void inpSwagLabsLoginPagePWD(String password) {
		 
		 PWD.sendKeys(password);
		
	}
	 
	 public void clickSwagLabsLoginPageLogin() {
		 
		 Login.click();
		
	}
}
