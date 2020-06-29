package com.epam.github.browser;

import com.epam.github.service.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Browser {

    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private static Browser instance;
    private static Logger log = LogManager.getRootLogger();

    private Browser() {
    }

    public static Browser getInstance() {
        if (instance == null) {
            instance = new Browser();
        }
        return instance;
    }

    public WebDriver getDriver() {
        WebDriver driver;
        String browser = System.getProperty("browser");
            if (driverThread.get() == null) {
                if (browser == null) {
                    log.info("The browser was not chosen as a maven parameter");
                    driver = BrowserFactory.getDriver(PropertyReader.getBaseBrowser());
                    driverThread.set(driver);
                }
                else {
                    driver = BrowserFactory.getDriver(browser);
                    driverThread.set(driver);
                }
            }
        return driverThread.get();
    }

    public void openStartPage() {
        getDriver().manage().window().maximize();
        getDriver().navigate().to(PropertyReader.getBaseUrl());
    }

    public void quitDriver() {
        if (driverThread.get() != null) {
            driverThread.get().quit();
            driverThread.remove();
        }
    }
}