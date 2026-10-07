package com.salesforce.base;

import com.salesforce.config.ConfigReader;
import com.salesforce.driver.DriverFactory;
import com.salesforce.exceptions.FrameworkException;
import com.salesforce.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseTest {

    private static final Path SCREENSHOT_DIR = Paths.get("target", "screenshots");
    private static final DateTimeFormatter TIMESTAMP = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    protected static String baseUrl;
    protected static String browser;
    protected static boolean headless;
    protected static Duration explicitWait;
    protected static int pageLoadTimeoutSeconds;

    protected LoginPage loginPage;

    @BeforeTest(alwaysRun = true)
    public void loadConfiguration() {
        baseUrl = ConfigReader.getRequired("base.url");
        browser = ConfigReader.getRequired("browser");
        headless = ConfigReader.getBoolean("headless");
        explicitWait = Duration.ofSeconds(ConfigReader.getInt("explicit.wait.seconds"));
        pageLoadTimeoutSeconds = ConfigReader.getInt("page.load.timeout.seconds");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        try {
            DriverFactory.initDriver(browser, headless, pageLoadTimeoutSeconds);
            loginPage = new LoginPage(DriverFactory.getDriver(), explicitWait).open(baseUrl);
        } catch (FrameworkException e) {
            DriverFactory.quitDriver();
            throw e;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.FAILURE) {
                captureScreenshot(result.getMethod().getMethodName());
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }

    private void captureScreenshot(String testName) {
        try {
            byte[] image = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Files.createDirectories(SCREENSHOT_DIR);
            Path file = SCREENSHOT_DIR.resolve(testName + "_" + LocalDateTime.now().format(TIMESTAMP) + ".png");
            Files.write(file, image);
            Reporter.log("Failure screenshot saved: " + file.toAbsolutePath(), true);
        } catch (IOException | WebDriverException | FrameworkException e) {
            Reporter.log("Unable to capture failure screenshot for " + testName + ": " + e.getMessage(), true);
        }
    }
}
