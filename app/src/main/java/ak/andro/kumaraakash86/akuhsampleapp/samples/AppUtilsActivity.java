package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuhsampleapp.samples.child.ShakeActivity;
import ak.andro.kumaraakash86.akuhsampleapp.samples.child.UpdateCheckerActivity;
import ak.andro.kumaraakash86.akuniversalhelper.Utilities.AKRatings;

public class AppUtilsActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_utils);

        mContext = mActivity = this;
    }

    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_action_update_checker:
                startActivity(new Intent(mContext, UpdateCheckerActivity.class));
                break;
            case R.id.btn_action_show_rating:
//                AKRatings.Builder ratingBuilder = new AKRatings.Builder(mContext);
//                ratingBuilder.CheckForRating();
                AKRatings.ShowRatingDialog(mContext);
                Toast.makeText(mContext, "Checking to show rating", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
