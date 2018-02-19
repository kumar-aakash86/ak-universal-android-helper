package ak.andro.kumaraakash86.akuhsampleapp.samples.child;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Listeners.AKActionEvents;
import ak.andro.kumaraakash86.akuniversalhelper.Listeners.shake.AKShakeListener;

public class ShakeActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    TextView tv_shake_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        mContext = mActivity = this;

        InitControls();

        AKActionEvents.SetShakeListener(mActivity, new AKShakeListener() {
            @Override
            public void shakeDetected(boolean shaked) {
                tv_shake_status.setText(tv_shake_status.getText()+"\n"+(shaked ? "DEVICE SHOOK" : "SHAKE FINISHED"));
            }
        });
    }

    private void InitControls() {
        tv_shake_status = (TextView) findViewById(R.id.tv_shake_status);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AKActionEvents.StartListening();
    }

    @Override
    protected void onPause() {
        super.onPause();
        AKActionEvents.StopListening();
    }
}
