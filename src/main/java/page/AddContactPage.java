package page;

import org.openqa.selenium.By;

//import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddContactPage extends BasePage{

	WebDriver driver;
	
	 public AddContactPage(WebDriver driver) {
		this.driver=driver;
	}
	@FindBy(how=How.XPATH,using="//*[@id=\"account\"]") WebElement fullNameElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"cid\"]") WebElement companyElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"email\"]") WebElement emailElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"phone\"]") WebElement phoneElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"address\"]") WebElement addressElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"city\"]") WebElement cityElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"state\"]") WebElement stateElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"zip\"]") WebElement zipElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"country\"]") WebElement countryElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"submit\"]") WebElement saveElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/a[1]") WebElement addCustomerOnListCustElement;
	@FindBy(how=How.XPATH,using="//*[@id=\"foo_filter\"]") WebElement searchOnListCustomer;
	
	String insertedName;
	
	public void insertFullName(String fullname)
	{
		insertedName=fullname + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
	}
	public void selectCompany(String companyName)
	{
		selectFromDropdown(companyElement, companyName);
	}
	public void insertEmail(String email)
	{
		emailElement.sendKeys(generateRandomNum(99) + email);
	}
	public void insertPhone(String phone)
	{
		phoneElement.sendKeys(phone + generateRandomNum(9999));
	}
	public void insertAddress(String address)
	{
		addressElement.sendKeys(address);
	}
	public void insertCity(String city)
	{
		cityElement.sendKeys(city);
	}
    public void insertState(String state)
    {
    	stateElement.sendKeys(state);
    }
    
    public void insertZip(String zip)
    {
    	zipElement.sendKeys(zip);
    }
    public void insertCountry(String country)
    {
       	selectFromDropdown(countryElement, country);
    }
    public void clickSave()
    {
    	saveElement.click();
    }
   
    
    
  //tbody/tr[1]/td[3]/a
  //tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
  //tbody/tr[1]/td[3]/following-sibling::td[4]/a[1]
  //tbody/tr[1]/td[7]/a[2]
    
    String beforeXpath="//tbody/tr[";
    String afterXpath="]/td[3]/a";
    String after_xpath_delete_button="]/td[3]/following-sibling::td[4]/a[2]";
    String after_xpath_profile_button="]/td[3]/following-sibling::td[4]/a[1]";
    public void validateInsertdNameandDelete()
    {
    	for(int i=1;i<=10;i++)
    	{
    		String actualName=driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
    		//System.out.println(actualName);
    		//Assert.assertEquals(actualName, insertedName,"name is not found");
    		if(actualName.contains(insertedName))
    		{
    			System.out.println("inserted name exist");
    			driver.findElement(By.xpath(beforeXpath + i + after_xpath_delete_button)).click();
    		}
    		break;
    	}
    }
    public void clickAdCustOnListCust()
    {
    	addCustomerOnListCustElement.click();
    }
    public void insertSearchOnListCustomer()
    {
       searchOnListCustomer.sendKeys(insertedName);	
    }
    public void validateInsertedNameOnSearchBarAndProfile()
    {
    	for(int i=1;i<=5;i++)
    	{
    		String actualName=driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();
    		if(actualName.equals(insertedName))
    		{
    			System.out.println("inseted name exist");
    			driver.findElement(By.xpath(beforeXpath + i + after_xpath_profile_button)).click();
    		}
    		break;
    	}
    }
}

