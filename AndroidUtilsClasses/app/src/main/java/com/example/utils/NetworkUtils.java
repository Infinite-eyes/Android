package com.example.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Author:cwm
 * DateTime:2017/6/13 14:50
 * Email:chenwm
 * Desc:
 **/
public class NetworkUtils {

    public static int isNetworkAvailable(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager == null){
            return 0;
        }else{
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if(info!=null){
                for(int i = 0; i < info.length ; i++){
                    if(info[i].getState()==NetworkInfo.State.CONNECTED){
                        NetworkInfo networkInfo = info[i];
                        if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI)
                            return 1;
                        else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                            String extraInfo = networkInfo.getExtraInfo();
                            if("cmwap".equalsIgnoreCase(extraInfo)||"cmwap:gsm".equalsIgnoreCase(extraInfo)){
                                return 2;
                            }
                            return 3;
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static boolean checkNet(Context context){
        ConnectivityManager manager = ServiceManager.getConnectivityManager(context);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info != null && info.isAvailable()&& info.isConnected()){
            return true;
        }else{
            return false;
        }
    }

    public static String getIP_v4(){

        try {
            for(Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();en.hasMoreElements();){
                NetworkInterface intf = en.nextElement();
                for(Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses();enumIpAddr.hasMoreElements();){
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if(!inetAddress.isLoopbackAddress()&&(inetAddress instanceof Inet4Address)){
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }








}
