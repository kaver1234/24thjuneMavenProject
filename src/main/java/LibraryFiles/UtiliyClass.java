package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.io.FileHandler;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//@Author name: kaveri
//This method is use to get Test data from excel sheet
//need to pass 2 inputs 1:rowIndex 2:colIndex
public class UtiliyClass {
	
	public static String getID(int rowIndex,int cellindex) throws EncryptedDocumentException, IOException
	{
		//FileInputStream file= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Selenium_Program\\TestData\\DDF_Framework.xlsx");
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\TestData\\DDF_Framework.xlsx");
	
	      Sheet sh = WorkbookFactory.create(file).getSheet("Example1");
	      
	      String value = sh.getRow(rowIndex).getCell(cellindex).getStringCellValue();
	      
	      return value;
	      
	}

	public static void captureScreenshot(WebDriver driver,int TCID) throws IOException {
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		 //File dest=new File("C:\\Users\\Lenovo\\eclipse-workspace\\Selenium_Program\\FailedTCSS\\TaseCaseID" + TCID + ".jpg");
		 File dest=new File(System.getProperty("user.dir")+"\\FailedTCScreenShot\\TaseCaseID" + TCID + ".jpg");
		 
		 FileHandler.copy(src,dest);
		
	}
	

	public static String getDataFromPropFile(String key) throws IOException {
		
		//FileInputStream file= new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\Selenium_Program\\propertyFile.properties");
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\PropertyFile.properties");
		
		Properties p=new Properties();
		p.load(file);
	
		String values = p.getProperty(key);//from this method key value is get
		 
		 return values;
				}
}
