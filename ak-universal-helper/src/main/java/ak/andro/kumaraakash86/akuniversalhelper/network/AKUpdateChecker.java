package ak.andro.kumaraakash86.akuniversalhelper.network;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.util.Log;

import junit.runner.Version;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ak.andro.kumaraakash86.akuniversalhelper.Listeners.shake.AKShakeListener;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;

/**
 * Created by Aakash Kumar on 3/2/2018.
 */

public class AKUpdateChecker {
    static String playStorePath = "https://play.google.com/store/apps/details?id=";
    static String TAG = "AKUpdateChecker";
    int versionToCheck = 0;
    private OnUpdateCallback onUpdateCallback;

    Activity activity;

    public AKUpdateChecker(Activity activity){
        this.activity = activity;
    }

    public interface OnUpdateCallback{
        void onUpdateFound(boolean foundUpdate);
    }

    public void CheckForUpdate(String packageName, String version, OnUpdateCallback callback){
        onUpdateCallback = callback;
        versionToCheck = Integer.valueOf(version.replaceAll("[^\\d]", ""));
        new UpdateCheckTask().execute(packageName);
    }

    public void CheckForUpdate(OnUpdateCallback callback){
        onUpdateCallback = callback;
        String packageName = activity.getPackageName();
        String version = "1";
        try {
            PackageInfo pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
            version = String.valueOf(pInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            AKLogFunctions.ErrorMessage(getClass(), "NameNotFoundException", e);
        }
        versionToCheck = Integer.valueOf(version.replaceAll("[^\\d]", ""));
        new UpdateCheckTask().execute(packageName);
    }

    private class UpdateCheckTask extends AsyncTask<String, Void, String>{
        private String readStream(InputStream is) {
            try {
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                int i = is.read();
                while(i != -1) {
                    bo.write(i);
                    i = is.read();
                }
                return bo.toString();
            } catch (IOException e) {
                return "";
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            String response = null;
            HttpURLConnection urlConnection=null;
            URL url = null;
            try {
                url = new URL(playStorePath+strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                if(urlConnection.getResponseCode() == 200) {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    response = readStream(in);
                }
            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException", e);
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG, "IOException", e);
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            CompareVersions(s);
        }
    }

    private void CompareVersions(String response){
        if(response == null) {
            AKLogFunctions.ErrorMessage(getClass(), null, "Oops!! Looks like this app is not up on play store.");
            return;
        }

        String tagStart =  "<div class=\"content\" itemprop=\"softwareVersion\">";
        String tagEnd = "</div>";
        int version = 0;

        response = response.substring(response.indexOf("<div class=\"content\" itemprop=\"softwareVersion\">")+tagStart.length());
        version = Integer.valueOf(response.substring(0, response.indexOf(tagEnd)).replaceAll("[^\\d]", ""));
        onUpdateCallback.onUpdateFound(version < versionToCheck);
    }
}
