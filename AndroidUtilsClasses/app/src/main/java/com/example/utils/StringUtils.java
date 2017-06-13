package com.example.utils;

import android.content.Context;
import android.text.TextUtils;

import com.example.utils.application.App;

/**
 * Author:cwm
 * DateTime:2017/6/13 22:14
 * Email:chenwm
 * Desc:
 **/
public class StringUtils {
    private static Context context = App.appContext;

    public static String string(Object v){
        if(v == null || "null".equals(v))
            return "";
        String value = "";
        value = String.valueOf(v);
        return value;
    }

    public static boolean isEmpty(String str){
        return str == null||str.length()==0;
    }

    public static boolean isBlank(String str){
        int strLen;
        if(str == null || (strLen = str.length())==0){
            return true;
        }
        if(TextUtils.equals("null",str.toLowerCase())) {
            return true;
        }
        for(int i=0; i < strLen; i++){
            if((Character.isWhitespace(str.charAt(i))==false)){
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str){
        return !StringUtils.isBlank(str);
    }

    public static String getHidePhoneNum(String phoneNum){
        if(phoneNum == null || phoneNum.length()!=11){
            return "";
        }
        return phoneNum.substring(0,3) + "****" + phoneNum.substring(phoneNum.length() - 4, phoneNum.length());
    }

    public static String getHideIDCardNo(String IDCardNo){

        String XH = "";
        String XIDcardNum = "";
        if(IDCardNo == null || StringUtils.isEmpty(IDCardNo)){
            return "";
        }
        if(IDCardNo.length() >= 15){
            for(int i=0 ; i<IDCardNo.length() - 8 ; i++){
                XH += "*";
            }
            XIDcardNum = IDCardNo.substring(0,4) + XH + IDCardNo.substring(IDCardNo.length() - 4, IDCardNo.length());
        }else{
            XIDcardNum = IDCardNo;
        }
        return XIDcardNum;
    }

    public static String getHideBankCardNum(String bankCardNum){
        String XH = "";
        String XBnkNum = "";
        if(bankCardNum == null || StringUtils.isEmpty(bankCardNum)){
            return "";
        }
        if(bankCardNum.length()>16){
            for(int i=0; i < bankCardNum.length() - 10; i++){
                XH+="*";
            }
            XBnkNum = bankCardNum.substring(0,6) + XH + bankCardNum.substring(bankCardNum.length() - 4,bankCardNum.length());
        }else{
            XBnkNum = bankCardNum;
        }
        return XBnkNum;
    }

    public static boolean isZero(String string){
        if(TextUtils.equals("0",string)
                ||TextUtils.equals("0.0",string)
                ||TextUtils.equals("0.00",string)
                ||TextUtils.equals("0.",string)
                ||TextUtils.equals(".0",string)
                ||TextUtils.equals(".00",string)){
            return true;
        }
        return false;
    }

    public static boolean checkParameter(String... a){
        for(int i=0;i<a.length;i++){
            if(StringUtils.isBlank(a[i])){
//                ToastUtils.show(context, R.string.toast_incoming_parameter_exception);
                return false;
            }
        }
        return true;
    }

}
