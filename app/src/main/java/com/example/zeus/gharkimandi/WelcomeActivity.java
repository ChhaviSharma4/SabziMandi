package com.example.zeus.gharkimandi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.zeus.gharkimandi.R;
import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class WelcomeActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private HTextView hTextView;
    private TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();
        // To track statistics around application
//        ParseAnalytics.trackAppOpened(getIntent());


//        final String[] sentences = new String[]{"CONNECTING ", "DREAMS ", "FOUNDATION "};
        hTextView = (HTextView) findViewById(R.id.cooltext);

        hTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        });

        hTextView.setAnimateType(HTextViewType.LINE);
        hTextView.animateText("SABZI MANDI");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();

            }
        }, 2000);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.CENTER);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        return t;
    }



}
