package com.example.zeus.gharkimandi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.zeus.gharkimandi.R;

public class RateMe extends AppCompatActivity {

    RatingBar bar;
    Button submit;
    TextView result,end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_me);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.rate);

        bar = (RatingBar) findViewById(R.id.ratingBar);
        submit = (Button) findViewById(R.id.btnSubmit);
        result = (TextView) findViewById(R.id.txtRatingValue);
        end = (TextView) findViewById(R.id.end);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void result(View v)
    {
        int stars = (int) bar.getRating();
        if(stars == 1)
        {
            result.setText("Poor ");
            end.setText("Thank you so much for your feedback!!");
        }
        else if(stars == 2)
        {
            result.setText("Satisfactory ");
            end.setText("Thank you so much for your feedback!!");
        }
        else if(stars == 3)
        {
            result.setText("Average ");
            end.setText("Thank you so much for your feedback!!");
        }
        else if(stars == 4)
        {
            result.setText("Good ");
            end.setText("Thank you so much for your feedback!!");
        }
        else if(stars == 5)
        {
            result.setText("Excellent ");
            end.setText("Thank you so much for your feedback!!");
        }
    }

}
