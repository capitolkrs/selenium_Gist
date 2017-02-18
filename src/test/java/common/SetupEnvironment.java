package common;

import org.openqa.selenium.WebDriver;

import seleniumGist.Browser;
import seleniumGist.Hook;

public class SetupEnvironment {

	private static Browser browser;
	private static WebDriver driver;
	private static SetupEnvironment setupEnvironment;
	

	public static void setupEnvironment(){
		if(Hook.getWebDriver()==null || Hook.getSessionId()==null){
			AcceptTestProperties.setUpProperties();
			
		}
	}
}
