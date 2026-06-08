package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.BrowserType;

public final class ConfigReader {

    private static final Properties PROPERTIES = loadProperties();

    private ConfigReader() {
    }

    public static String get(String key) {
        String value = PROPERTIES.getProperty(key);

        if (value == null) {
            throw new IllegalArgumentException("Missing config key: " + key);
        }

        return value;
    }

    public static BrowserType getBrowser() {
        return BrowserType.from(get("browser"));
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = PROPERTIES.getProperty(key);

        if (value == null || value.isBlank()) {
            return defaultValue;
        }

        return Boolean.parseBoolean(value);
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = ConfigReader.class.getClassLoader()
                .getResourceAsStream(FrameworkConstants.CONFIG_FILE_NAME)) {
            if (inputStream == null) {
                throw new IllegalStateException("config.properties was not found on the classpath");
            }

            properties.load(inputStream);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load config.properties", exception);
        }
    }
}