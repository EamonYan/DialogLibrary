package com.dialoglibrary.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.dialoglibrary.R;

/**
 * Created by admin on 2017-08-21.
 */

public class RemindDialog extends Dialog implements View.OnClickListener {
    private TextView contentTxt;
    private TextView titleTxt;
    private TextView submitTxt;
    private TextView cancelTxt;

    private Context mContext;
    private String content;
    private OnCloseListener listener;
    private String positiveName;
    private String negativeName;
    private String title;

    public RemindDialog(Context context) {
        super(context, R.style.dialog);
        this.mContext = context;
    }

    public RemindDialog(Context context, OnCloseListener listener) {
        super(context, R.style.dialog);
        this.mContext = context;
        this.listener = listener;
    }

    public RemindDialog setTitle(String title){
        this.title = title;
        return this;
    }

    public RemindDialog setContent(String content){
        this.content = content;
        return this;
    }

    public RemindDialog setPositiveButton(String name){
        this.positiveName = name;
        return this;
    }

    public RemindDialog setNegativeButton(String name){
        this.negativeName = name;
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_remind);
        setCanceledOnTouchOutside(false);
        initView();
    }

    private void initView(){
        contentTxt = (TextView)findViewById(R.id.content);
        titleTxt = (TextView)findViewById(R.id.title);
        submitTxt = (TextView)findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView)findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);

        if(!TextUtils.isEmpty(content)){
            contentTxt.setText(content);
        }
        if(!TextUtils.isEmpty(positiveName)){
            submitTxt.setText(positiveName);
        }

        if(!TextUtils.isEmpty(negativeName)){
            cancelTxt.setText(negativeName);
        }

        if(!TextUtils.isEmpty(title)){
            titleTxt.setText(title);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cancel){
            if(listener != null){
                listener.onClick(this, false);
            }
            this.dismiss();
        }else if(v.getId() == R.id.submit){
            if(listener != null){
                listener.onClick(this, true);
            }
            this.dismiss();
        }
    }

    public interface OnCloseListener{
        void onClick(Dialog dialog, boolean confirm);
    }
}
