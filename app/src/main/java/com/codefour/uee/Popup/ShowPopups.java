package com.codefour.uee.Popup;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codefour.uee.R;

public class ShowPopups extends Activity {

    /**
     * To show popup create object form ShowPopups class and
     * passe LayoutInflater and View to method
     *
     */

    public ShowPopups( ){

    }




    public PopupWindow ShowSuccesfulPopup(View view , LayoutInflater inflater){
        View popupView = inflater.inflate(R.layout.success_popup, null);


//       RelativeLayout rowLink = (RelativeLayout)getLayoutInflater().inflate(R.layout.success_popup,null);
//        TextView messageText= (TextView)inflater.inflate(R.layout.success_popup, null).findViewById(R.id.successfull_message);
//        messageText.setText("message");

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);


        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        return popupWindow;
    }

    public PopupWindow ShowErrorPopup(View view , LayoutInflater inflater){
        View popupView = inflater.inflate(R.layout.error_popup, null);

        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);


        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });

        return popupWindow;
    }





}
