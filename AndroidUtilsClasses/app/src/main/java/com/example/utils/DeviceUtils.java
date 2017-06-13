package com.example.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import java.util.Locale;

/**
 * Author:cwm
 * DateTime:2017/6/13 14:01
 * Email:chenwm
 * Desc:
 **/
public class DeviceUtils {

    public static String getLanguage(Context context){
        Locale locale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
             locale = context.getResources().getConfiguration().getLocales().get(0);
        }else{
            locale = context.getResources().getConfiguration().locale;
        }
        return locale.getLanguage();
    }

    public static String getNetworkOperatorName(Context context){

        String networkOperatorName = ServiceManager.getTelephonyManager(context).getNetworkOperatorName();

        switch (networkOperatorName){
            case "46000":
            case "46002":
            case "46007":
                networkOperatorName = context.getResources().getString(R.string.label_china_cmcc);
                break;
            case "46001":
                networkOperatorName = context.getResources().getString(R.string.label_china_unicom);
                break;
            case "46003":
                networkOperatorName = context.getResources().getString(R.string.label_china_telecommunications);
                break;
            default:
                networkOperatorName = "";
                break;
        }
        return  networkOperatorName;
    }

    public static String getSystemVersion(){
        return Build.VERSION.RELEASE;
    }

    public static String getDeviceMerchant(){
        return Build.MODEL;
    }

    public static String getPhoneIMEI(Context context){
        String deviceId = ServiceManager.getTelephonyManager(context).getDeviceId();

        if(TextUtils.isEmpty(deviceId)){
            deviceId = Settings.Secure.getString(context.getContentResolver(),Settings.Secure.ANDROID_ID);
        }
        return deviceId;
    }


}
