package com.dialoglibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;



/**
 * Created by admin on 2017-08-17.
 */

public class CustomProgressDialog extends Dialog {
    private Context mContext;
    private CircleProgressView mCircleProgressView;


    public CustomProgressDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_progress_dialog);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        mCircleProgressView = (CircleProgressView) findViewById(R.id.circleProgressbar);
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
