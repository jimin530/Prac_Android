package com.jmdroid.prac_angularweb.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by jimin on 2017-02-06.
 */
public class Util {
    private static Util ourInstance = new Util();

    public static Util getInstance() {
        return ourInstance;
    }

    private Util() {
    }

    public String getMyPhoneNum(Context context) {
        TelephonyManager telemamanger;
        telemamanger = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telemamanger.getLine1Number();
    }
}
