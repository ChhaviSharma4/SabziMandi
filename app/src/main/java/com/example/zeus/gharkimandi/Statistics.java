package com.example.zeus.gharkimandi;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.zeus.gharkimandi.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Statistics extends AppCompatActivity {

    WebView webView;
    ProgressDialog mProgressDialog;
    String url="http://agmarknet.dac.gov.in/CommodityWiseGraph/ComGraphBoard.aspx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        webView= (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();

//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);

        mProgressDialog = new ProgressDialog(Statistics.this);
        mProgressDialog.setTitle("Loading Database From Server");
        mProgressDialog.setMessage("Loading...");
//        mProgressDialog.setIndeterminate(false);
        mProgressDialog.show();

        new Description().execute();
    }

    private class Description extends AsyncTask<Void, Void, Void> {

        Elements ele;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }
        StringBuffer html;
        @Override
        protected Void doInBackground(Void... params) {
            try {
                html=new StringBuffer();
                // Connect to the web site
                Document document = Jsoup.connect(url).get();

                ele=document.select("div#cphBody_Updatepanel1");
                html.append(ele.toString());

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

                try {
                    if ((mProgressDialog != null) && mProgressDialog.isShowing()) {
                        mProgressDialog.dismiss();

                    }
                } catch (final IllegalArgumentException e) {
                    // Handle or log or ignore
                } catch (final Exception e) {
                    // Handle or log or ignore
                } finally {
                    mProgressDialog = null;
                    String mime = "text/html";
                    String encoding = "utf-8";
                    webView.loadDataWithBaseURL(url,html.toString(), mime,encoding,url);
                }



//            mProgressDialog.dismiss();
//            Log.i("check1",html.);
//            String mime = "text/html";
//            String encoding = "utf-8";
//            webView.loadDataWithBaseURL(url,html.toString(), mime,encoding,url);


//            webView.loadUrl(url);

        }
    }

}
