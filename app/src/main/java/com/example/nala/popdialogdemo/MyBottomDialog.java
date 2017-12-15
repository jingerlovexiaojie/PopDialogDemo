package com.example.nala.popdialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Nala on 2017/12/14.
 */

public class MyBottomDialog extends Dialog {
    private Context context;
    private TextView text_cancel;
    private TextView text_photo;
    private TextView text_camera;

    public MyBottomDialog( Context context) {
        super(context,R.style.PopupDialog);
        this.context = context;
        setMsgDialog();

    }

    private void setMsgDialog(){
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.bottom_dialog_layout, null);
        text_cancel = (TextView) mView.findViewById(R.id.text_pop_identy_cancel);
        text_photo = (TextView) mView.findViewById(R.id.text_pop_identy_photo);
        text_camera = (TextView) mView.findViewById(R.id.text_pop_identy_camera);

        text_cancel.setOnClickListener(listener);
        text_photo.setOnClickListener(listener);
        text_camera.setOnClickListener(listener);

        //点击外部关闭窗口
        this.setCanceledOnTouchOutside(true);

        Window win = this.getWindow();
        win.setGravity(Gravity.BOTTOM);
        win.getDecorView().setPadding(0,0,0,0);
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        win.setAttributes(lp);

        super.setContentView(mView);

    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.text_pop_identy_cancel:
                      MyBottomDialog.this.dismiss();
                    break;
            }
        }
    };

}
