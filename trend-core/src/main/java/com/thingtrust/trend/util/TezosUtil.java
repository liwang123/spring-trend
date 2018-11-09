package com.thingtrust.trend.util;

public class TezosUtil {
    public static String getUrl() {
        final int apiNumber = (int) (Math.random() * 4) + 1;
        final String apiUrl = "https://api" + apiNumber + ".tzscan.io";
        return apiUrl;
    }
}
