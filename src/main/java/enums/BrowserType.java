package enums;

public enum BrowserType {
    CHROME;

    public static BrowserType from(String value) {
        return BrowserType.valueOf(value.trim().toUpperCase());
    }
}