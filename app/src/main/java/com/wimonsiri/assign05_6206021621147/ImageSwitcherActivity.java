package com.wimonsiri.assign05_6206021621147;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImageSwitcherActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageSwitcher switcher;
    private Button btnNext, btnPrev;

    private static final int[] IMAGES = {
            R.drawable.arsenal_logo,
            R.drawable.chelsea_logo,
            R.drawable.leicester_logo,
            R.drawable.liverpool_logo,
            R.drawable.manchester_city_logo,
            R.drawable.manchester_united_logo
    };

    private  int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);

        btnNext = findViewById(R.id.btnNext_is);
        btnPrev = findViewById(R.id.btnPrev_is);

        switcher = findViewById(R.id.imageSwitcher);

        btnNext.setOnClickListener(this);
        btnPrev.setOnClickListener(this);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.WRAP_CONTENT
                ));

                return imageView;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(R.id.btnNext_is == id) {
            if(pos < IMAGES.length -1 ){
                pos = pos +1;
                switcher.setBackgroundResource(IMAGES[pos]);
                Toast.makeText(this , "Position: " + pos, Toast.LENGTH_SHORT).show();
            }
        }
        else if(R.id.btnPrev_is == id) {
            if(pos > 0) {
                pos = pos -1;
                switcher.setBackgroundResource(IMAGES[pos]);
                Toast.makeText(this,"Position" + pos, Toast.LENGTH_SHORT).show();
            }
        }
    }
}