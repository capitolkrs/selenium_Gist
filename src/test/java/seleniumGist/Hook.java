package seleniumGist;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;

public class Hook extends PageObject{

	private static final String IE_DRIVER_IDENTIFIER="internetexplorer";
	private static final String FIREFOX_DRIVER_IDENTIFIER="firefox";
	private static final String CHROME_DRIVER_IDENTIFIER="chrome";
	
	private static WebDriver webDriver;
	private static Scenario scenario;
	private static Logger log=Logger.getLogger(Hook.class);
	
@Before
public void storeScenario(Scenario scenario){
	Hook.scenario=scenario;
}

public static Scenario getCurrentScenario(){
	return scenario;
}



public static WebDriver getWebDriver(){
	if(webDriver==null){
		String driverType=System.getProperty("webDriver");
		if(CHROME_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)){
			webDriver=new ChromeDriver();
		}else if(FIREFOX_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)){
			webDriver=new FirefoxDriver();
		}else if(IE_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)){
			webDriver=new InternetExplorerDriver();
		}else{
			webDriver=new ChromeDriver();
		}
		webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		webDriver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

	}
	return webDriver;
}

@After
public static void clearWebDriver(){
	if(webDriver !=null){
		webDriver.manage().deleteCookieNamed("KEY");
		webDriver.close();
		webDriver.quit();
		webDriver=null;
	}
}

public static String getSessionId(){
	return Serenity.getCurrentSessionID();
}
}
