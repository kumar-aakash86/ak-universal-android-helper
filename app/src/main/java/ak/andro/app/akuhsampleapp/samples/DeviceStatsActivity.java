package ak.andro.app.akuhsampleapp.samples;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import ak.andro.app.akuhsampleapp.R;
import ak.andro.app.akuniversalhelper.Log.DeviceStatsFunctions;

/**
 * Created by AAKASH on 04-10-2016.
 */
public class DeviceStatsActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_stats);

        mContext = this;
    }

    public void ActionClick(View view) {
        switch (view.getTag().toString())
        {
            case "ns":
                CheckNetworkStatus();
                break;
            case "cgps":
                CheckIfGPSAvailable();
                break;
        }
    }

    private void CheckNetworkStatus() {
        Toast.makeText(mContext, "Network "+(DeviceStatsFunctions.isNetworkAvailable(mContext) ? "Enabeled" : "Disabled"), Toast.LENGTH_LONG).show();
    }
    private void CheckIfGPSAvailable() {
        PackageManager pm = mContext.getPackageManager();
        Toast.makeText(mContext, "GPS "+(pm.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS) ? "Available" : "Not Available"), Toast.LENGTH_LONG).show();
    }

}
