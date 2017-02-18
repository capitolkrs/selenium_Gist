package bestPractices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import common.BaseLoginPage;
import common.LoginPage;
import common.SystemProperty;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import seleniumGist.Hook;

public class LoginStep {
private WebDriver driver;
private LoginPage loginPage;
	
	@Before
	public void setUp(){
		driver=Hook.getWebDriver();
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@Given("^I sucessfully logged in as a user$")
	public void loginAndVisit(){
		String systemProperty=null;
		systemProperty=System.getProperty(SystemProperty.ENVIRONMENT.getKey());
		BaseLoginPage loginP=loginPage;
	}
}
