package com.proy_aw.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConnection {
	
	public static WebDriver driver;
	
	private DriverConnection(String url) {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--start-maximized");
		options.addArguments("-headless");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().fullscreen();
	}
	
	public static WebDriver getInstancia(String url) {
		if (driver == null)
			new DriverConnection(url);
		return driver;
	}
	
	public static void cerrar() {
		if (driver != null) 
			driver.quit();
	}

}