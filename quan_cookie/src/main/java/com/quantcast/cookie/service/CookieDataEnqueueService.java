package com.quantcast.cookie.service;

import com.quantcast.cookie.pojo.Cookie;

import java.util.List;

public interface CookieDataEnqueueService {
    void enqueue(List<Cookie> cookieInfoList);
}
