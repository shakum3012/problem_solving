package com.quantcast.cookie.impl;

import com.quantcast.cookie.constants.ExceptionConstants;
import com.quantcast.cookie.exceptions.CustomException;
import com.quantcast.cookie.pojo.Cookie;
import com.quantcast.cookie.pojo.DataLocation;
import com.quantcast.cookie.service.CookieDataReaderService;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CookieDataFileReaderImpl implements CookieDataReaderService {

    private static final String FIELD_SEPARATOR = ",";

    @Override
    public List<Cookie> getData(DataLocation location) {
        List<Cookie> cookieInfo = new ArrayList();
        Path filePath = Paths.get(location.getPath());
        Charset charset = StandardCharsets.UTF_8;
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath, charset);
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
            throw new CustomException(ExceptionConstants.FILE_READ_ERROR);
        }

        lines.forEach(line -> {
            String[] data = line.split(FIELD_SEPARATOR);
            Cookie c = new Cookie(data[0], data[1]);
            cookieInfo.add(c);
        });

        return cookieInfo;
    }
}
