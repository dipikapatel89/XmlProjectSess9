package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddContactTest {

    WebDriver driver;
   
    String username;
	String password;
	String dashboardValidation="Dashboard";
	String fullname;
	String companyName;
	String email;
	String phone;
	String address;
	String city;
	String state;
	String zip;
	String country;

	
	//@Test
	@Parameters({"userName","password","dashboardHeaderText","fullName","companyName",
		"email","phone","address","city","state","zip","country"})
	public void userShouldBeAbleToAddCustomer(String username,String password,String dashboardValidation,
			String fullname,String companyName,	String email,String phone,String address,String city,
	        String state,String zip,String country) throws InterruptedException
	{
		driver=BrowserFactory.init();		

		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		DashboardPage dashboardpage=PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardValidation);
		dashboardpage.clickCustomers();
		dashboardpage.cliskaddCustomer();
		
		AddContactPage addcontactpage=PageFactory.initElements(driver, AddContactPage.class);
		addcontactpage.insertFullName(fullname);
		addcontactpage.selectCompany(companyName);
		addcontactpage.insertEmail(email);
		addcontactpage.insertPhone(phone);
		addcontactpage.insertAddress(address);
		addcontactpage.insertCity(city);
		addcontactpage.insertState(state);
		addcontactpage.insertZip(zip);
		addcontactpage.insertCountry(country);
		addcontactpage.clickSave();
		
		dashboardpage.clickListCustomers();
		addcontactpage.validateInsertdNameandDelete();
	}
	
	@Test
	@Parameters({"userName","password","dashboardHeaderText","fullName","companyName",
		"email","phone","address","city","state","zip","country"})
	public void userShouldBeAbleToAddCustomerFromListCust(String username,String password,String dashboardValidation,
			String fullname,String companyName,	String email,String phone,String address,String city,
	        String state,String zip,String country) throws InterruptedException
	{
		driver=BrowserFactory.init();		

		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(username);
		loginpage.insertPassword(password);
		loginpage.clickSigninButton();
		
		DashboardPage dashboardpage=PageFactory.initElements(driver,DashboardPage.class);
		dashboardpage.validateDashboardPage(dashboardValidation);
		dashboardpage.clickCustomers();
		dashboardpage.clickListCustomers();
		
		AddContactPage addcontactpage=PageFactory.initElements(driver, AddContactPage.class);
		addcontactpage.clickAdCustOnListCust();
		addcontactpage.insertFullName(fullname);
		addcontactpage.selectCompany(companyName);
		addcontactpage.insertEmail(email);
		addcontactpage.insertPhone(phone);
		addcontactpage.insertAddress(address);
		addcontactpage.insertCity(city);
		addcontactpage.insertState(state);
		addcontactpage.insertZip(zip);
		addcontactpage.insertCountry(country);
		addcontactpage.clickSave();
		
		dashboardpage.clickListCustomers();
		//addcontactpage.validateInsertdNameandDelete();
		addcontactpage.insertSearchOnListCustomer();
		addcontactpage.validateInsertedNameOnSearchBarAndProfile();
	}
}
 