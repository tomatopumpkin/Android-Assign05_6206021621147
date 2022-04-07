package com.wimonsiri.assign05_6206021621147;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.StackView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StackViewActivity extends AppCompatActivity {

    private StackView stackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        stackView = (StackView) findViewById(R.id.stackView);
        stackView.setInAnimation(this, android.R.animator.fade_in);
        stackView.setOutAnimation(this, android.R.animator.fade_out);
        StackViewAdapter albumsAdapter = new StackViewAdapter(this, R.layout.sv_item, getStores());
        stackView.setAdapter(albumsAdapter);
    }

    private List<String> getStores() {
        List<String> stores = new ArrayList<String>();
        stores.add("deosai_land");
        stores.add("dudipatsar_lake");
        stores.add("rama_lake");
        stores.add("shangrila_lower_kachura_lake");
        return stores;
    }
}

class StackViewAdapter extends ArrayAdapter{
    Context context;
    private List<String> storeList;
    private int itemLayout;


    public StackViewAdapter(@NonNull Context ctx, int resource, @NonNull List<String> stores) {
        super(ctx, resource, stores);
        storeList = stores;
        context = ctx;
        itemLayout = resource;
    }

    @Override
    public int getCount(){
        return storeList.size();
    }

    @Override
    public Object getItem(int pos){
        return storeList.get(pos);
    }

    @Override
    public View getView(int position, View view , @NonNull ViewGroup parent){
        if(view == null){
            view = LayoutInflater.from(parent.getContext()).inflate(itemLayout , parent , false);
        }

        String store = storeList.get(position);
        TextView storeName = (TextView) view.findViewById(R.id.sv_name);
        ImageView storeImage = (ImageView) view.findViewById(R.id.sv_image);

        storeName.setText(store);

        int resId = context.getResources().getIdentifier(store , "drawable", context.getPackageName());
        storeImage.setImageResource(resId);

        return view;
    }
}