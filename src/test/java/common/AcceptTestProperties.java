package common;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.SystemUtils;

public class AcceptTestProperties {
	private static final String SERENITY_PROPERTY="serentiy.properties";
	private static final String TITILE="title";
	private static final String ENVIRONMENT="environment";
	private static final String URL_TEST="url.test";
	private static final String URL_DEV="url.dev";
	private static final String TEST="test";
	private static final String DEV="dev";
	private static final String WEBDRIVER_CHROME_DRIVER="webdriver.chrome.driver";
	private static final String WEBDRIVER_CHROME_DRIVER_PATH="./browser-drivers/chromedriver.exe";
	private static final String WEBDRIVER_IE_DRIVER="webdriver.ie.driver";
	private static final String WEBDRIVER_PHANTOM_BINARY_PATH="./browser-drivers/ieDriver-x64.exe";
	
	
	private static Properties props;
	
	public static void setUpProperties(){
		props=new Properties();
		List<String>acceptEnvironments=new ArrayList<>();
		acceptEnvironments.add(ENVIRONMENT);
		acceptEnvironments.add(TITILE) ;
		acceptEnvironments.add(URL_TEST);
		try {
			props.load(new FileInputStream(SERENITY_PROPERTY));
		} catch (Exception e) {
			// TODO: handle exception
		}
		setUpBrowserDrivers();
	}

	private static void setUpBrowserDrivers() {
		if(SystemUtils.IS_OS_WINDOWS){
			System.setProperty(WEBDRIVER_CHROME_DRIVER, WEBDRIVER_CHROME_DRIVER_PATH);
		}
		
	}


}
