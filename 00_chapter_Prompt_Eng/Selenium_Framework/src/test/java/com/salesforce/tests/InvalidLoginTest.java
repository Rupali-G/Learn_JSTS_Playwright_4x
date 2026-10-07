package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.exceptions.FrameworkException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {

    private static final String INVALID_CREDENTIALS_MESSAGE =
            "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    private static final String EMPTY_USERNAME_MESSAGE = "Please enter your username.";
    private static final String EMPTY_PASSWORD_MESSAGE = "Please enter your password.";
    private static final String UNREGISTERED_USERNAME = "qa.invalid.user@example.com";
    private static final String WRONG_PASSWORD = "Invalid@Pass#2026";

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {"Wrong credentials", UNREGISTERED_USERNAME, WRONG_PASSWORD, INVALID_CREDENTIALS_MESSAGE},
                {"Empty username", "", WRONG_PASSWORD, EMPTY_USERNAME_MESSAGE},
                {"Empty password", UNREGISTERED_USERNAME, "", EMPTY_PASSWORD_MESSAGE},
                {"Empty username and password", "", "", EMPTY_USERNAME_MESSAGE}
        };
    }

    @Test(dataProvider = "invalidCredentials", groups = {"regression", "negative"},
            description = "Invalid credential combinations are rejected with the correct error message")
    public void verifyInvalidLoginShowsError(String scenario, String username, String password, String expectedMessage) {
        try {
            loginPage.doLogin(username, password);
        } catch (FrameworkException e) {
            Assert.fail("[" + scenario + "] Login flow could not be executed", e);
        }
        Assert.assertTrue(loginPage.isErrorDisplayed(), "[" + scenario + "] Error message should be displayed");
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage),
                "[" + scenario + "] Expected error containing '" + expectedMessage + "' but was '" + actualMessage + "'");
        Assert.assertTrue(loginPage.isLoginFormDisplayed(), "[" + scenario + "] User should remain on the login page");
    }

    @Test(groups = {"regression", "negative", "security"},
            description = "A rejected password is not retained in the password field")
    public void verifyPasswordClearedAfterFailedLogin() throws FrameworkException {
        loginPage.doLogin(UNREGISTERED_USERNAME, WRONG_PASSWORD);
        Assert.assertTrue(loginPage.getErrorMessage().contains(INVALID_CREDENTIALS_MESSAGE),
                "Invalid credentials error should be displayed");
        Assert.assertTrue(loginPage.getPasswordFieldValue().isEmpty(),
                "Password field must be cleared after a failed login attempt");
    }
}
