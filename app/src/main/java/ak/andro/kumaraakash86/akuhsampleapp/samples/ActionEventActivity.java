package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuhsampleapp.samples.child.ShakeActivity;

public class ActionEventActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_event);

        mContext = mActivity = this;
    }


    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_action_shake:
                startActivity(new Intent(mContext, ShakeActivity.class));
                break;
        }
    }
}
