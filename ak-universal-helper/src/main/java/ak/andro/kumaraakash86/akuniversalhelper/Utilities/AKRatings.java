package ak.andro.kumaraakash86.akuniversalhelper.Utilities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;

import ak.andro.app.akuniversalhelper.R;
import ak.andro.kumaraakash86.akuniversalhelper.Log.AKLogFunctions;
import ak.andro.kumaraakash86.akuniversalhelper.utils.SharedStorage;

/**
 * Created by Aakash Kumar on 3/3/2018.
 */

public class AKRatings {

    public static void ShowRatingDialog(final Context context){

        if (!SharedStorage.getBooleanFromStorage(context, SharedStorage.PREF_KEY_RATING_COMPLETE)) {
            int getCurrentCount = SharedStorage.getIntFromStorage(context, SharedStorage.PREF_KEY_RATING_COUNT);
            getCurrentCount++;
            if (getCurrentCount % context.getResources().getInteger(R.integer.rating_after_every) == 0) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context)
                        .setTitle(R.string.rating_title)
                        .setMessage(R.string.rating_message)
                        .setCancelable(false)
                        .setPositiveButton(R.string.rating_btn_accept, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedStorage.saveBooleanToStorage(context, SharedStorage.PREF_KEY_RATING_COMPLETE, true);

                                try {
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + context.getPackageName()));
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    context.startActivity(intent);
                                } catch (android.content.ActivityNotFoundException anfe) {

                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName()));
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                                    context.startActivity(intent);

                                }
                            }
                        })
                        .setNegativeButton(R.string.rating_btn_later, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setNeutralButton(R.string.rating_btn_cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedStorage.saveBooleanToStorage(context, SharedStorage.PREF_KEY_RATING_COMPLETE, true);
                                dialogInterface.dismiss();
                            }
                        });
                dialog.show();
            }
            SharedStorage.saveIntToStorage(context, SharedStorage.PREF_KEY_RATING_COUNT, getCurrentCount);
        }
    }
}
