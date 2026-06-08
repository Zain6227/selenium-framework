package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtils {

    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    private DateUtils() {
    }

    public static String timestamp() {
        return LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }
}