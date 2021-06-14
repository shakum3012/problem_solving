package com.quantcast.cookie.service;

import com.quantcast.cookie.pojo.Cookie;
import com.quantcast.cookie.pojo.CookieCounter;

import java.util.Date;
import java.util.List;

public interface CountingService {
    void updateCount(List<CookieCounter> counter);
    CookieCounter getCount(String cookieName);
    List<String> getMaxCookie(String date);
    List<CookieCounter> aggregate(List<Cookie> cookies);
}
