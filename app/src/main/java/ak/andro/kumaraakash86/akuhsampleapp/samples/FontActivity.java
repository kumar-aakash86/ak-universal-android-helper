package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Utilities.AKTextUtilities;

public class FontActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_font);

        mContext = mActivity = this;

        SetById();
        SetByView();
    }

    private void SetById()
    {
        AKTextUtilities.setTypeFace(mActivity, R.id.tv_os_light, "fonts/OpenSans-Light.ttf");
        AKTextUtilities.setTypeFace(mActivity, R.id.tv_os_regular, "fonts/OpenSans-Regular.ttf");
        AKTextUtilities.setTypeFace(mActivity, R.id.tv_os_bold, "fonts/OpenSans-Bold.ttf");
    }


    private void SetByView()
    {
        TextView tv_roboto_light = (TextView) findViewById(R.id.tv_roboto_light);
        TextView tv_roboto_regular = (TextView) findViewById(R.id.tv_roboto_regular);
        TextView tv_roboto_bold = (TextView) findViewById(R.id.tv_roboto_bold);
        AKTextUtilities.setTypeFace(mContext, tv_roboto_light, "fonts/OpenSans-Light.ttf");
        AKTextUtilities.setTypeFace(mContext, tv_roboto_regular, "fonts/OpenSans-Regular.ttf");
        AKTextUtilities.setTypeFace(mContext, tv_roboto_bold, "fonts/OpenSans-Bold.ttf");
    }
}
