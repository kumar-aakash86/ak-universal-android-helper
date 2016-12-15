package ak.andro.kumaraakash86.akuhsampleapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ak.andro.kumaraakash86.akuhsampleapp.samples.ActionEventActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.AlertsActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.DateActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.DeviceStatsActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.FontActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.LogMessagesActivity;
import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalConfiguration;
import ak.andro.kumaraakash86.akuniversalhelper.core.AKUniversalHelper;

public class MainActivity extends AppCompatActivity {
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        AKUniversalConfiguration.Builder config = new AKUniversalConfiguration.Builder(mContext);
        config.EnagleLogMessages(true);
        AKUniversalHelper.getInstance().init(config.build());
    }

    public void ActionClick(View view) {
        switch(view.getId())
        {
            case R.id.btn_log:
                startActivity(new Intent(mContext, LogMessagesActivity.class));
                break;
            case R.id.btn_device_stats:
                startActivity(new Intent(mContext, DeviceStatsActivity.class));
                break;
            case R.id.btn_alerts:
                startActivity(new Intent(mContext, AlertsActivity.class));
                break;
            case R.id.btn_fonts:
                startActivity(new Intent(mContext, FontActivity.class));
                break;
            case R.id.btn_dates:
                startActivity(new Intent(mContext, DateActivity.class));
                break;
            case R.id.btn_action_events:
                startActivity(new Intent(mContext, ActionEventActivity.class));
                break;
        }
    }
}
