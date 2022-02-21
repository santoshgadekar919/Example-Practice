package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.Utilities;

public class TestBase {
	public static WebDriver Driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					"C:\\Users\\santo\\eclipse-workspacet\\Interview\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\santo\\Downloads\\chromedriver.exe");
			Driver = new ChromeDriver();
		}
		else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\geckodriver.exe");
			Driver = new FirefoxDriver();
		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver",
					"E:\\Naveen Automation Selenium Class\\Driver and JAR File\\msedgedriver.exe");
			Driver = new EdgeDriver();
		}
		Driver.manage().deleteAllCookies();
		Driver.manage().window().maximize();
		Driver.manage().timeouts().pageLoadTimeout(Utilities.pageLoadTimeout, TimeUnit.SECONDS);
		Driver.manage().timeouts().implicitlyWait(Utilities.implicitlyWait, TimeUnit.SECONDS);
		Driver.get(prop.getProperty("URL"));
	}

}
