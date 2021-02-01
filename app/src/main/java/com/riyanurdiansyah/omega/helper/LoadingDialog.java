package com.riyanurdiansyah.omega.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;

import com.riyanurdiansyah.omega.R;

import java.util.Objects;

public class LoadingDialog {

    //inisialisasi
    Activity activity;
    ProgressDialog dialog;

    public LoadingDialog(Activity myActivity) {
        activity = myActivity;
    }

    @SuppressLint("InflateParams")
    public void startLoadingDialog() {
        //inisialisasi dialog
        dialog = new ProgressDialog(activity);
        dialog.show();
        dialog.setContentView(R.layout.layout_loading);
        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }

    public void stopLoadingDialog() {
        dialog.dismiss();
    }
}
