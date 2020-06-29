package com.epam.github.service;

public enum DataFromProperty {
    TEST_USER_NAME("test.user.name"),
    TEST_USER_PASSWORD("test.user.password"),
    TEST_USER_KEY("test.user.key"),
    BASE_URL("base.url"),
    WAITING_TIMEOUT_SECONDS("waiting.timeout.seconds"),
    BASE_BROWSER("default.browser");

    private final String key;

    DataFromProperty(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
