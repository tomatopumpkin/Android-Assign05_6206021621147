package com.wimonsiri.assign05_6206021621147;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class TextSwitcherActivity extends AppCompatActivity {

    private TextSwitcher switcher;
    private Button btnPrev , btnNext;

    private static final String[] TEXT = {
            "When in Rome, do as the Romans",
            "The squeaky wheel gets the grease",
            "Two wrongs don't make a right",
            "Hope for the best, but prepare for the worst",
            "A picture is worth a thousand words"
    };
    private int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);

        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        switcher = (TextSwitcher) findViewById(R.id.textSwitcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                return textView;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos < TEXT.length - 1){
                    pos = pos + 1;
                    switcher.setText(TEXT[pos]);
                }
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos > 0 ){
                    pos = pos -1 ;
                    switcher.setText(TEXT[pos]);
                }
            }
        });
    }
}