package com.baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.actions.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass  {

	public static Properties prop;

	public static WebDriver driver;

	public void loadConfig() {
		try {
			FileInputStream fis = new FileInputStream("./Configuration/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is: " + e.getMessage());
		}
	}
	
	public static void launchApp() {
		WebDriverManager.firefoxdriver().setup();
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("FireFox")) {
			driver= new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		Action.
		driver.get(prop.getProperty("url"));
		
}
}
