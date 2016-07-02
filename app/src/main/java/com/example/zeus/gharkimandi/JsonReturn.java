package com.example.zeus.gharkimandi;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Zeus on 4/19/2016.
 */
public class JsonReturn {

    @SerializedName("records")
    public ArrayList<CommodityClass> commodityClassArrayList;
}
