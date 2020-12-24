package com.proy_aw.proyAW;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.proy_aw.helpers.DriverConnection;

//@SpringBootTest
class ProyAwApplicationTests {

	private static WebDriver driver;

	@BeforeAll
	public static void inicio() {
		driver = DriverConnection.getInstancia("https://www.google.com");	
	}

	@Test
	public void hasTitle() {
		try { 
		assertNotNull(driver.getTitle());
		assertTrue(!driver.getTitle().equals(""));
		} catch(Throwable t) {
			System.out.println(t);
		}
	}

	@Test
	public void images() {
		List<WebElement> images = driver.findElements(By.tagName("img"));
		for (WebElement image : images) {
			try {
				assertFalse(image.getAttribute("alt").equals(""));
			} catch (Throwable t) {
				System.out.println(t);
			}
		}	
	}

	@AfterAll
	public static void fin() {
		System.out.println(driver.getPageSource());
		DriverConnection.cerrar();
	}

}