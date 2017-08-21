package com.dialoglibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.dialoglibrary.R;
import com.github.rahatarmanahmed.cpv.CircularProgressView;


/**
 * Created by admin on 2017-08-17.
 * 自定义带进度的dialog
 */

public class LoadingDialog extends Dialog {
    private Context mContext;


    public LoadingDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_dialog);
        setCanceledOnTouchOutside(false);
        CircularProgressView progressView = (CircularProgressView) findViewById(R.id.progress_view);
        progressView.startAnimation();
    }

    public void show(){
        if (!isShowing()){
            super.show();
        }
    }

    public void dismiss(){
        if (isShowing()){
            super.dismiss();
        }
    }
}
