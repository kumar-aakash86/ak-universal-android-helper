package ak.andro.app.akuniversalhelper.Log;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresPermission;

/**
 * Created by AAKASH on 04-10-2016.
 */
public class DeviceStatsFunctions {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    public static boolean IsNetworkAvailable(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager)mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean IsGPSModuleAvailable(Context mContext)
    {
        try {
            PackageManager pm = mContext.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
        }
        catch (Exception e)
        {
            LogFunctions.ErrorMessage(mContext.getClass(), "IsGPSModuleAvailable Error", e);
            return false;
        }
    }

    public static boolean IsGyroscopeAvailable(Context mContext)
    {
        try {
            PackageManager pm = mContext.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        }
        catch (Exception e)
        {
            LogFunctions.ErrorMessage(mContext.getClass(), "IsGyroscopeAvailable Error", e);
            return false;
        }
    }

    public static boolean IsFrontCameraAvailable(Context mContext)
    {
        try {
            PackageManager pm = mContext.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
        }
        catch (Exception e)
        {
            LogFunctions.ErrorMessage(mContext.getClass(), "IsFrontCameraAvailable Error", e);
            return false;
        }
    }


}
