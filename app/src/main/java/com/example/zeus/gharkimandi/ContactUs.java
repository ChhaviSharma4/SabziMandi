package com.example.zeus.gharkimandi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.zeus.gharkimandi.R;

public class ContactUs extends AppCompatActivity {

    EditText message,name,phone_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.contact);

        message = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText);
        phone_no = (EditText) findViewById(R.id.editText3);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    public void submit(View view)
    {
        String test = "Feedback from " + name.getText().toString() + " ";
        String phone = "whose phone number is: "+phone_no.getText().toString()+ " ";
        String text = test + phone+ "and message is: "+ message.getText().toString();
        Intent i = new Intent(android.content.Intent.ACTION_SEND);
        Intent chooser;
        i.setData(Uri.parse("mailto:"));
        String[] to={"rishi_madhok@hotmail.com"};
        i.putExtra(Intent.EXTRA_EMAIL, to);
        i.putExtra(Intent.EXTRA_SUBJECT, "User Feedback");
        i.putExtra(Intent.EXTRA_TEXT, text);
        i.setType("message/rfc822");
        chooser = Intent.createChooser(i, "Send email");
        startActivity(chooser);

    }

}
