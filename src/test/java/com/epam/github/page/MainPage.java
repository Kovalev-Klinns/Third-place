package com.epam.github.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement signInButton;

    @FindBy(xpath = "//img[@class='avatar avatar-user ']")
    private WebElement avatarUserButton;

    @FindBy(xpath = "//strong[@class='css-truncate-target']")
    private WebElement linkLoggedInUserLocator;

    @FindBy(xpath = "//div[@class='container-lg px-2']")
    private WebElement errorMessage;

    @FindBy(xpath = "/html/body/div[1]/header/div[6]/details/summary/span")
    private WebElement signPlusButton;

    @FindBy(xpath = "//a[@data-ga-click='Header, create new repository']")
    private WebElement newRepositoryButton;

    public LoginPage clickSignIn() {
        clickOnTheVisibleItem(signInButton);
        return new LoginPage();
    }

    public String getLoggedInUserName() {
        clickOnTheVisibleItem(avatarUserButton);
        return getText(linkLoggedInUserLocator);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public NewRepositoryPage clickNewRepository() {
        clickOnTheVisibleItem(signPlusButton);
        clickOnTheVisibleItem(newRepositoryButton);
        return new NewRepositoryPage();
    }
}
