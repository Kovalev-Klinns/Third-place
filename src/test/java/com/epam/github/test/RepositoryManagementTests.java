package com.epam.github.test;

import com.epam.github.page.MainPage;
import com.epam.github.service.APIService;
import com.epam.github.service.PropertyReader;
import com.epam.github.models.User;
import com.epam.github.models.Repository;
import com.epam.github.util.RandomStringUtils;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RepositoryManagementTests extends BaseTest {

    @Test
    public void oneCanCreateNewRepository() {
        final String randomName = RandomStringUtils.getRandomName();
        User testUser = PropertyReader.getUserWithCredentialsFromProperty();
        String actualRepositoryName = new MainPage()
                .clickSignIn()
                .login(testUser)
                .clickNewRepository()
                .createNewRepository(randomName)
                .getNewRepositoryName();

        assertThat("Name repository isn't correct", actualRepositoryName, is(equalTo(randomName)));
    }
}