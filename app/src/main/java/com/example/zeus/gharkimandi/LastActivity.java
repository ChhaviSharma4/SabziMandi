package com.example.zeus.gharkimandi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.zeus.gharkimandi.R;

import java.util.ArrayList;

public class LastActivity extends AppCompatActivity {

    ArrayList<CommodityClass> data;
    CommodityAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent i = getIntent();
        data = (ArrayList<CommodityClass>) i.getSerializableExtra("data");
        Log.i("check",String.valueOf(data.size()));
        ListView lv=(ListView) findViewById(R.id.lastActivityListView);
        adapter= new CommodityAdapter(this,data);
        lv.setAdapter(adapter);
    }
}
