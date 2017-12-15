package com.example.nala.popdialogdemo;


import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Nala on 2017/12/14.
 */

public class MyDialog extends Dialog  {
    private  TextView positiveButton;
    private TextView negativeButton;
    public MyDialog(@NonNull Context context) {
        super(context,R.style.MyDialog);
        setMsgDialog();
    }

    private void setMsgDialog() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_layout, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        positiveButton = (TextView) view.findViewById(R.id.positiveButton);
        negativeButton = (TextView) view.findViewById(R.id.negativeButton);
        if(positiveButton != null) {
            positiveButton.setOnClickListener(listener);
        }
        if(negativeButton != null){
            negativeButton.setOnClickListener(listener);
        }
        super.setContentView(view);
    }

     private View.OnClickListener listener = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             MyDialog.this.dismiss();
         }
     };

    public void setOnPostiveListener(View.OnClickListener listener){
        positiveButton.setOnClickListener(listener);
    }

    public void setOnNegativeListener(View.OnClickListener listener){
        negativeButton.setOnClickListener(listener);
    }

    @Override
    public void show() {
        super.show();
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //获取屏幕的宽度
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        //设置高度
        lp.width = (int) (screenWidth * 0.75);
        lp.height = (int) (lp.width * 0.65);
        dialogWindow.setAttributes(lp);
    }
}
