package com.quantcast.cookie.constants;

public class ExceptionConstants {
    private ExceptionConstants() {

    }

    public static final String DATE_PARSE_EXCEPTION = "Error while parsing the date passed. Verify if the date is in the \"yyyy-MM-ddThh:mm:ssXXX\" format";
    public static final String FILE_READ_ERROR = "Error while reading the file. Check the internal logs for error.";
}
