package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WordPressLoginPage extends BaseLoginPage{

	public WordPressLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	WebElement getUserNameField() {
		return browser.findByElement(By.xpath(""));

	}

	@Override
	WebElement getPasswordField() {
		return browser.findByElement(By.xpath(""));

	}

	@Override
	WebElement getSubmitButton() {
		return browser.findByElement(By.xpath(""));

	}

	
	
	
	
	

	
	
	

}
