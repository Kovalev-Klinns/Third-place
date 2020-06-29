package com.epam.github.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewRepositoryPage extends BasePage {

    @FindBy(id = "repository_name")
    private WebElement repositoryName;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[3]/button")
    private WebElement createRepositoryButton;

    @FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
    private WebElement repositoryNameField;

    public NewRepositoryPage createNewRepository(String randomName) {
        sendKeys(repositoryName, randomName);
        clickOnTheClickableItem(createRepositoryButton);
        return new NewRepositoryPage();
    }

    public String getNewRepositoryName() {
        return getText(repositoryNameField);
    }
}
