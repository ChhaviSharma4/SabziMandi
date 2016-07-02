package com.example.zeus.gharkimandi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.zeus.gharkimandi.Contract.ContractAPIConstants;
import com.example.zeus.gharkimandi.Networking.ApiClient;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{


    private SliderLayout mDemoSlider;
    String chosenState,chosenMandi;
    ArrayList<String> mandiNamesList;
    ArrayList<CommodityClass> mandiCommodityList;
    private ShareActionProvider mShareActionProvider;
    private Button stateChoose,mandiChoose;
    Button okButton;
    public String[] statesNames;
    final String appUrl = "https://play.google.com/store/apps/details?id=app.tasknearby.yashcreations.com.tasknearby";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setIcon(R.mipmap.fruit);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        stateChoose = (Button) findViewById(R.id.stateSelection);
        mandiChoose = (Button) findViewById(R.id.mandiSelection);
        mandiChoose.setClickable(false);
        okButton=(Button) findViewById(R.id.ok);
        okButton.setClickable(false);
        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Shop Wise, Be Wise",R.drawable.image1);
        file_maps.put("Naap Tol Kiya Kya!",R.drawable.image2);
        file_maps.put("Know Prices Before Shopping",R.drawable.image3);
        file_maps.put("Latest Prices At Your Fingertips", R.drawable.image4);
        file_maps.put("Eat Healthy, Stay Healthy",R.drawable.image5);

        for(String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mDemoSlider.addSlider(textSliderView);
            mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
            mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            mDemoSlider.setCustomAnimation(new DescriptionAnimation());
            mDemoSlider.setDuration(4000);
            mDemoSlider.addOnPageChangeListener(this);


            statesNames= fillStatesArrayList();
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        MyAsyncTask myAsyncTask=new MyAsyncTask();
//        myAsyncTask.execute();
//        myAsyncTask.setMyAsyncTaskListener(this);




    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

//        if (id == R.id.menu_item_share) {
//            // Locate MenuItem with ShareActionProvider
//            //mShareActionProvider = (ShareActionProvider) getActionProvider();
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rate) {

            Intent i = new Intent(this, RateMe.class);
            startActivity(i);

        } else if (id == R.id.nav_statistics) {

            Intent i = new Intent(this, Statistics.class);
            startActivity(i);

        } else if (id == R.id.nav_aboutus) {

            Intent i = new Intent(this, AboutUs.class);
            startActivity(i);

        } else if (id == R.id.nav_share) {

            Intent intent = new Intent(Intent.ACTION_SEND);
            String m = "Hey!Try out the all new Sabzi Mandi app.The app is a useful utility for common man which provides details of prices of various commodities across all the markets in their state.\nVisit: " + appUrl;
            intent.setType("text/plain");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            intent.putExtra(Intent.EXTRA_TEXT, m);
            if (intent.resolveActivity(MainActivity.this.getPackageManager()) != null)
                startActivity(intent);
            else
                Toast.makeText(MainActivity.this, "No App found to share the Details!", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_contactus) {

            Intent i = new Intent(this, ContactUs.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }





    public void stateChoose(View v)
    {

        new MaterialDialog.Builder(MainActivity.this)
                .title("States")
                .items(statesNames)
                .backgroundColor(getResources().getColor(R.color.background))
                .itemsColor(getResources().getColor(R.color.text))
                .contentColor(getResources().getColor(R.color.text))
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int position, CharSequence text) {

                        chosenState=text.toString();
                        stateChoose.setText(chosenState);

                        Call<JsonReturn> getMandiListCall= ApiClient.getApiInterface().getMandiListFromState(ContractAPIConstants.API_KEY,"market",ContractAPIConstants.RESOURCE_ID,chosenState);
                        getMandiListCall.enqueue(new Callback<JsonReturn>() {
                            @Override
                            public void onResponse(Call<JsonReturn> call, Response<JsonReturn> response) {
                                if(response.isSuccessful()&&response.body().commodityClassArrayList.size()>0){
                                    mandiNamesList=new ArrayList<String>();
                                    ArrayList<CommodityClass> temp=response.body().commodityClassArrayList;
                                    for(int i=0;i<temp.size();++i){
                                        if(!mandiNamesList.contains(temp.get(i).market))
                                            mandiNamesList.add(temp.get(i).market);
//                                        Log.i("check",temp.get(i).market);
                                    }
                                    Toast.makeText(MainActivity.this, "Choose Mandi Now", Toast.LENGTH_SHORT).show();
                                    Log.i("phase1", "Mandi search success");
                                    mandiChoose.setClickable(true);

                                }else{
                                    Log.i("phase1", "Mandi search unsuccess");
                                    Toast.makeText(MainActivity.this, "data for Mandis in "+chosenState+" state is currently unavailable, try after some time", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonReturn> call, Throwable t) {
                                Log.i("phase1", "Mandi search failed");
                                Toast.makeText(MainActivity.this, "Please check ur Internet Connection, Mandi List couldn't be loaded", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                })
                .show();


    }

    public void mandiChoose(View v)
    {
        new MaterialDialog.Builder(this)
                .title("Mandi")
                .items(mandiNamesList)
                .backgroundColor(getResources().getColor(R.color.background))
                .itemsColor(getResources().getColor(R.color.text))
                .contentColor(getResources().getColor(R.color.text))
                .itemsCallback(new MaterialDialog.ListCallback() {

                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int position, CharSequence text) {
                        chosenMandi=text.toString();
                        mandiChoose.setText(chosenMandi);
                        i = new Intent(MainActivity.this, LastActivity.class);


                        Call<JsonReturn> mandiInfocall=ApiClient.getApiInterface().getCommodityFromMandi(ContractAPIConstants.API_KEY,ContractAPIConstants.RESOURCE_ID,chosenMandi);
                        mandiInfocall.enqueue(new Callback<JsonReturn>() {
                            @Override
                            public void onResponse(Call<JsonReturn> call, Response<JsonReturn> response) {
                                if(response.isSuccessful()&&response.body().commodityClassArrayList.size()>0) {
                                    Log.i("phase2", "success");
                                    mandiCommodityList=new ArrayList<CommodityClass>();
                                    mandiCommodityList=response.body().commodityClassArrayList;
                                    i.putExtra("data",mandiCommodityList);
                                    Toast.makeText(MainActivity.this, "Click OK", Toast.LENGTH_SHORT).show();
                                    okButton.setClickable(true);
                                }else{
                                    Log.i("phase2","unsuccess");
                                    Toast.makeText(MainActivity.this, "No commodities available from current mandi, try after some time", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<JsonReturn> call, Throwable t) {
                                Log.i("phase2","fail");
                                Toast.makeText(MainActivity.this, "Please check ur Internet Connection, Commodities couldn't be loaded", Toast.LENGTH_LONG).show();
                            }
                        });

                    }
                })
                .show();

    }
    Intent i;
    public void ok(View v)
    {
        startActivity(i);
    }




    private String[] fillStatesArrayList(){
        String[] temp
                ={"Andaman and Nicobar",
                "Andhra Pradesh",
                "Arunachal Pradesh",
                "Assam",
                "Bihar",
                "Chandigarh",
                "Chattisgarh",
                "Dadra and Nagar Haveli",
                "Daman and Diu",
                "Goa",
                "Gujarat",
                "Haryana",
                "Himachal Pradesh",
                "Jammu and Kashmir",
                "Jharkhand",
                "Karnataka",
                "Kerala",
                "Lakshadweep",
                "Madhya Pradesh",
                "Maharashtra",
                "Manipur",
                "Meghalaya",
                "Mizoram",
                "Nagaland",
                "NCT of Delhi",
                "NR",
                "Orissa",
                "Pondicherry",
                "Punjab",
                "Rajasthan",
                "Sikkim",
                "Tamil Nadu",
                "Telangana",
                "Tripura",
                "Uttar Pradesh",
                "Uttrakhand",
                "West Bengal"};
        return temp;
    }

}
