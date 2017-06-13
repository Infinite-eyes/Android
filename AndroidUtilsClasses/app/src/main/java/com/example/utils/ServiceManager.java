package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;

/**
 * Author:cwm
 * DateTime:2017/6/13 14:14
 * Email:chenwm
 * Desc:
 **/
public class ServiceManager {

    private static ConnectivityManager connectivityManager;
    private static TelephonyManager telephonyManager;

    public static TelephonyManager getTelephonyManager(Context context){
        if(telephonyManager == null){
            synchronized (ServiceManager.class){
                if(telephonyManager==null){
                    telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                }
            }
        }
        return telephonyManager;
    }

    public static ConnectivityManager getConnectivityManager(Context context){
        if (connectivityManager == null){
            synchronized (ServiceManager.class){
                if(connectivityManager == null){
                    connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                }
            }
        }
        return connectivityManager;
    }

}
