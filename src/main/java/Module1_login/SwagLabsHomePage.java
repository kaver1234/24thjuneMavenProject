package Module1_login;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsHomePage {
	
	
	 @FindBy(xpath="//button[@id='react-burger-menu-btn']")  private WebElement menu;
		  
	 WebDriver driver;
	
	  public SwagLabsHomePage(WebDriver driver)
	{
		   this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
//	public  void verifySwagLabsHomePagetitle()
//	
//	{
//		
//		  String actTxt=driver.getTitle(); String Exptxt="Swag Labs";
//		  if(actTxt.equals(Exptxt)) { System.out.println("Title is : " + actTxt +
//		  " : TC Pass"); } else { System.out.println("Not found " + "TC Failed"); }
//		 
//		
//		 
//	}
	
	public  String verifySwagLabsHomePagetitle()
	{
		
		String actText = driver.getTitle();
		 return actText;
	}
	
	public void clickSwagLabsHomePageMenu() {
		
	menu.click();
				
	}

}
