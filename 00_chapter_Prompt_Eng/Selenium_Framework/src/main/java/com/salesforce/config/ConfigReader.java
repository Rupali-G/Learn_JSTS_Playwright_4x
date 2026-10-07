package com.salesforce.config;

import com.salesforce.exceptions.FrameworkException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public final class ConfigReader {

    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPERTIES = load();

    private ConfigReader() {
    }

    private static Properties load() {
        Properties properties = new Properties();
        try (InputStream stream = ConfigReader.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (stream == null) {
                throw new FrameworkException("Configuration file not found on classpath: " + CONFIG_FILE);
            }
            properties.load(stream);
            return properties;
        } catch (IOException e) {
            throw new FrameworkException("Unable to load configuration file: " + CONFIG_FILE, e);
        }
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (isPresent(systemValue)) {
            return systemValue.trim();
        }
        String envValue = System.getenv(key.replace('.', '_').toUpperCase(Locale.ROOT));
        if (isPresent(envValue)) {
            return envValue.trim();
        }
        String fileValue = PROPERTIES.getProperty(key);
        return isPresent(fileValue) ? fileValue.trim() : null;
    }

    public static String getRequired(String key) {
        String value = get(key);
        if (value == null) {
            throw new FrameworkException("Missing required configuration value: " + key);
        }
        return value;
    }

    public static int getInt(String key) {
        String value = getRequired(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new FrameworkException("Configuration value is not a valid integer: " + key + "=" + value, e);
        }
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }

    private static boolean isPresent(String value) {
        return value != null && !value.isBlank();
    }
}
