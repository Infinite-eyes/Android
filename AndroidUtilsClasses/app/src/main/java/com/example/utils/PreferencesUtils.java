package com.example.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Author:cwm
 * DateTime:2017/6/12 22:55
 * Email:chenwm
 * Desc:sharedPreferences Utils
 **/
public class PreferencesUtils {

    private static String PREFERENCE_NAME = "share_data";

    public static void put(Context context,String key,Object object){

        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if(object instanceof String) {
            editor.putString(key,(String)object);
        }else if(object instanceof Integer){
            editor.putInt(key,(Integer)object);
        }else if(object instanceof  Boolean){
            editor.putBoolean(key,(Boolean)object);
        }else if(object instanceof Float){
            editor.putFloat(key,(Float)object);
        }else if(object instanceof  Long){
            editor.putLong(key,(Long)object);
        }else{
            editor.putString(key,StringUtils.string(object));
        }
        SharedPreferencesCompat.apply(editor);
    }
    public static Object get(Context context,String key,Object defaultObject){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        if(defaultObject instanceof String){
            return sp.getString(key,(String)defaultObject);
        }else if(defaultObject instanceof Integer){
            return sp.getInt(key, (Integer) defaultObject);
        }else if(defaultObject instanceof Boolean){
            return sp.getBoolean(key, (Boolean) defaultObject);
        }else if(defaultObject instanceof  Float){
            return sp.getFloat(key, (Float) defaultObject);
        }else if(defaultObject instanceof Long){
            return sp.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    public static void remove(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    public static void clear(Context context){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }
    public static boolean contains(Context context, String key){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    public static Map<String, ?> getAll(Context context){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sp.getAll();
    }




    private static class SharedPreferencesCompat{

        private static final Method sApplyMethod = findApplyMethod();

        private static Method findApplyMethod(){

            Class clz = SharedPreferences.Editor.class;
            try {
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void apply(SharedPreferences.Editor editor){

            if(sApplyMethod != null){
                try {
                    sApplyMethod.invoke(editor);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            editor.commit();
        }
    }



}
