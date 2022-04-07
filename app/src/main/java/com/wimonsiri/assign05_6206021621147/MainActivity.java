package com.wimonsiri.assign05_6206021621147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnTextSwitcher , btnImageSwitcher , btnAdapterViewPipper , btnStackView , btnScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTextSwitcher = (Button) findViewById(R.id.btnTextSwitcher);
        btnImageSwitcher = (Button) findViewById(R.id.btnImageSwitcher);
        btnAdapterViewPipper = (Button) findViewById(R.id.btnAdaperViewFlipper);
        btnStackView = (Button) findViewById(R.id.btnStackView);
        btnScrollView = (Button) findViewById(R.id.btnScrollView);

        btnTextSwitcher.setOnClickListener(this);
        btnImageSwitcher.setOnClickListener(this);
        btnAdapterViewPipper.setOnClickListener(this);
        btnStackView.setOnClickListener(this);
        btnScrollView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(R.id.btnTextSwitcher == id){
            Intent textSwitcherActivity = new Intent(this, TextSwitcherActivity.class);
            startActivity(textSwitcherActivity);
        }
        else if (R.id.btnImageSwitcher == id){
            Intent imageSwitcherActivity = new Intent(this, ImageSwitcherActivity.class);
            startActivity(imageSwitcherActivity);
        }
        else if(R.id.btnAdaperViewFlipper == id){
            Intent adaperViewActivity = new Intent(this,AdaperViewFlipperActivity.class);
            startActivity(adaperViewActivity);
        }
        else if(R.id.btnStackView == id) {
            Intent stackViewActivity = new Intent(this,StackViewActivity.class);
            startActivity(stackViewActivity);
        }
        else if(R.id.btnScrollView == id){
            Intent scrollViewActivity = new Intent(this,ScrollViewActivity.class);
            startActivity(scrollViewActivity);
        }
    }
}