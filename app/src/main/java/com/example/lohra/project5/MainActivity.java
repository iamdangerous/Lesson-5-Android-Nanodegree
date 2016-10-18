package com.example.lohra.project5;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {

    AppCompatButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (AppCompatButton)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnClickBtn(view);
            }
        });
    }

    public void OnClickBtn(View v){

        int accent = ContextCompat.getColor(this,R.color.colorAccent);
//        v.getBackground() ;
//        ContextCompat.getDrawable(this,R.color.colorAccent)
        boolean isAccent = (v.getBackground() !=null ) && ((v.getBackground()) == ContextCompat.getDrawable(this,R.color.colorAccent));

//        boolean isAccent = ((v.getBackground()) != null && ((ColorDrawable)v.getBackground()).getColor() == accent);
//
//        v.getBackground().get


//        boolean isAccent = false;
                if(v.getBackground()!=null){

                    if(v.getBackground() instanceof ColorDrawable){
                        Log.d("Main","Instance of Color drawable, isAccent="+String.valueOf(isAccent));
                        if(((ColorDrawable)v.getBackground()).getColor() == accent){
                            isAccent = true;
                        }else isAccent = false;
                    }

                    if(v.getBackground() instanceof RippleDrawable){
                        Log.d("Main","Instance of Ripple drawable, isAccent="+String.valueOf(isAccent));
//                        v.getBackground().getColorFilter();
                    }
                }


        int finalRadious =(int) Math.hypot(v.getWidth()/2,v.getHeight()/2);

        if(isAccent){
            v.setBackgroundColor(ContextCompat.getColor(this,R.color.colorBlue));
        }else {

            Animator animator =
                    null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                animator = ViewAnimationUtils.createCircularReveal(v,(int)v.getWidth()/2,(int)v.getHeight()/2,0,finalRadious);
            }
            v.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
                    animator.start();
        }
    }
}
