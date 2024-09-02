package io.github.gomestkd.introducaospringmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    public static String decodeParam(String text) throws UnsupportedEncodingException {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date converDate(String textDate, Date defaultDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        return sdf.parse(textDate);
    }
}
