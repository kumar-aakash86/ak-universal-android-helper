package ak.andro.kumaraakash86.akuniversalhelper.Device;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.RequiresPermission;

import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;

/**
 * Created by AAKASH on 04-10-2016.
 */
public class AKDeviceStatsFunctions {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    public static boolean IsNetworkAvailable(Context _context) {
        ConnectivityManager connectivityManager = (ConnectivityManager)_context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static boolean IsGPSModuleAvailable(Context _context)
    {
        try {
            PackageManager pm = _context.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
        }
        catch (Exception e)
        {
            AKLogFunctions.ErrorMessage(_context.getClass(), "IsGPSModuleAvailable Error", e);
            return false;
        }
    }

    public static boolean IsGyroscopeAvailable(Context _context)
    {
        try {
            PackageManager pm = _context.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_GYROSCOPE);
        }
        catch (Exception e)
        {
            AKLogFunctions.ErrorMessage(_context.getClass(), "IsGyroscopeAvailable Error", e);
            return false;
        }
    }

    public static boolean IsFrontCameraAvailable(Context _context)
    {
        try {
            PackageManager pm = _context.getPackageManager();
            return pm.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT);
        }
        catch (Exception e)
        {
            AKLogFunctions.ErrorMessage(_context.getClass(), "IsFrontCameraAvailable Error", e);
            return false;
        }
    }


}
