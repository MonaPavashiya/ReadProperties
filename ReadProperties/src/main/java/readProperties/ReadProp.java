package readProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ReadProp {

	public static void main(String[] args) throws IOException
	{
		WebDriver driver = null;
		//how to read properties file
		Properties prop = new Properties();
		
		FileInputStream ip = new FileInputStream("C:\\Users\\mS\\Documents\\Mona_Practice_QA\\TestNGReadProperties\\src\\main\\java\\readProperties\\my.properties");

	    prop.load(ip);
	    
	    System.out.println(prop.getProperty("browser"));
	    String browserName = prop.getProperty("browser");
	    if(browserName.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\Users\\mS\\Documents\\MonaQAjars\\WebDrivers\\chromedriver.exe");
		    driver = new ChromeDriver();
	    }
	    else if(browserName.equals("FF"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    else if(browserName.equals("safari"))
	    {
	    	driver = new SafariDriver();
	    }
	    else if(browserName.equals("IE"))
	    {
	    	driver = new InternetExplorerDriver();
	    }
	    else
	    {
	    	System.out.println("No browser value is given");
	    }
	    
	    driver.get(prop.getProperty("url"));
	    driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
	    driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
	    driver.findElement(By.xpath(prop.getProperty("loginbtn_xpath"))).click();
	    
	    WebElement image = driver.findElement(By.xpath(prop.getProperty("orangehrm_logoimg_xpath")));
	    
	    if(image.isDisplayed())
	    {
	    	System.out.println("Image is present");
	    }
	    
	    driver.quit();
	}

}
