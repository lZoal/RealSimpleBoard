package com.example.realsimpleboard.Custom;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.example.realsimpleboard.R;

public class CustomButton extends AppCompatButton {
    public CustomButton(Context context) {
        super(context);
        init();

    }
    public CustomButton(Context context, AttributeSet attrs) {
        super(context,attrs);
        init();

    }
    private void init(){
        float fontSize = getResources().getDimension(R.dimen.textSize);
        setTextSize(fontSize);
        setBackgroundColor(Color.YELLOW);
    }
}
