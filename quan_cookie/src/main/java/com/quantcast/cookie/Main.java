package com.quantcast.cookie;

import com.quantcast.cookie.impl.CookieDataFileReaderImpl;
import com.quantcast.cookie.impl.CountingServiceImpl;
import com.quantcast.cookie.pojo.Cookie;
import com.quantcast.cookie.pojo.CookieCounter;
import com.quantcast.cookie.pojo.DataLocation;
import com.quantcast.cookie.service.CookieDataReaderService;
import com.quantcast.cookie.service.CountingService;

import java.util.List;

public class Main {
    public static void main(String[] args){
        System.out.println("Service started");
        CookieDataReaderService dataReaderService = new CookieDataFileReaderImpl();
        DataLocation dataLocation = new DataLocation();
        dataLocation.setPath("/Users/sthondap/Downloads/cookie.csv");
        List<Cookie> data  = dataReaderService.getData(dataLocation);
        CountingService countingService = new CountingServiceImpl();
        List<CookieCounter> cc = countingService.aggregate(data);
        countingService.updateCount(cc);
        List<String> maxCookie = countingService.getMaxCookie("2018-12-09");
        System.out.println(maxCookie);
    }
}
