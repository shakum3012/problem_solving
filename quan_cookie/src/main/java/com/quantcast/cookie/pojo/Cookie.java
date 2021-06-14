package com.quantcast.cookie.pojo;

import com.quantcast.cookie.constants.ExceptionConstants;
import com.quantcast.cookie.exceptions.CustomException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class Cookie {
    private String name;
    private Date timestamp;

    private static final String COOKIE_ACCESS_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssXXX";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(COOKIE_ACCESS_DATE_FORMAT);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Cookie(String name, Date timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }

    public Cookie(String name, String timestamp) {
        this.name = name;
        try {
            this.timestamp = DATE_FORMAT.parse(timestamp);
        } catch (ParseException ex) {
            throw new CustomException(ExceptionConstants.DATE_PARSE_EXCEPTION);
        }
    }

    @Override
    public String toString(){
        return String.format("name: %s timestamp: %s", this.name, DATE_FORMAT.format(this.timestamp));
    }
}
