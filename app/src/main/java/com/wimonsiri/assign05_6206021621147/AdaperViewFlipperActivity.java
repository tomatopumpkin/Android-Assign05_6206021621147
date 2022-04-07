package com.wimonsiri.assign05_6206021621147;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaperViewFlipperActivity extends AppCompatActivity {

    private AdapterViewFlipper adapterViewFlipper;
    private int[] IMAGES = {
            R.drawable.deosai_land,
            R.drawable.dudipatsar_lake,
            R.drawable.rama_lake,
            R.drawable.shangrila_lower_kachura_lake
    };
    private String[] NAMES = {
            "deosai_land",
            "dudipatsar_lake",
            "rama_lake",
            "shangrila_lower_kachura_lake"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaper_view_flipper);

        adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.adapterViewFilpper);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext() , IMAGES , NAMES);
        adapterViewFlipper.setAdapter(customAdapter);
        adapterViewFlipper.setFlipInterval(3000);
        adapterViewFlipper.setAutoStart(true);
    }
}

class CustomAdapter extends BaseAdapter{
    Context context ;
    int [] images;
    String [] names;
    LayoutInflater inflater;

    public CustomAdapter(Context appContext, int[] images , String[] names){
        this.context = appContext;
        this.images = images;
        this.names = names;
        inflater= (LayoutInflater.from(appContext)) ;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.avf_list_item , null);
        TextView name = (TextView) view.findViewById(R.id.avf_name);
        ImageView image = (ImageView) view.findViewById(R.id.avf_image);

        name.setText(names[i]);
        image.setImageResource(images[i]);

        return view;
    }
}