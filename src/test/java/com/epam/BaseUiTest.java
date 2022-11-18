package com.epam;

import org.junit.*;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;

@Ignore
public class BaseUiTest {
    @Managed
    WebDriver driver;

    @Before
    public void maximizeBrowserWindowBeforeTest() {
        driver.manage().window().maximize();
    }
}
