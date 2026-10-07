package com.salesforce.pages;

import com.salesforce.exceptions.FrameworkException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private static final By PAGE_ROOT = By.xpath("//html");
    private static final By PASSWORD_LOCATOR = By.xpath("//input[@id='password']");
    private static final By ERROR_LOCATOR = By.xpath("//div[@id='error']");
    private static final By LOGIN_FORM_LOCATOR = By.xpath("//form[@id='login_form']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//img[@id='logo']")
    private WebElement logo;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[@for='rememberUn']")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//a[@id='forgot_password_link']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@id='error']")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[@id='idcard-identity']")
    private WebElement identityCard;

    public LoginPage(WebDriver driver, Duration timeout) {
        if (driver == null) {
            throw new FrameworkException("WebDriver must not be null when creating LoginPage");
        }
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(driver, this);
    }

    public LoginPage open(String url) {
        try {
            driver.navigate().to(url);
            waitForLoginPage();
            return this;
        } catch (WebDriverException e) {
            throw new FrameworkException("Unable to open login page: " + url, e);
        }
    }

    public LoginPage waitForLoginPage() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(usernameInput));
            return this;
        } catch (TimeoutException e) {
            throw new FrameworkException("Login page did not load: username field not clickable", e);
        }
    }

    public LoginPage enterUsername(String username) {
        type(usernameInput, username, "username");
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(passwordInput, password, "password");
        return this;
    }

    public LoginPage clickLogin() {
        try {
            WebElement currentPage = driver.findElement(PAGE_ROOT);
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
            wait.until(ExpectedConditions.stalenessOf(currentPage));
            return this;
        } catch (TimeoutException | NoSuchElementException e) {
            throw new FrameworkException("Login button click did not trigger a page submission", e);
        }
    }

    public LoginPage submitUsername(String username) {
        enterUsername(username);
        clickLogin();
        try {
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(PASSWORD_LOCATOR),
                    ExpectedConditions.visibilityOfElementLocated(ERROR_LOCATOR)));
            return this;
        } catch (TimeoutException e) {
            throw new FrameworkException("Neither the password step nor an error appeared after submitting username", e);
        }
    }

    public LoginPage doLogin(String username, String password) {
        submitUsername(username);
        if (isPasswordStepDisplayed()) {
            enterPassword(password);
            clickLogin();
        }
        return this;
    }

    public LoginPage setRememberMe(boolean shouldBeSelected) {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(rememberMeCheckbox));
            if (checkbox.isSelected() != shouldBeSelected) {
                checkbox.click();
            }
            wait.until(ExpectedConditions.elementSelectionStateToBe(rememberMeCheckbox, shouldBeSelected));
            return this;
        } catch (TimeoutException e) {
            throw new FrameworkException("Unable to set Remember Me checkbox to " + shouldBeSelected, e);
        }
    }

    public boolean isRememberMeSelected() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(rememberMeCheckbox)).isSelected();
        } catch (TimeoutException e) {
            throw new FrameworkException("Remember Me checkbox is not visible", e);
        }
    }

    public String getRememberMeLabel() {
        return getVisibleText(rememberMeLabel, "Remember Me label");
    }

    public String getErrorMessage() {
        return getVisibleText(errorMessage, "error message");
    }

    public String getIdentityCardText() {
        return getVisibleText(identityCard, "identity card");
    }

    public String getLoginButtonValue() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginButton)).getAttribute("value");
        } catch (TimeoutException e) {
            throw new FrameworkException("Login button is not visible", e);
        }
    }

    public String getUsernameFieldType() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(usernameInput)).getAttribute("type");
        } catch (TimeoutException e) {
            throw new FrameworkException("Username field is not visible", e);
        }
    }

    public String getPasswordFieldType() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(passwordInput)).getAttribute("type");
        } catch (TimeoutException e) {
            throw new FrameworkException("Password field is not visible", e);
        }
    }

    public String getPasswordFieldValue() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(passwordInput)).getAttribute("value");
        } catch (TimeoutException e) {
            throw new FrameworkException("Password field is not visible", e);
        }
    }

    public boolean isLogoDisplayed() {
        return isDisplayed(logo);
    }

    public boolean isUsernameFieldDisplayed() {
        return isDisplayed(usernameInput);
    }

    public boolean isLoginButtonEnabled() {
        return isDisplayed(loginButton) && loginButton.isEnabled();
    }

    public boolean isRememberMeDisplayed() {
        return isDisplayed(rememberMeCheckbox);
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return isDisplayed(forgotPasswordLink);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMessage);
    }

    public boolean isPasswordStepDisplayed() {
        return isDisplayed(passwordInput);
    }

    public boolean isLoginFormDisplayed() {
        return !driver.findElements(LOGIN_FORM_LOCATOR).isEmpty();
    }

    public boolean waitUntilLoginPageIsLeft() {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(LOGIN_FORM_LOCATOR));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    private void type(WebElement element, String value, String fieldName) {
        try {
            WebElement field = wait.until(ExpectedConditions.elementToBeClickable(element));
            field.clear();
            if (value != null && !value.isEmpty()) {
                field.sendKeys(value);
            }
        } catch (TimeoutException | StaleElementReferenceException e) {
            throw new FrameworkException("Unable to type into " + fieldName + " field", e);
        }
    }

    private String getVisibleText(WebElement element, String elementName) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).getText().trim();
        } catch (TimeoutException e) {
            throw new FrameworkException("Expected " + elementName + " to be visible but it was not", e);
        }
    }

    private boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}
