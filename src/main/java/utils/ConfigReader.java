package utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String environment =
                System.getProperty("env", "qa");

        System.out.println(
                "Environment Selected : "
                        + environment);

        String filePath =
                FrameworkConstants.CONFIG_FOLDER
                        + environment
                        + ".properties";

        Properties properties = new Properties();
        Path path = Paths.get(filePath);

        try (InputStream inputStream = Files.newInputStream(path)) {
            if (inputStream == null) {
                throw new IllegalStateException(filePath + " was not found");
            }

            properties.load(inputStream);
            return properties;
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load " + filePath, exception);
        }
    }
}