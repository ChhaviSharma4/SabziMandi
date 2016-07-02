package com.example.zeus.gharkimandi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.zeus.gharkimandi.R;

import java.util.ArrayList;

public class Prices extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    ArrayList<CommodityClass> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prices);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();
        data = (ArrayList<CommodityClass>) i.getSerializableExtra("data");
        Log.i("check",String.valueOf(data.size()));
        recyclerView = (RecyclerView) findViewById(R.id.data);
        adapter = new RecyclerAdapter(this,data);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(linearLayoutManager);
    }

//    public static List<CommodityClass> getData()
//    {
//        List<CommodityClass> data;
//
//
//
//        return data;
//    }

}
