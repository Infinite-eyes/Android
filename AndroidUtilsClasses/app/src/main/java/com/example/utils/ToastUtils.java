package com.example.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Author:cwm
 * DateTime:2017/6/13 10:03
 * Email:chenwm
 * Desc:
 **/
public class ToastUtils {

    private static Toast toast;

    public static void show(Context context,int resId){
        show(context, context.getResources().getText(resId),Toast.LENGTH_SHORT);
    }
    public static void show(Context context, int resId, int duration){
        show(context,context.getResources().getText(resId),duration);
    }
    public static void show(Context context, CharSequence text){
        show(context, text, Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId, Object... args){
        show(context, String.format(context.getResources().getString(resId),args),Toast.LENGTH_SHORT);
    }

    public static void show(Context context,String format, Object... args){
        show(context,String.format(format,args),Toast.LENGTH_SHORT);
    }

    public static void show(Context context, int resId, int duration, Object... args){
        show(context,String.format(context.getResources().getString(resId),args),duration);
    }

    public static void show(Context context, String format, int duration, Object... args){
        show(context,String.format(format,args),duration);
    }


    public static void show(Context context,CharSequence text, int duration){
        if(toast == null){
            toast = Toast.makeText(context,text,duration);
        }else{
            toast.setText(text);
            toast.setDuration(duration);
        }
        toast.show();
    }

    public static void cancel(){
        if(toast != null){
            toast.cancel();
        }
    }


}
