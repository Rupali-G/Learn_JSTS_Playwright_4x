package com.salesforce.tests;

import com.salesforce.base.BaseTest;
import com.salesforce.config.ConfigReader;
import com.salesforce.exceptions.FrameworkException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidLoginTest extends BaseTest {

    private static final String EXPECTED_TITLE = "Login | Salesforce";
    private static final String EXPECTED_LOGIN_BUTTON_VALUE = "Log In";
    private static final String EXPECTED_REMEMBER_ME_LABEL = "Remember me";
    private static final String WELL_FORMED_USERNAME = "qa.automation.user@example.com";

    @Test(priority = 1, groups = {"smoke", "ui"},
            description = "Login page renders every expected element in its initial identifier-first state")
    public void verifyLoginPageUiElements() throws FrameworkException {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getPageTitle(), EXPECTED_TITLE, "Page title mismatch");
        softAssert.assertTrue(loginPage.isLogoDisplayed(), "Salesforce logo should be displayed");
        softAssert.assertTrue(loginPage.isUsernameFieldDisplayed(), "Username field should be displayed");
        softAssert.assertEquals(loginPage.getUsernameFieldType(), "email", "Username field should be of type email");
        softAssert.assertTrue(loginPage.isLoginButtonEnabled(), "Log In button should be enabled");
        softAssert.assertEquals(loginPage.getLoginButtonValue(), EXPECTED_LOGIN_BUTTON_VALUE, "Log In button label mismatch");
        softAssert.assertTrue(loginPage.isRememberMeDisplayed(), "Remember Me checkbox should be displayed");
        softAssert.assertEquals(loginPage.getRememberMeLabel(), EXPECTED_REMEMBER_ME_LABEL, "Remember Me label mismatch");
        softAssert.assertTrue(loginPage.isForgotPasswordLinkDisplayed(), "Forgot Password link should be displayed");
        softAssert.assertFalse(loginPage.isErrorDisplayed(), "No error should be displayed on initial load");
        softAssert.assertFalse(loginPage.isPasswordStepDisplayed(), "Password field should not be displayed before username is submitted");
        softAssert.assertAll();
    }

    @Test(priority = 2, groups = {"regression", "ui"},
            description = "Remember Me checkbox can be selected and deselected")
    public void verifyRememberMeToggle() throws FrameworkException {
        loginPage.setRememberMe(true);
        Assert.assertTrue(loginPage.isRememberMeSelected(), "Remember Me should be selected after checking it");
        loginPage.setRememberMe(false);
        Assert.assertFalse(loginPage.isRememberMeSelected(), "Remember Me should be deselected after unchecking it");
    }

    @Test(priority = 3, groups = {"regression", "functional"},
            description = "Submitting a well-formed username advances to the masked password step")
    public void verifyUsernameStepRevealsPasswordStep() throws FrameworkException {
        loginPage.submitUsername(WELL_FORMED_USERNAME);
        Assert.assertFalse(loginPage.isErrorDisplayed(), "No error should be displayed after submitting a username");
        Assert.assertTrue(loginPage.isPasswordStepDisplayed(), "Password field should be displayed after submitting a username");
        Assert.assertEquals(loginPage.getPasswordFieldType(), "password", "Password field should mask its input");
        Assert.assertEquals(loginPage.getIdentityCardText(), WELL_FORMED_USERNAME, "Identity card should show the submitted username");
        Assert.assertTrue(loginPage.isRememberMeDisplayed(), "Remember Me should remain available on the password step");
    }

    @Test(priority = 4, groups = {"smoke", "functional"},
            description = "Valid credentials with Remember Me selected navigate away from the login page")
    public void verifyValidLoginLeavesLoginPage() {
        String username = ConfigReader.get("sf.username");
        String password = ConfigReader.get("sf.password");
        if (username == null || password == null) {
            throw new SkipException("Valid credentials not supplied: set SF_USERNAME and SF_PASSWORD or pass -Dsf.username and -Dsf.password");
        }
        try {
            loginPage.setRememberMe(true).doLogin(username, password);
        } catch (FrameworkException e) {
            Assert.fail("Login flow could not be completed for the configured user", e);
        }
        Assert.assertTrue(loginPage.waitUntilLoginPageIsLeft(),
                "Login form should no longer be present after a valid login");
    }
}
