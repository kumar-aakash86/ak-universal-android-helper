package ak.andro.kumaraakash86.akuniversalhelper.Log;

import android.support.annotation.Nullable;
import android.util.Log;

import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalHelper;

/**
 * Created by AAKASH on 5/19/2016.
 */
public class AKLogFunctions {


//	LOG MESSAGES

    public static void ErrorMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.e("Error",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void DebugMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.d("Debug",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void InfoMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.i("Info",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void VerboseMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.v("Verbose",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void WarnMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.w("Warn",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }



    public static void ErrorMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.e("Error",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void DebugMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.d("Debug",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void InfoMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.i("Info",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void VerboseMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.v("Verbose",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void WarnMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            Log.w("Warn",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }
//	LOG MESSAGES
}
