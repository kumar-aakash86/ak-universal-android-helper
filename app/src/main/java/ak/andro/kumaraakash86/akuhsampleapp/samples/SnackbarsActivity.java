package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Alerts.SnackFunctions;

/**
 * Created by AAKASH on 08-10-2016.
 */
public class SnackbarsActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    SeekBar sb_red, sb_green, sb_blue, sb_alpha;
    View color_container;
    int red=0, green=0, blue=0, alpha=255;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbars);

        mContext = mActivity = this;

        InitControls();
        InitEvents();
    }

    private void InitControls() {
        sb_red = (SeekBar) findViewById(R.id.sb_red);
        sb_green = (SeekBar) findViewById(R.id.sb_green);
        sb_blue = (SeekBar) findViewById(R.id.sb_blue);
        sb_alpha = (SeekBar) findViewById(R.id.sb_alpha);

        color_container = (View) findViewById(R.id.color_preview);
    }


    private void InitEvents() {
        sb_red.setOnSeekBarChangeListener(changed);
        sb_green.setOnSeekBarChangeListener(changed);
        sb_blue.setOnSeekBarChangeListener(changed);
        sb_alpha.setOnSeekBarChangeListener(changed);
    }

    private SeekBar.OnSeekBarChangeListener changed = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId())
            {
                case R.id.sb_red:
                    red = progress;
                    break;
                case R.id.sb_green:
                    green = progress;
                    break;
                case R.id.sb_blue:
                    blue = progress;
                    break;
                case R.id.sb_alpha:
                    alpha = progress;
                    break;
            }
            color_container.setBackgroundColor(Color.argb(alpha, red, green, blue));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_default_snackbar:
                SnackFunctions.ShowSnackbar(mActivity, "This is default snackbar");
                break;
            case R.id.btn_alert_snackbar:
                SnackFunctions.ShowSnackbar(mActivity, "This is alert snackbar", SnackFunctions.SnackType.Alert);
                break;
            case R.id.btn_success_snackbar:
                SnackFunctions.ShowSnackbar(mActivity, "This is success snackbar", SnackFunctions.SnackType.Success);
                break;
            case R.id.btn_info_snackbar:
                SnackFunctions.ShowSnackbar(mActivity, "This is info snackbar", SnackFunctions.SnackType.Info);
                break;
            case R.id.btn_custom_snackbar:
                SnackFunctions.ShowSnackbar(mActivity, "This is custom snackbar", Color.argb(alpha, red, green, blue));
                break;
        }
    }


}