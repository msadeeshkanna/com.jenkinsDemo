package com.jenkinsDemo.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class rediffTitle 
{
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.rediff.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyTitle()
	{
		Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");
	}
	
	@Test
	public void verifyUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.rediff.com/");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}


}
