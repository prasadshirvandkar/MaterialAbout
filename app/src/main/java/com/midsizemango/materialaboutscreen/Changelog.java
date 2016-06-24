package com.midsizemango.materialaboutscreen;

/**
 * Created by Prasad on 24/06/16.
 */
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;


public class Changelog {
    private static final String LOG_TAG = "WhatsNewScreen";

    private static final String LAST_VERSION_CODE_KEY = "last_version_code";

    private Activity mActivity;

    // Constructor for the calling Activity ("context")
    public Changelog(Activity context) {
        mActivity = context;
    }

    // Show the dialog only if not already shown for this version of the application
    public void show() {
        try {
            // Get the versionCode of the Package, which must be different (incremented) in each release on the market in the AndroidManifest.xml
            final PackageInfo packageInfo = mActivity.getPackageManager().getPackageInfo(mActivity.getPackageName(), PackageManager.GET_ACTIVITIES);
            final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(mActivity);

            final long lastVersionCode = prefs.getLong(LAST_VERSION_CODE_KEY, 0);
            if (packageInfo.versionCode != lastVersionCode) {
                Log.i(LOG_TAG, "versionCode " + packageInfo.versionCode + "is different from the last known version " + lastVersionCode);
                final String title = "What's New" + "  v" + packageInfo.versionName;
                // Show the News since last version
                WebView webView = new WebView(mActivity);
                webView.loadUrl("file:///android_asset/changelog");

                final Dialog dialog = new Dialog(mActivity);
                dialog.setCancelable(false);
                dialog.setTitle(title);
                dialog.setContentView(webView);
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putLong(LAST_VERSION_CODE_KEY,packageInfo.versionCode);
                        editor.commit();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            } else {
                Log.i(LOG_TAG, "versionCode " + packageInfo.versionCode + "is already known");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

}