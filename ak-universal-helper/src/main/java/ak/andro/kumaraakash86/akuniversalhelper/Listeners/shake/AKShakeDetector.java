package ak.andro.kumaraakash86.akuniversalhelper.Listeners.shake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/**
 * Created by AAKASH on 15-12-2016.
 */
public class AKShakeDetector implements SensorEventListener {
    private long mShakeTimestamp;
    private int mShakeCount;
    private boolean mShaked = false;
    private AKShakeListener shakeListener;
    private static final float SHAKE_THRESHOLD_GRAVITY = 5.7F;
    private static final int SHAKE_SLOP_TIME_MS = 500;
    private static final int SHAKE_COUNT_RESET_TIME_MS = 3000;

    public AKShakeDetector(AKShakeListener listener)
    {
        shakeListener = listener;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (shakeListener != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float gX = x / SensorManager.GRAVITY_EARTH;
            float gY = y / SensorManager.GRAVITY_EARTH;
            float gZ = z / SensorManager.GRAVITY_EARTH;

            float gForce = Math.abs(gX * gX + gY * gY + gZ * gZ);

            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                final long now = System.currentTimeMillis();
                if (mShakeTimestamp + SHAKE_SLOP_TIME_MS > now) {
                    return;
                }
                if (mShakeTimestamp + SHAKE_COUNT_RESET_TIME_MS < now) {
                    mShakeCount = 0;
                }
                mShakeTimestamp = now;
                mShakeCount++;
                if(!mShaked) {
                    mShaked = true;
                    shakeListener.shakeDetected(mShaked);
                }
            }
            else{
                if(mShaked) {
                    mShaked = false;
                    shakeListener.shakeDetected(mShaked);
                }
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
