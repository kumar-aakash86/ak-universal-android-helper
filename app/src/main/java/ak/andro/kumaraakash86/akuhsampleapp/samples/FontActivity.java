package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        AKTextUtilities.setTypeFace(mActivity, "fonts/OpenSans-Light.ttf", R.id.tv_os_light);
        AKTextUtilities.setTypeFace(mActivity, "fonts/OpenSans-Regular.ttf", R.id.tv_os_regular);
        AKTextUtilities.setTypeFace(mActivity, "fonts/OpenSans-Bold.ttf", R.id.tv_os_bold);
        AKTextUtilities.setTypeFace(mActivity, "fonts/OpenSans-Light.ttf", R.id.tv_multi_text1, R.id.tv_multi_text2, R.id.tv_multi_text3, R.id.tv_multi_text4);
    }


    private void SetByView()
    {
        TextView tv_roboto_light = (TextView) findViewById(R.id.tv_roboto_light);
        TextView tv_roboto_regular = (TextView) findViewById(R.id.tv_roboto_regular);
        TextView tv_roboto_bold = (TextView) findViewById(R.id.tv_roboto_bold);
        AKTextUtilities.setTypeFace(mContext, "fonts/OpenSans-Light.ttf", tv_roboto_light);
        AKTextUtilities.setTypeFace(mContext, "fonts/OpenSans-Regular.ttf", tv_roboto_regular);
        AKTextUtilities.setTypeFace(mContext, "fonts/OpenSans-Bold.ttf", tv_roboto_bold);
    }
}
