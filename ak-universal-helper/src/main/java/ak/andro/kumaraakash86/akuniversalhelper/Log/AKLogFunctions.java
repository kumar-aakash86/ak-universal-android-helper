package ak.andro.kumaraakash86.akuniversalhelper.Log;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalHelper;

/**
 * Created by AAKASH on 5/19/2016.
 */
public class AKLogFunctions {


    //	LOG MESSAGES WITH CLASS, SECTION AND STRING MESSAGE
    public static void ErrorMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            ErrorMessage("Error",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void DebugMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            DebugMessage("Debug",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void InfoMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            InfoMessage("Info",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void VerboseMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            VerboseMessage("Verbose",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }

    public static void WarnMessage(Class cls, @Nullable String section, String msg)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            WarnMessage("Warn",cls.getName()+((section == null) ? "" : " "+section)+":"+((msg == null) ? "null" : msg));
        }
    }



    //	LOG MESSAGES WITH CLASS, SECTION AND EXCEPTION
    public static void ErrorMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            ErrorMessage("Error",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void DebugMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            DebugMessage("Debug",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void InfoMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            InfoMessage("Info",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void VerboseMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            VerboseMessage("Verbose",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }

    public static void WarnMessage(Class cls, @Nullable String section, Exception e)
    {
        if(cls != null && AKUniversalHelper.getInstance().isLoggingEnabled())
        {
            WarnMessage("Warn",cls.getName()+((section == null) ? "" : " "+section)+" (Line :"+e.getStackTrace()[0].getLineNumber()+")"+":"+ e.toString());
        }
    }


    //	LOG MESSAGES WITH TAG, SECTION AND STRING MESSAGE
    public static void ErrorMessage(String tag, String msg)
    {
        Log.e("Error",tag+":"+msg);
        LogInFile("Error", tag+":"+msg);
    }

    public static void DebugMessage(String tag, String msg)
    {
        Log.d("Debug",tag+":"+msg);
        LogInFile("Debug",tag+":"+msg);
    }

    public static void InfoMessage(String tag, String msg)
    {
        Log.i("Info",tag+":"+msg);
        LogInFile("Info",tag+":"+msg);
    }

    public static void VerboseMessage(String tag, String msg)
    {
        Log.i("Verbose",tag+":"+msg);
        LogInFile("Verbose",tag+":"+msg);
    }

    public static void WarnMessage(String tag, String msg)
    {
        Log.i("Warn",tag+":"+msg);
        LogInFile("Warn",tag+":"+msg);
    }


    //SAVE LOGS IN FILE *START
    private static void LogInFile(@Nullable String section, String msg){
        if(AKUniversalHelper.getInstance().isSavingEnabled())
        {
            Logger.logToFile(AKUniversalHelper.getInstance().getContext(), section, msg);
        }
    }
    //SAVE LOGS IN FILE *END


    //MAIL LOGS IN FILE *START
    public static void AttachLogFile(Context context, Intent emailIntent){
        if(AKUniversalHelper.getInstance().isSavingEnabled())
        {
            Logger.AttachLogFile(context, emailIntent);
        }
        else
        {
            Toast.makeText(context, "Cannot attach log as saving log is disable.", Toast.LENGTH_LONG).show();
        }
    }
    //MAIL LOGS IN FILE *END
}
