package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	String username;
	String password;
	String dashboardValidationText;
	
	@Test
	@Parameters({"userName","password","dashboardHeaderText"})
	public void validUserShouldBeAbleToLogin(String username,String password,String dashboardValidation)
	{
		driver=BrowserFactory.init();
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		//create object of dashboard page and call method
		DashboardPage dashboardpage=PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardValidationText);
		
		BrowserFactory.tearDown();
	}
	
}
