package example.org.seleniumtraining;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPageObject;
import utility.ExcelUtility;

public class BookTicket {
	private WebDriver driver;
  @Test(priority=1,dataProvider="logindata")
  public void f(String txtusername,String txtpassword) {
	  LoginPageObject.uname.sendKeys(txtusername);
	  LoginPageObject.password.sendKeys(txtpassword);
	  LoginPageObject.Login_button.click();
	  /*driver.findElement(By.name("userName")).sendKeys("abc");
	  driver.findElement(By.name("password")).sendKeys("abc");
	  driver.findElement(By.name("login")).click();*/
	 
  }
  
  @DataProvider(name="logindata")
  public String[][] login_data() throws IOException
  {
	  ExcelUtility.setExcelPath("sheet1", "C:\\Users\\A06438_p5.training\\Desktop\\SeleniumTestData.xlsx");
	  String username=ExcelUtility.getCellData(1,1);
	  String password=ExcelUtility.getCellData(1, 2);
	  return new String[][]{
		  new String[] {username,password},
	  };
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
  PageFactory.initElements(driver,LoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
