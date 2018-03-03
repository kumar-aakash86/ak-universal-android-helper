package ak.andro.kumaraakash86.akuhsampleapp.samples.child;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Alerts.AKSnackFunctions;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;
import ak.andro.kumaraakash86.akuniversalhelper.network.AKUpdateChecker;

public class UpdateCheckerActivity extends AppCompatActivity {

    Context mContext;
    Activity mActivity;

    EditText et_update_package_name, et_update_package_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_checker);

        mContext = mActivity = this;

        InitControls();
    }

    private void InitControls() {
        et_update_package_name = (EditText) findViewById(R.id.et_update_package_name);
        et_update_package_version = (EditText) findViewById(R.id.et_update_package_version);
    }

    public void ActionClick(View view) {
        switch (view.getId()){
            case R.id.btn_update_package_check:
                CheckForUpdate();
                break;
            case R.id.btn_check_app_update:
                CheckUpdateForThisApp();
                break;
        }
    }

    private void CheckUpdateForThisApp() {
        AKUpdateChecker updateChecker = new AKUpdateChecker(mActivity);
        updateChecker.CheckForUpdate(new AKUpdateChecker.OnUpdateCallback() {
            @Override
            public void onUpdateFound(boolean foundUpdate) {
                Toast.makeText(mActivity, (foundUpdate ? "Update available" : "No update found"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CheckForUpdate() {
        AKUpdateChecker updateChecker = new AKUpdateChecker(mActivity);
        String packageName = et_update_package_name.getText().toString();
        String version = et_update_package_version.getText().toString();
        updateChecker.CheckForUpdate(packageName, version, new AKUpdateChecker.OnUpdateCallback() {
            @Override
            public void onUpdateFound(boolean foundUpdate) {
                Toast.makeText(mActivity, (foundUpdate ? "Update available" : "No update found"), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
