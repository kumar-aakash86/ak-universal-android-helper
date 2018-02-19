package ak.andro.kumaraakash86.akuniversalhelper.Listeners;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import ak.andro.kumaraakash86.akuniversalhelper.Listeners.shake.AKShakeDetector;
import ak.andro.kumaraakash86.akuniversalhelper.Listeners.shake.AKShakeListener;

/**
 * Created by AAKASH on 15-12-2016.
 */
public class AKActionEvents {

    static Activity mActivity;
    static AKShakeListener shakeListener;
    private static SensorManager mSensorManager;
    private static AKShakeDetector shakeDetector;


    public static void SetShakeListener(Activity activity, AKShakeListener listener)
    {
        shakeListener = listener;
        mActivity = activity;
        if (mSensorManager == null) {
            mSensorManager = (SensorManager) mActivity.getSystemService(Context.SENSOR_SERVICE);
        }
        shakeDetector = new AKShakeDetector(shakeListener);
    }
    public static boolean StartListening() {
        boolean status=false;
        if (mSensorManager != null && shakeListener != null) {
            status= mSensorManager.registerListener(shakeDetector, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);
        }
        return status;
    }
    public static void StopListening() {
        if (mSensorManager != null && shakeListener != null) {
            mSensorManager.unregisterListener(shakeDetector);
        }
    }

}
