package common;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import seleniumGist.Browser;

public abstract class BaseLoginPage {
	private static Logger log=Logger.getLogger(BaseLoginPage.class);
	WebDriver driver;
	Browser browser;
	String userRole;
	
	static String mainPageUrl;
	static String mainWindowHandle;
	
	public BaseLoginPage(WebDriver driver ) {
	this.driver=driver;
	this.browser=new Browser(driver);
	}
	
	public void login(String loginUrl,String userName,String password,String expectedTitle){
		driver.get(loginUrl);
		
		String title=driver.getTitle();
		if(title.contains("Login")){
			driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
			long startTime=System.currentTimeMillis();
			WebElement userNameField=getUserNameField();
			WebElement passwordField=getPasswordField();
			WebElement submitButton=getSubmitButton();
		
			userNameField.clear();
			userNameField.sendKeys(userName);
			passwordField.clear();
			passwordField.sendKeys(password);
			submitButton.click();
			
		String actualTitle=driver.getTitle();
		Assert.assertTrue("\""+actualTitle+"\" did not contain Expected title-:"+"\""+expectedTitle, actualTitle.contains(expectedTitle));
		mainPageUrl=driver.getCurrentUrl();
		long endTime=System.currentTimeMillis();
		log.debug(String.format("***Login time: %d seconds",(endTime-startTime)/1000));
		mainWindowHandle=driver.getWindowHandle();
		return;
			
		}
	}

	abstract WebElement getUserNameField();
	abstract WebElement getPasswordField();
	abstract WebElement getSubmitButton();
	

}
