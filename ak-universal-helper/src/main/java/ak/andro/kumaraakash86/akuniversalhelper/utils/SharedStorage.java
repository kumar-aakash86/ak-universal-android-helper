package ak.andro.kumaraakash86.akuniversalhelper.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by Aakash Kumar on 3/3/2018.
 */

public class SharedStorage {

    private static final String PREF_NAME = ".AK_LIBRARY";
    public static final String PREF_KEY_RATING_COMPLETE = "RATING_COMPLETE";
    public static final String PREF_KEY_RATING_COUNT = "RATING_COUNT";

    @Retention(SOURCE)
    @StringDef({PREF_KEY_RATING_COMPLETE, PREF_KEY_RATING_COUNT})
    public @interface PreferenceKeys {}

    SharedPreferences sharedPreferences;

    private static SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(context.getPackageName()+PREF_NAME, Context.MODE_PRIVATE);
    }

    public static void saveStringToStorage(Context context, @PreferenceKeys String key, String value){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getStringFromStorage(Context context, @PreferenceKeys String key){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if(!sharedPreferences.contains(key))
            return null;
        else
            return sharedPreferences.getString(key, null);
    }

    public static void saveBooleanToStorage(Context context, @PreferenceKeys String key, boolean value){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static Boolean getBooleanFromStorage(Context context, @PreferenceKeys String key){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if(!sharedPreferences.contains(key))
            return false;
        else
            return sharedPreferences.getBoolean(key, false);
    }

    public static void saveIntToStorage(Context context, @PreferenceKeys String key, int value){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getIntFromStorage(Context context, @PreferenceKeys String key){
        SharedPreferences sharedPreferences = getSharedPreferences(context);
        if(!sharedPreferences.contains(key))
            return 0;
        else
            return sharedPreferences.getInt(key, 0);
    }
}
