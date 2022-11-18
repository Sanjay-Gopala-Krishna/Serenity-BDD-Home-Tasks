package com.epam.core.customdrivers;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;

public class CustomChromeDriver implements DriverSource {
	@Override
	public WebDriver newDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--ignore-certificate-errors");
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			return new ChromeDriver(options);
		} catch (Exception e) {
			throw new Error(e);
		}
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}
