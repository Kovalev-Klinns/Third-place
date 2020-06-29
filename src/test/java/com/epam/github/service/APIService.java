package com.epam.github.service;

import com.epam.github.models.Issue;
import com.epam.github.models.Repository;
import com.epam.github.models.User;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class APIService {
    private User testUser = PropertyReader.getUserWithCredentialsFromProperty();

    public void createEmptyRepository(Repository repository) {
        given().auth()
                .preemptive()
                .basic(testUser.getUserName(), testUser.getUserPassword())
                .body(repository)
                .post("https://api.github.com/user/repos").then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    public void deleteRepository(Repository repository) {
        given().auth()
                .preemptive()
                .basic(testUser.getUserName(), testUser.getUserPassword())
                .delete(String.format("https://api.github.com/repos/%s/%s", testUser.getUserName(), repository.getNameRepository()))
                .then()
                .assertThat()
                .statusCode(204);
    }

    public void createIssue(Repository repository, Issue issue) {
        given().auth()
                .preemptive()
                .basic(testUser.getUserName(), testUser.getUserPassword())
                .body(issue)
                .post(String.format("https://api.github.com/repos/%s/%s/issues", testUser.getUserName(), repository.getNameRepository()))
                .then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }
}
