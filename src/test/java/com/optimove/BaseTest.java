package com.optimove;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


abstract public class BaseTest {

    @BeforeTest
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }

    @AfterTest
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
