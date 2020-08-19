package com.problemfighter.appcommon;

import java.util.UUID;

public final class AppCommonUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().toUpperCase();
    }


}
