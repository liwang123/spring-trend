package com.thingtrust.trend.util;

public class TezosUtil {
    public static String getUrl() {
        final int apiNumber = (int) (Math.random() * 4) + 1;
        final String apiUrl = "https://api" + apiNumber + ".tzscan.io";
        return apiUrl;
    }


    public static int getStatus(final String status) {
        if (status.equals("cycle_pending")) {
            //未开始烘焙
            return 1;
        }
        if (status.equals("cycle_in_progress")) {
            //烘焙中
            return 2;
        }
        if (status.equals("rewards_pending")) {
            //发放奖励中
            return 6;
        }
        //发放完成
        return 4;
    }

    public static String getStatus(final int status) {
        if (status == 1) {
            //未开始烘焙
            return "Estimated";
        }
        if (status == 2) {
            //烘焙中
            return "Roasting";
        }
        if (status == 3) {
            //发放奖励中
            return "Paying";
        }
        if (status == 4) {
            //发放完成
            return "Paid";
        }
        //未发放
        if (status == 6) {
            return "Frozen";
        }
        //发放完成
        return "Failure";
    }
}
