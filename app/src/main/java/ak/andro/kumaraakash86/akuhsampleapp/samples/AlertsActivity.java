package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuhsampleapp.samples.child.SnackbarsActivity;

/**
 * Created by AAKASH on 08-10-2016.
 */
public class AlertsActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        mContext = this;
    }

    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_snackbars:
                startActivity(new Intent(mContext, SnackbarsActivity.class));
                break;
        }
    }


}