package com.epam.github.util;

import com.epam.github.browser.Browser;
import com.epam.github.service.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExplicitWait {
    private static WebDriver driver = Browser.getInstance().getDriver();
    private static int timeout = PropertyReader.getWaitTime();

    public static WebElement waitForElementVisibility(WebElement webElement) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForElementListVisibility(List<WebElement> elementList) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfAllElements(elementList));
    }

    public static void waitForElementInvisibility(WebElement webElement) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static WebElement waitForElementClickability(WebElement webElement) {
        return new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitForAttributeContains(WebElement webElement, String attribute, String value) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.attributeContains(webElement, attribute, value));
    }
}

