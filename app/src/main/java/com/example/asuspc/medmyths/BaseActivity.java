package com.example.asuspc.medmyths;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus pc on 19/03/2018.
 */

public class BaseActivity extends AppCompatActivity {
    private static Boolean isVisible;
    private static boolean mIsInForegroundMode;
    MaterialDialog progressDialog;
    MaterialDialog alertDialog;

    Activity mActivity = this;
    Toolbar mToolbar;

    TextView tvTitle;

    @Override
    protected void onStart() {
        super.onStart();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
        mIsInForegroundMode = false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
        mIsInForegroundMode = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isVisible = false;
    }

    public static boolean isViewVisible() {
        return isVisible;
    }

    public static boolean isInForeground() {
        return mIsInForegroundMode;
    }

    protected void showProgressDialog(String message) {
        progressDialog = new MaterialDialog.Builder(this)
                .content(message)
                .cancelable(true)
                .progress(true, 0).build();
        progressDialog.show();
    }

    protected void showMaterialDialogAlert(int content) {
        new MaterialDialog.Builder(mActivity)
                .title(R.string.alert)
                .content(content)
                .positiveText(R.string.ok)
                .cancelable(false)
                .show();
    }

    protected void showMaterialDialogAlert(String content) {
        new MaterialDialog.Builder(mActivity)
                .title(R.string.alert)
                .content(content)
                .positiveText(R.string.ok)
                .cancelable(false)
                .show();
    }


    protected
    @StringRes
    int getToolbarTitle() {
        return R.string.app_name;
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
