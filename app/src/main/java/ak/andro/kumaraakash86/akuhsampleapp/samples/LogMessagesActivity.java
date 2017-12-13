package ak.andro.kumaraakash86.akuhsampleapp.samples;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;

import ak.andro.kumaraakash86.akuhsampleapp.R;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;

/**
 * Created by AAKASH on 5/19/2016.
 */
public class LogMessagesActivity extends AppCompatActivity {
    Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_messages);

        mContext = this;
    }

    public void ActionClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_log_error_exception:
            case R.id.btn_log_debug_exception:
            case R.id.btn_log_info_exception:
            case R.id.btn_log_verbose_exception:
            case R.id.btn_log_warn_exception:
                //AKLogFunctions.ErrorMessage(getClass(), "LOG ERROR", new Exception("This is error log message"));
                RaiseError(view.getTag().toString());
                break;
        }
    }

    private void RaiseError(String tag)
    {
        try
        {
            throw new ClassNotFoundException("This is a sample class not found exception");
        }
        catch (ClassNotFoundException e)
        {
            switch (tag)
            {
                case "e":
                    AKLogFunctions.ErrorMessage(getClass(), "LOG ERROR", e);
                    break;
                case "d":
                    AKLogFunctions.DebugMessage(getClass(), "LOG DEBUG", e);
                    break;
                case "i":
                    AKLogFunctions.InfoMessage(getClass(), "LOG INFO", e);
                    break;
                case "w":
                    AKLogFunctions.WarnMessage(getClass(), "LOG WARNING", e);
                    break;
                case "v":
                    AKLogFunctions.VerboseMessage(getClass(), "LOG VERBOSE", e);
                    break;
            }
        }

        try
        {
            throw new JSONException("This is a sample json exception");
        }
        catch (JSONException e)
        {
            switch (tag)
            {
                case "e":
                    AKLogFunctions.ErrorMessage(getClass(), null, e);
                    break;
                case "d":
                    AKLogFunctions.DebugMessage(getClass(), null, e);
                    break;
                case "i":
                    AKLogFunctions.InfoMessage(getClass(), null, e);
                    break;
                case "w":
                    AKLogFunctions.WarnMessage(getClass(), null, e);
                    break;
                case "v":
                    AKLogFunctions.VerboseMessage(getClass(), null, e);
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_send_mail)
        {
            SendMail();
        }
        return super.onOptionsItemSelected(item);
    }

    private void SendMail() {
        String  details =  "VERSION.RELEASE : "+ Build.VERSION.RELEASE
                +"\nVERSION.INCREMENTAL : "+Build.VERSION.INCREMENTAL
                +"\nVERSION.SDK.NUMBER : "+Build.VERSION.SDK_INT
                +"\nBOARD : "+Build.BOARD
                +"\nBOOTLOADER : "+Build.BOOTLOADER
                +"\nBRAND : "+Build.BRAND
                +"\nCPU_ABI : "+Build.CPU_ABI
                +"\nCPU_ABI2 : "+Build.CPU_ABI2
                +"\nDISPLAY : "+Build.DISPLAY
                +"\nFINGERPRINT : "+Build.FINGERPRINT
                +"\nHARDWARE : "+Build.HARDWARE
                +"\nHOST : "+Build.HOST
                +"\nID : "+Build.ID
                +"\nMANUFACTURER : "+Build.MANUFACTURER
                +"\nMODEL : "+Build.MODEL
                +"\nPRODUCT : "+Build.PRODUCT
                +"\nSERIAL : "+Build.SERIAL
                +"\nTAGS : "+Build.TAGS
                +"\nTIME : "+Build.TIME
                +"\nTYPE : "+Build.TYPE
                +"\nUNKNOWN : "+Build.UNKNOWN
                +"\nUSER : "+Build.USER;

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"aakash.kumar@rsystems.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Test Log Sender");
        emailIntent.putExtra(Intent.EXTRA_TEXT   , details);
        AKLogFunctions.AttachLogFile(mContext, emailIntent);
//        AK.getLogFileURI(mContext, emailIntent);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
//            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
