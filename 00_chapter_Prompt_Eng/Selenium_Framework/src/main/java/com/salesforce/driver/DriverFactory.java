package com.salesforce.driver;

import com.salesforce.exceptions.FrameworkException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Locale;

public final class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverFactory() {
    }

    public static WebDriver initDriver(String browser, boolean headless, int pageLoadTimeoutSeconds) {
        try {
            WebDriver driver = createDriver(browser.toLowerCase(Locale.ROOT), headless);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeoutSeconds));
            if (!headless) {
                driver.manage().window().maximize();
            }
            DRIVER.set(driver);
            return driver;
        } catch (WebDriverException e) {
            throw new FrameworkException("Failed to start browser: " + browser, e);
        }
    }

    private static WebDriver createDriver(String browser, boolean headless) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications", "--window-size=1920,1080");
                if (headless) {
                    chromeOptions.addArguments("--headless=new");
                }
                return new ChromeDriver(chromeOptions);
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications", "--window-size=1920,1080");
                if (headless) {
                    edgeOptions.addArguments("--headless=new");
                }
                return new EdgeDriver(edgeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("-headless");
                }
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new FrameworkException("Unsupported browser: " + browser);
        }
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new FrameworkException("WebDriver has not been initialised for the current thread");
        }
        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException e) {
                throw new FrameworkException("Failed to quit WebDriver cleanly", e);
            } finally {
                DRIVER.remove();
            }
        }
    }
}
