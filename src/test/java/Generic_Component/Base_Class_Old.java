package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class_Old {
	
	public Process process;
	public  AppiumDriver driver;
	
	//Start server
	
	public  void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="C:\\Program Files\\Appium\\node.exe  C:\\Program Files\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		 process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!=null)
		{
			System.out.println("Started the Appium server");
		}
		else
		{
			System.out.println("NOT Initialized");
		}
			
		Thread.sleep(12000);
				
	}
	
	//********************************************
	
	public void Init_app() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "XT1033");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		//app details
		capabilities.setCapability("appPackage", "com.bigbasket.mobileapp");
		capabilities.setCapability("appActivity", "com.bigbasket.mobileapp.activity.SplashActivity");
		
		//Appium details
		
		driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		Thread.sleep(10000);
		
		
		
	}
	
	//Explicit wait
	
	public void Explicit_wait(WebElement ele, long T1)
	{
		WebDriverWait wait = new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	
	
	
	//******************************************
	// Stop server
	
	public  void Stop_Server() throws InterruptedException
	{
		
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(10000);
			System.out.println("Stopped the appium server");
			
		}
	}


}
