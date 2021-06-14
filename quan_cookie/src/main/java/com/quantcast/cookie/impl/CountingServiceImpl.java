package com.quantcast.cookie.impl;

import com.quantcast.cookie.pojo.Cookie;
import com.quantcast.cookie.pojo.CookieCounter;
import com.quantcast.cookie.service.CountingService;

import java.text.SimpleDateFormat;
import java.util.*;

public class CountingServiceImpl implements CountingService {
    private static HashMap<String, HashMap<String, Integer>> cookieCount = new HashMap<>();

    @Override
    public void updateCount(List<CookieCounter> counterList) {
        counterList.forEach(counter -> {
            HashMap<String, Integer> cookieMap = cookieCount.getOrDefault(counter.getDate(), new HashMap<>());
            Integer existingValue = cookieMap.getOrDefault(counter.getCookieName(), 0);
            existingValue += counter.getCount();
            cookieMap.put(counter.getCookieName(), existingValue);
            cookieCount.put(counter.getDate(), cookieMap);
        });
    }

    @Override
    public CookieCounter getCount(String cookieName) {
        return null;
    }

    @Override
    public List<String> getMaxCookie(String date) {
        if (!cookieCount.containsKey(date)) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> cookieMap = cookieCount.get(date);
        List<String> maxCookies = new ArrayList<>();
        Integer maxValue = 0;

        for(String cookieName: cookieMap.keySet()){
            if (cookieMap.get(cookieName) > maxValue) {
                maxValue = cookieMap.get(cookieName);
                maxCookies = new ArrayList<>(Arrays.asList(cookieName));
            } else if (cookieMap.get(cookieName) == maxValue) {
                maxCookies.add(cookieName);
            }
        }

        return maxCookies;
    }

    @Override
    public List<CookieCounter> aggregate(List<Cookie> cookies) {
        HashMap<String, HashMap<String , Integer>> counter = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        for (Cookie c: cookies) {
            String key = simpleDateFormat.format(c.getTimestamp());
            HashMap<String, Integer> cookieCounter = counter.getOrDefault(key, new HashMap<>());
            Integer existingCookieVal = cookieCounter.getOrDefault(c.getName(), 0);
            cookieCounter.put(c.getName(), existingCookieVal + 1);
            counter.put(key, cookieCounter);
        }

        List<CookieCounter> cookieCounters = new ArrayList<>();
        for (String date: counter.keySet()) {
            HashMap<String, Integer> countMap = counter.get(date);
            for(String cookie: countMap.keySet()) {
                CookieCounter cookieCounter = new CookieCounter();
                cookieCounter.setDate(date);
                cookieCounter.setCount(countMap.get(cookie));
                cookieCounter.setCookieName(cookie);
                cookieCounters.add(cookieCounter);
            }
        }
        return cookieCounters;
    }

}
