package com.dialoglibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.dialoglibrary.R;


/**
 * Created by admin on 2017-08-17.
 * 自定义带进度的dialog
 */

public class CProgressDialog extends Dialog {
    private Context mContext;
    private CircleProgress mCircleProgressView;


    public CProgressDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_progress_dialog);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        mCircleProgressView = (CircleProgress) findViewById(R.id.circleProgressbar);
        mCircleProgressView.setMaxProgress(100);
        mCircleProgressView.setProgress(0);
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
    public void setProgress(int progress){
        mCircleProgressView.setProgress(progress);
    }
}
