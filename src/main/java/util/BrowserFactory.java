package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	  static WebDriver driver;
	  static String browser;
	  static String url;
	  
	  public static void readConfig() {
			//InputStream //BufferedReader //FileReader //Scanner
			
			try {
				InputStream input = new FileInputStream("C:\\Users\\Sandip\\selenium\\ExlProjectSess8\\src\\main\\java\\config\\config.properties");
				Properties prop = new Properties();
				prop.load(input);
				browser = prop.getProperty("browser");
				System.out.println("Used Browser: " + browser);
				url = prop.getProperty("url");
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	public static WebDriver init()
	{
		readConfig();
        System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}
		
		
}
