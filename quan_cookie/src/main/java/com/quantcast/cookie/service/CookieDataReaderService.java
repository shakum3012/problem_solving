package com.quantcast.cookie.service;

import com.quantcast.cookie.pojo.Cookie;
import com.quantcast.cookie.pojo.CookieCounter;
import com.quantcast.cookie.pojo.DataLocation;

import java.util.List;

public interface CookieDataReaderService {
    List<Cookie> getData(DataLocation location);
}
